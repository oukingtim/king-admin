package com.oukingtim.web

import com.oukingtim.domain.SysMenu
import com.oukingtim.service.SysMenuService
import com.oukingtim.web.vm.ResultVM
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * Created by oukingtim
 */
@RestController
@RequestMapping("/sys/menu")
class SysMenuController : BaseController<SysMenuService, SysMenu>() {

    /**
     * 获取菜单树
     * @param roleId
     * @return
     */
    @GetMapping("/getMenuTree")
    fun getMenuTree(@RequestParam(required = false) roleId: String) = ResultVM.ok(service!!.getMenuTree(roleId))
}