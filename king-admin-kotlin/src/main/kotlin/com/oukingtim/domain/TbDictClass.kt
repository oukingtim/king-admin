package com.oukingtim.domain

import com.baomidou.mybatisplus.annotations.TableName

/**
 * Created by oukingtim
 */
@TableName("tb_dict_class")
class TbDictClass : BaseModel<TbDictClass>() {
    val code: String? = null
    val remark: String? = null
}