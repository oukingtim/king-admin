package com.oukingtim.web;

import com.oukingtim.domain.SysMenu;
import com.oukingtim.service.SysMenuService;
import com.oukingtim.web.vm.JsTreeVM;
import com.oukingtim.web.vm.ResultVM;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by oukingtim
 */
@RestController
@RequestMapping("/sys/menu")
public class SysMenuController extends BaseController<SysMenuService,SysMenu>{

    /**
     * 获取菜单树
     * @param roleId
     * @return
     */
    @GetMapping("/getMenuTree")
    public ResultVM getMenuTree(@RequestParam(required = false) String roleId) {
        List<JsTreeVM> list = service.getMenuTree(roleId);
        return ResultVM.ok(list);
    }
}
