package com.oukingtim.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.oukingtim.domain.TbDictClass;
import com.oukingtim.service.TbDictClassService;
import com.oukingtim.web.vm.ResultVM;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by oukingtim
 */
@RestController
@RequestMapping("/sys/dictclass")
public class TbDictClassController extends BaseController<TbDictClassService, TbDictClass> {

    /**
     * 获取字典分类集合
     * @return
     */
    @GetMapping("/getlist")
    public ResultVM getList() {
        List<TbDictClass> list = service.selectList(new EntityWrapper<>());
        return ResultVM.ok(list);
    }
}
