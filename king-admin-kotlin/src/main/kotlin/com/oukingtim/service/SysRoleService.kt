package com.oukingtim.service

import com.baomidou.mybatisplus.service.IService
import com.oukingtim.domain.SysRole

/**
 * Created by oukingtim
 */
interface SysRoleService : IService<SysRole> {
    /**
     * 根据用户id查询角色集合
     * @param userId
     * *
     * @return
     */
    fun getList(userId: String): List<SysRole>
}