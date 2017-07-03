package com.oukingtim.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.oukingtim.domain.SysMenu;
import com.oukingtim.domain.SysRoleMenu;
import com.oukingtim.mapper.SysMenuMapper;
import com.oukingtim.mapper.SysRoleMenuMapper;
import com.oukingtim.service.SysMenuService;
import com.oukingtim.util.MenuTreeUtil;
import com.oukingtim.web.vm.JsTreeVM;
import com.oukingtim.web.vm.MenuVM;
import com.oukingtim.web.vm.TreeStateVM;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by oukingtim
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Override
    public List<JsTreeVM> getMenuTree(String roleId) {
        List<JsTreeVM> treeVoList = new ArrayList<>();
        EntityWrapper<SysMenu> wrapper = new EntityWrapper<SysMenu>();
        wrapper.orderBy("sys_menu.order");
        List<SysMenu> menuList = selectList(wrapper);
        List<String> menuIds = new ArrayList<>();
        if (StringUtils.isNotBlank(roleId)) {
            menuIds = sysRoleMenuMapper.selectMenuIdsByRoleId(roleId);
        }
        for (SysMenu sysMenu : menuList) {
            JsTreeVM jsTreeVM = new JsTreeVM();
            jsTreeVM.setId(sysMenu.getId());
            jsTreeVM.setParent(sysMenu.getParentId()==null?"#":sysMenu.getParentId());
            jsTreeVM.setText(sysMenu.getTitle());
            jsTreeVM.setIcon(sysMenu.getIcon());
            TreeStateVM state = new TreeStateVM();
            if (menuIds.size()>0&&menuIds.contains(sysMenu.getId())){
                state.setSelected(true);
            }
            jsTreeVM.setState(state);
            treeVoList.add(jsTreeVM);
        }
        return treeVoList;
    }

    @Override
    public boolean insert(SysMenu entity) {
        boolean flag = super.insert(entity);

        //自动分配给拥有父菜单的角色权限
        List<SysRoleMenu> roleMenuList = sysRoleMenuMapper.selectList(
                new EntityWrapper<>(new SysRoleMenu(entity.getParentId())));
        for (SysRoleMenu roleMenu: roleMenuList){
            SysRoleMenu sysRoleMenu = new SysRoleMenu();
            sysRoleMenu.setMenuId(entity.getId());
            sysRoleMenu.setRoleId(roleMenu.getRoleId());
            sysRoleMenuMapper.insert(sysRoleMenu);
        }
        return flag;
    }

    @Override
    public Set<String> getPermissions(String userId) {

        List<String> menuList = baseMapper.getPermissions(userId);
        //用户权限列表
        Set<String> permsSet = new HashSet<String>();
        for(String perm : menuList){
            if(StringUtils.isBlank(perm)){
                continue;
            }
            permsSet.addAll(Arrays.asList(perm.trim().split(",")));
        }
        return permsSet;
    }

    @Override
    public List<MenuVM> getMenu(String userId) {
        List<SysMenu> menuList = baseMapper.selectMenuByUserId(userId);
        return MenuTreeUtil.getMenu(menuList);
    }
}
