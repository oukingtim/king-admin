package com.oukingtim.service

import com.baomidou.mybatisplus.service.IService
import com.oukingtim.domain.SysUser

/**
 * Created by oukingtim
 */
interface SysUserService : IService<SysUser> {
    /**
     * 根据用户名查询用户
     * @param username
     * *
     * @return
     */
    fun findByUserName(username: String): SysUser
}