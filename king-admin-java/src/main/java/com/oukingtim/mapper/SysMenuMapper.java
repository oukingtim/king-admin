package com.oukingtim.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.oukingtim.domain.SysMenu;

import java.util.List;

/**
 * Created by oukingtim
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
     * 根据用户id获取菜单
     * @param userId
     * @return
     */
    List<SysMenu> selectMenuByUserId(String userId);

    /**
     * 根据用户id查询权限
     * @param userId
     * @return
     */
    List<String> getPermissions(String userId);
}
