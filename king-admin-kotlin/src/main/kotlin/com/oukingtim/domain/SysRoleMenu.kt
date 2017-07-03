package com.oukingtim.domain

import com.baomidou.mybatisplus.annotations.TableName

/**
 * Created by oukingtim
 */
@TableName("sys_role_menu")
class SysRoleMenu() : BaseModel<SysRoleMenu>() {
    var roleId: String? = null
    var menuId: String? = null

    constructor(menuId:String):this(){
        this.menuId = menuId
    }
}