package com.oukingtim.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.oukingtim.domain.TbTodo;
import com.oukingtim.service.TbTodoService;
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
@RequestMapping("/sys/todo")
public class TbTodoController extends BaseController<TbTodoService, TbTodo> {

    @GetMapping("/getlist")
    public ResultVM getList() {
        TbTodo tbTodo = new TbTodo();
        tbTodo.setCreateUserId(ShiroUtils.getUserId());
        List<TbTodo> list = service.selectList(new EntityWrapper<>(tbTodo));
        return ResultVM.ok(list);
    }
}
