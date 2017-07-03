package com.oukingtim.domain

import com.baomidou.mybatisplus.annotations.TableField
import com.baomidou.mybatisplus.annotations.TableName
import com.oukingtim.web.vm.JsTreeVM

/**
 * Created by oukingtim
 */
@TableName("sys_role")
class SysRole() : BaseModel<SysRole>() {

    var roleName: String? = null
    val remark: String? = null
    @TableField(exist = false)
    var checked: Boolean? = null
    @TableField(exist = false)
    val menuTree: List<JsTreeVM>? = null

    constructor(roleName: String):this(){
        this.roleName = roleName
    }
}