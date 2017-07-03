package com.oukingtim.service.impl

import com.baomidou.mybatisplus.service.impl.ServiceImpl
import com.oukingtim.domain.SysUserRole
import com.oukingtim.mapper.SysUserRoleMapper
import com.oukingtim.service.SysUserRoleService
import org.springframework.stereotype.Service

/**
 * Created by oukingtim
 */
@Service
class SysUserRoleServiceImpl : ServiceImpl<SysUserRoleMapper, SysUserRole>() , SysUserRoleService