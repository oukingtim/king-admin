package com.oukingtim.web

import com.baomidou.mybatisplus.mapper.EntityWrapper
import com.oukingtim.domain.SysRole
import com.oukingtim.domain.SysUser
import com.oukingtim.service.SysMenuService
import com.oukingtim.service.SysRoleService
import com.oukingtim.service.SysUserService
import com.oukingtim.util.ShiroUtils
import com.oukingtim.web.vm.ResultVM
import org.apache.commons.collections.map.HashedMap
import org.apache.shiro.authc.IncorrectCredentialsException
import org.apache.shiro.authc.LockedAccountException
import org.apache.shiro.authc.UnknownAccountException
import org.apache.shiro.authc.UsernamePasswordToken
import org.apache.shiro.crypto.hash.Sha256Hash
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * Created by oukingtim
 */
@RestController
@RequestMapping("/api")
class LoginController {
    @Autowired
    private val sysMenuService: SysMenuService? = null
    @Autowired
    private val sysUserService: SysUserService? = null
    @Autowired
    private val sysRoleService: SysRoleService? = null

    @PostMapping("/login")
    fun login(@RequestBody map: Map<String, String>): ResultVM {
        var token: UsernamePasswordToken? = null
        try {
            var password: String = map["password"]!!
            val username = map["username"]
            val subject = ShiroUtils.getSubject()
            //sha256加密
            password = Sha256Hash(password).toHex()
            token = UsernamePasswordToken(username, password)
            subject.login(token)
        } catch (e: UnknownAccountException) {
            return ResultVM.error(e.message!!)
        } catch (e: IncorrectCredentialsException) {
            return ResultVM.error(e.message!!)
        } catch (e: LockedAccountException) {
            return ResultVM.error(e.message!!)
        }

        return ResultVM.ok()
    }

    @GetMapping("/signout")
    fun logout(): ResultVM {
        ShiroUtils.logout()
        return ResultVM.ok()
    }

    @GetMapping("/isLogin")
    fun isLogin(): ResultVM {
        if (ShiroUtils.isLogin()) {
            val map = HashedMap()
            map.put("user", ShiroUtils.getUser())
            map.put("menu", sysMenuService!!.getMenu(ShiroUtils.getUserId()))
            map.put("perms", sysMenuService.getPermissions(ShiroUtils.getUserId()))
            return ResultVM.ok(map)
        }
        return ResultVM.error()
    }

    @PutMapping("/password")
    fun reSetPassword(@RequestBody map: Map<String, String>): ResultVM {
        val token: UsernamePasswordToken? = null
        var password: String = map["password"]!!
        var newpassword: String = map["newpassword"]!!
        if (password.isNullOrBlank()) {
            return ResultVM.error("原密码不能为空")
        }
        if (newpassword.isNullOrBlank()) {
            return ResultVM.error("新密码不能为空")
        }
        val user = ShiroUtils.getUser()
        //sha256加密
        password = Sha256Hash(password).toHex()
        if (user.password != password) {
            return ResultVM.error("密码错误")
        }
        newpassword = Sha256Hash(newpassword).toHex()
        user.password=newpassword
        sysUserService!!.updateAllColumnById(user)
        return ResultVM.ok()
    }

    @PostMapping("/sign")
    fun sign(@RequestBody map: Map<String, String>): ResultVM {
        var token: UsernamePasswordToken? = null
        try {
            val user = SysUser(map["username"]!!)
            user.password=map["password"]
            user.email = map["email"]
            //添加默认用户user1权限
            val rlist = sysRoleService!!.selectList(EntityWrapper(SysRole("user1")))
            for (role in rlist) {
                role.checked=true
            }
            user.rolelist = rlist
            sysUserService!!.insert(user)

            val subject = ShiroUtils.getSubject()
            token = UsernamePasswordToken(user.username, user.password)
            subject.login(token)
        } catch (e: UnknownAccountException) {
            return ResultVM.error(e.message!!)
        } catch (e: IncorrectCredentialsException) {
            return ResultVM.error(e.message!!)
        } catch (e: LockedAccountException) {
            return ResultVM.error(e.message!!)
        }

        return ResultVM.ok()
    }
}