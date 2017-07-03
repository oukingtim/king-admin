package com.oukingtim.service.impl

import com.baomidou.mybatisplus.service.impl.ServiceImpl
import com.oukingtim.domain.SysRoleMenu
import com.oukingtim.mapper.SysRoleMenuMapper
import com.oukingtim.service.SysRoleMenuService
import org.springframework.stereotype.Service

/**
 * Created by oukingtim
 */
@Service
class SysRoleMenuServiceImpl : ServiceImpl<SysRoleMenuMapper, SysRoleMenu>() , SysRoleMenuService