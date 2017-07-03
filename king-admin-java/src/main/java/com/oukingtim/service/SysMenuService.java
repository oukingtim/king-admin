package com.oukingtim.service;

import com.baomidou.mybatisplus.service.IService;
import com.oukingtim.domain.SysMenu;
import com.oukingtim.web.vm.JsTreeVM;
import com.oukingtim.web.vm.MenuVM;

import java.util.List;
import java.util.Set;

/**
 * Created by oukingtim
 */
public interface SysMenuService extends IService<SysMenu> {

    /**
     * 根据角色id获取菜单树
     * @param roleId
     * @return
     */
    List<JsTreeVM> getMenuTree(String roleId);

    /**
     * 根据用户id获取权限集合
     * @param userId
     * @return
     */
    Set<String> getPermissions(String userId);

    /**
     * 根据用户id获取菜单
     * @param userId
     * @return
     */
    List<MenuVM> getMenu(String userId);
}
