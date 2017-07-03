package com.oukingtim.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.oukingtim.domain.TbCalendar;
import com.oukingtim.service.TbCalendarService;
import com.oukingtim.util.ShiroUtils;
import com.oukingtim.web.vm.ResultVM;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by oukingtim
 */
@RestController
@RequestMapping("/sys/calendar")
public class TbCalendarController extends BaseController<TbCalendarService, TbCalendar> {

    @GetMapping("/getlist")
    public ResultVM getList() {
        TbCalendar calendar = new TbCalendar();
        calendar.setCreateUserId(ShiroUtils.getUserId());
        List<TbCalendar> list = service.selectList(new EntityWrapper<>(calendar));
        return ResultVM.ok(list);
    }
}
