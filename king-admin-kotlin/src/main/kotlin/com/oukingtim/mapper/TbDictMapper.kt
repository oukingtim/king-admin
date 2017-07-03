package com.oukingtim.mapper

import com.baomidou.mybatisplus.mapper.BaseMapper
import com.oukingtim.domain.TbDict

/**
 * Created by oukingtim
 */
interface TbDictMapper : BaseMapper<TbDict> {
    /**
     * 根据分类编号查询字典数据
     * @param classCode
     * *
     * @return
     */
    fun selectByClassCode(classCode: String): List<TbDict>
}