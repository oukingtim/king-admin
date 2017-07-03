package com.oukingtim.web

import com.baomidou.mybatisplus.mapper.EntityWrapper
import com.oukingtim.domain.TbDictClass
import com.oukingtim.service.TbDictClassService
import com.oukingtim.web.vm.ResultVM
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by oukingtim
 */
@RestController
@RequestMapping("/sys/dictclass")
class TbDictClassController : BaseController<TbDictClassService, TbDictClass>() {

    /**
     * 获取字典分类集合
     * @return
     */
    @GetMapping("/getlist")
    fun getList() = ResultVM.ok(service!!.selectList(EntityWrapper<TbDictClass>()))

}