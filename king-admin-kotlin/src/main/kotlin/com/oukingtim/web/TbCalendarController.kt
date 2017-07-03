package com.oukingtim.web

import com.baomidou.mybatisplus.mapper.EntityWrapper
import com.oukingtim.domain.TbCalendar
import com.oukingtim.service.TbCalendarService
import com.oukingtim.util.ShiroUtils
import com.oukingtim.web.vm.ResultVM
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by oukingtim
 */
@RestController
@RequestMapping("/sys/calendar")
class TbCalendarController : BaseController<TbCalendarService, TbCalendar>(){

    @GetMapping("/getlist")
    fun getList(): ResultVM {
        val calendar = TbCalendar()
        calendar.createUserId=ShiroUtils.getUserId()
        val list = service!!.selectList(EntityWrapper(calendar))
        return ResultVM.ok(list)
    }
}