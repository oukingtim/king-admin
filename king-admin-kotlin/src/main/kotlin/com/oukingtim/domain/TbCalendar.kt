package com.oukingtim.domain

import com.baomidou.mybatisplus.annotations.TableName

/**
 * Created by oukingtim
 */
@TableName("tb_calendar")
class TbCalendar : BaseModel<TbCalendar>() {
    val title: String? = null
    val start: String? = null
    val end: String? = null
    val color: String? = null

}