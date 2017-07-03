package com.oukingtim.domain

import com.baomidou.mybatisplus.annotations.TableName

/**
 * Created by oukingtim
 */
@TableName("sys_user_role")
class SysUserRole : BaseModel<SysUserRole>() {
    var roleId: String? = null
    var userId: String? = null
}