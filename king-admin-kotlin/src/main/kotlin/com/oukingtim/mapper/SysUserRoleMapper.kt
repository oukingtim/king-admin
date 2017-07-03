package com.oukingtim.mapper

import com.baomidou.mybatisplus.mapper.BaseMapper
import com.oukingtim.domain.SysUserRole

/**
 * Created by oukingtim
 */
interface SysUserRoleMapper : BaseMapper<SysUserRole> {
    /**
     * 根据用户id查询角色id集合
     * @param userId
     * *
     * @return
     */
    fun selectRoleIdsByUserId(userId: String): List<String>
}