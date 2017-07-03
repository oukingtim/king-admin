package com.oukingtim.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.oukingtim.domain.SysRoleMenu;

import java.util.List;

/**
 * Created by oukingtim
 */
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {

    /**
     * 根据角色id查询菜单id
     * @param roleId
     * @return
     */
    List<String> selectMenuIdsByRoleId(String roleId);
}
