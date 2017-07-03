package com.oukingtim.domain

import com.baomidou.mybatisplus.annotations.TableName

/**
 * Created by oukingtim
 */
@TableName("tb_dict")
class TbDict : BaseModel<TbDict>() {
    val code: String? = null
    val text: String? = null
    val remark: String? = null
    val dictClassId: String? = null
}