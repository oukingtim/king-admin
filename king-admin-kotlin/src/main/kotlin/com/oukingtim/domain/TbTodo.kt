package com.oukingtim.domain

import com.baomidou.mybatisplus.annotations.TableName

/**
 * Created by oukingtim
 */
@TableName("tb_todo")
class TbTodo : BaseModel<TbTodo>() {
    var text: String? = null
}