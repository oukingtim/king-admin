package com.oukingtim.mapper

import com.baomidou.mybatisplus.mapper.BaseMapper
import com.oukingtim.domain.SysRoleMenu

/**
 * Created by oukingtim
 */
interface SysRoleMenuMapper : BaseMapper<SysRoleMenu> {
    /**
     * 根据角色id查询菜单id
     * @param roleId
     * *
     * @return
     */
    fun selectMenuIdsByRoleId(roleId: String): List<String>
}