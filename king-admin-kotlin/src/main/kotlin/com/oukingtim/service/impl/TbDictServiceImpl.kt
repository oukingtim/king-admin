package com.oukingtim.service.impl

import com.baomidou.mybatisplus.service.impl.ServiceImpl
import com.oukingtim.domain.TbDict
import com.oukingtim.mapper.TbDictMapper
import com.oukingtim.service.TbDictService
import org.springframework.stereotype.Service

/**
 * Created by oukingtim
 */
@Service
class TbDictServiceImpl : ServiceImpl<TbDictMapper, TbDict>(), TbDictService {

    override fun findByClassCode(classCode: String) = baseMapper.selectByClassCode(classCode)
}