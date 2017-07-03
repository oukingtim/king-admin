package com.oukingtim.util

import com.oukingtim.domain.SysMenu
import com.oukingtim.web.vm.MenuVM
import java.util.ArrayList

/**
 * Created by oukingtim
 */
object MenuTreeUtil {
    fun getTree(list: List<SysMenu>): MenuVM? {

        if (list == null || list.size < 1) return null
        return buildTree(getRoot(list)!!, list)
    }

    private fun buildTree(pnode: MenuVM, nodes: List<SysMenu>): MenuVM {
        val childs = ArrayList<MenuVM>()
        for (tmp in nodes) {
            if (pnode.id == tmp.parentId) {
                childs.add(MenuVM(tmp))
            }
        }

        if (childs.size > 0) {
            pnode.subMenu = childs
            for (ptmp in childs) {
                buildTree(ptmp, nodes)
            }
        }
        return pnode
    }

    private fun getRoot(list: List<SysMenu>): MenuVM? {
        for (po in list) {
            if ("#" == po.parentId) {
                return MenuVM(po)
            }
        }
        return null
    }

    fun getMenu(list: List<SysMenu>?): List<MenuVM>? {

        if (list == null || list.size < 1) return null

        return if (getTree(list) == null) null else getTree(list)!!.subMenu
    }
}