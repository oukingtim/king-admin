package com.oukingtim.web;


import com.oukingtim.domain.TbDict;
import com.oukingtim.service.TbDictService;
import com.oukingtim.web.vm.ResultVM;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by oukingtim
 */
@RestController
@RequestMapping("/sys/dict")
public class TbDictController extends BaseController<TbDictService, TbDict> {

    /**
     * 根据分类编号获取字典
     * @param code
     * @return
     */
    @GetMapping("/getlist/{code}")
    public ResultVM getList(@PathVariable String code) {
        List<TbDict> list = service.findByClassCode(code);
        return ResultVM.ok(list);
    }
}
