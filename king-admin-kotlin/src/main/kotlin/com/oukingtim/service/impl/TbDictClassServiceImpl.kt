package com.oukingtim.service.impl

import com.baomidou.mybatisplus.service.impl.ServiceImpl
import com.oukingtim.domain.TbDictClass
import com.oukingtim.mapper.TbDictClassMapper
import com.oukingtim.service.TbDictClassService
import org.springframework.stereotype.Service
/**
 * Created by oukingtim
 */
@Service
class TbDictClassServiceImpl : ServiceImpl<TbDictClassMapper, TbDictClass>(), TbDictClassService