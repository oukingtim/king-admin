package com.oukingtim.service

import com.baomidou.mybatisplus.service.IService
import com.oukingtim.domain.TbDict

/**
 * Created by oukingtim
 */
interface TbDictService : IService<TbDict> {

    /**
     * 根据分类编号查询字典
     * @param classCode
     * *
     * @return
     */
    fun findByClassCode(classCode: String): List<TbDict>
}