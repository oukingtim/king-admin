package com.oukingtim.domain

import com.baomidou.mybatisplus.annotations.TableName

/**
 * Created by oukingtim
 */
@TableName("sys_menu")
class SysMenu : BaseModel<SysMenu>() {
    val parentId: String? = null
    val name: String? = null
    val type: String? = null
    val icon: String? = null
    val title: String? = null
    val level: Int? = null
    val order: Int? = null
}