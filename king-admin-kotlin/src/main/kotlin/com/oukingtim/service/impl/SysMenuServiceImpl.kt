package com.oukingtim.service.impl

import com.baomidou.mybatisplus.mapper.EntityWrapper
import com.baomidou.mybatisplus.service.impl.ServiceImpl
import com.oukingtim.domain.SysMenu
import com.oukingtim.mapper.SysMenuMapper
import com.oukingtim.mapper.SysRoleMenuMapper
import com.oukingtim.service.SysMenuService
import com.oukingtim.util.MenuTreeUtil
import com.oukingtim.web.vm.JsTreeVM
import com.oukingtim.web.vm.MenuVM
import com.oukingtim.web.vm.TreeStateVM
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

/**
 * Created by oukingtim
 */
@Service
class SysMenuServiceImpl : ServiceImpl<SysMenuMapper, SysMenu>(), SysMenuService {

    @Autowired
    private val sysRoleMenuMapper: SysRoleMenuMapper? = null

    override fun getMenuTree(roleId: String): List<JsTreeVM> {
        val treeVoList = ArrayList<JsTreeVM>()
        val wrapper = EntityWrapper<SysMenu>()
        wrapper.orderBy("sys_menu.order")
        val menuList = selectList(wrapper)
        var menuIds: List<String> = ArrayList()
        if (!roleId.isNullOrBlank()) {
            menuIds = sysRoleMenuMapper!!.selectMenuIdsByRoleId(roleId)
        }
        for (sysMenu in menuList) {
            val jsTreeVM = JsTreeVM()
            jsTreeVM.id = sysMenu.id
            jsTreeVM.parent = if (sysMenu.parentId.isNullOrBlank()) "#" else sysMenu.parentId
            jsTreeVM.text = sysMenu.title
            jsTreeVM.icon = sysMenu.icon
            val state = TreeStateVM()
            if (menuIds.size > 0 && menuIds.contains(sysMenu.id)) {
                state.selected = true
            }
            jsTreeVM.state = state
            treeVoList.add(jsTreeVM)
        }
        return treeVoList
    }

    override fun getPermissions(userId: String): Set<String> {
        val menuList = baseMapper.getPermissions(userId)
        //用户权限列表
        val permsSet = HashSet<String>()
        for (perm in menuList) {
            if (perm.isNullOrBlank()) {
                continue
            }
            permsSet.addAll(Arrays.asList(*perm.trim { it <= ' ' }.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()))
        }
        return permsSet
    }

    override fun getMenu(userId: String) = MenuTreeUtil.getMenu(baseMapper.selectMenuByUserId(userId))!!
}