package com.oukingtim.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.oukingtim.domain.SysRole;
import com.oukingtim.domain.SysRoleMenu;
import com.oukingtim.mapper.SysRoleMapper;
import com.oukingtim.mapper.SysRoleMenuMapper;
import com.oukingtim.mapper.SysUserRoleMapper;
import com.oukingtim.service.SysRoleService;
import com.oukingtim.web.vm.JsTreeVM;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by oukingtim
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper,SysRole> implements SysRoleService {

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;
    @Override
    public List<SysRole> getList(String userId) {
        List<SysRole> roleList = selectList(new EntityWrapper<>());
        if (StringUtils.isNotBlank(userId)){
            List<String> list = sysUserRoleMapper.selectRoleIdsByUserId(userId);
            for (SysRole role: roleList){
                if(list.contains(role.getId())){
                    role.setChecked(true);
                }
            }
        }
        return roleList;
    }

    @Override
    public boolean insert(SysRole entity) {
        boolean flag = super.insert(entity);
        for (JsTreeVM jsTreeVM : entity.getMenuTree()){
            SysRoleMenu sysRoleMenu = new SysRoleMenu();
            sysRoleMenu.setRoleId(entity.getId());
            sysRoleMenu.setMenuId(jsTreeVM.getId());
            sysRoleMenuMapper.insert(sysRoleMenu);
        }
        return flag;
    }

    @Override
    public boolean updateById(SysRole entity) {
        boolean flag = super.updateById(entity);
        SysRoleMenu roleMenu = new SysRoleMenu();
        roleMenu.setRoleId(entity.getId());
        sysRoleMenuMapper.delete(new EntityWrapper<>(roleMenu));
        for (JsTreeVM jsTreeVM : entity.getMenuTree()){
            SysRoleMenu sysRoleMenu = new SysRoleMenu();
            sysRoleMenu.setRoleId(entity.getId());
            sysRoleMenu.setMenuId(jsTreeVM.getId());
            sysRoleMenuMapper.insert(sysRoleMenu);
        }
        return flag;
    }
}
