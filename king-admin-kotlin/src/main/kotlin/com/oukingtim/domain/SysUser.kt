package com.oukingtim.domain

import com.baomidou.mybatisplus.annotations.TableField
import com.baomidou.mybatisplus.annotations.TableName

/**
 * Created by oukingtim
 */
@TableName("sys_user")
class SysUser() : BaseModel<SysUser>() {

    var username: String? = null
    var password: String? = null
    var email: String? = null
    val mobile: String? = null
    val status: String? = null

    @TableField(exist = false)
    var rolelist: List<SysRole>? = null

    constructor(username: String) :this(){
        this.username = username
    }

}