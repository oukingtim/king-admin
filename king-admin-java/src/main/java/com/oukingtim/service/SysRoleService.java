package com.oukingtim.service;

import com.baomidou.mybatisplus.service.IService;
import com.oukingtim.domain.SysRole;

import java.util.List;

/**
 * Created by oukingtim
 */
public interface SysRoleService extends IService<SysRole> {
    /**
     * 根据用户id查询角色集合
     * @param userId
     * @return
     */
    List<SysRole> getList(String userId);
}
