package com.oukingtim.web

import com.baomidou.mybatisplus.mapper.EntityWrapper
import com.oukingtim.domain.TbTodo
import com.oukingtim.service.TbTodoService
import com.oukingtim.util.ShiroUtils
import com.oukingtim.web.vm.ResultVM
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by oukingtim
 */
@RestController
@RequestMapping("/sys/todo")
class TbTodoController : BaseController<TbTodoService, TbTodo>(){

    @GetMapping("/getlist")
    fun getList(): ResultVM {
        val tbTodo = TbTodo()
        tbTodo.createUserId=ShiroUtils.getUserId()
        val list = service!!.selectList(EntityWrapper(tbTodo))
        return ResultVM.ok(list)
    }
}