package com.oukingtim.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.oukingtim.domain.SysRole;
import com.oukingtim.domain.SysUser;
import com.oukingtim.domain.SysUserRole;
import com.oukingtim.mapper.SysUserMapper;
import com.oukingtim.mapper.SysUserRoleMapper;
import com.oukingtim.service.SysUserService;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by oukingtim
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper,SysUser> implements SysUserService {
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public boolean insert(SysUser entity) {
        String password = new Sha256Hash(entity.getPassword()).toHex();
        entity.setPassword(password);
        boolean flag = super.insert(entity);
        if (entity.getRolelist()!=null&&entity.getRolelist().size()>0) {
            for (SysRole role : entity.getRolelist()) {
                if (role.getChecked() != null && role.getChecked()) {
                    SysUserRole sysUserRole = new SysUserRole();
                    sysUserRole.setUserId(entity.getId());
                    sysUserRole.setRoleId(role.getId());
                    sysUserRoleMapper.insert(sysUserRole);
                }
            }
        }
        return flag;
    }

    @Override
    public boolean updateById(SysUser entity) {
        boolean flag = super.updateById(entity);
        SysUserRole userRole = new SysUserRole();
        userRole.setUserId(entity.getId());
        if (entity.getRolelist()!=null&&entity.getRolelist().size()>0) {
            sysUserRoleMapper.delete(new EntityWrapper<>(userRole));
            if(entity.getRolelist()!=null) {
                for (SysRole role : entity.getRolelist()) {
                    if (role.getChecked() != null && role.getChecked()) {
                        SysUserRole sysUserRole = new SysUserRole();
                        sysUserRole.setUserId(entity.getId());
                        sysUserRole.setRoleId(role.getId());
                        sysUserRoleMapper.insert(sysUserRole);
                    }
                }
            }
        }
        return flag;
    }

    @Override
    public SysUser findByUserName(String username) {
        List<SysUser> list = selectList(new EntityWrapper<>(new SysUser(username)));
        if (list!=null&&list.size()>0){
            return list.get(0);
        }
        return null;
    }
}
