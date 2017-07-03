package com.oukingtim.service.impl

import com.baomidou.mybatisplus.service.impl.ServiceImpl
import com.oukingtim.domain.TbCalendar
import com.oukingtim.mapper.TbCalendarMapper
import com.oukingtim.service.TbCalendarService
import org.springframework.stereotype.Service

/**
 * Created by oukingtim
 */
@Service
class TbCalendarServiceImpl : ServiceImpl<TbCalendarMapper,TbCalendar>() , TbCalendarService