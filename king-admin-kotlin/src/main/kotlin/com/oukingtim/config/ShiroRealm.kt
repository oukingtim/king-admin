package com.oukingtim.config

import com.oukingtim.domain.SysUser
import com.oukingtim.service.SysMenuService
import com.oukingtim.service.SysUserService
import org.apache.shiro.authc.*
import org.apache.shiro.authz.AuthorizationInfo
import org.apache.shiro.authz.SimpleAuthorizationInfo
import org.apache.shiro.realm.AuthorizingRealm
import org.apache.shiro.subject.PrincipalCollection
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * Created by oukingtim
 */
@Component
class ShiroRealm :AuthorizingRealm() {

    @Autowired
    private val sysUserService: SysUserService? = null
    @Autowired
    private val sysMenuService: SysMenuService? = null

    /**
     * 授权(验证权限时调用)
     */
    override fun doGetAuthorizationInfo(principalCollection: PrincipalCollection): AuthorizationInfo {
        val user = principalCollection.primaryPrincipal as SysUser
        val userId = user.id

        //用户权限列表
        val permsSet = sysMenuService!!.getPermissions(userId!!)

        val info = SimpleAuthorizationInfo()
        info.stringPermissions = permsSet
        return info
    }

    /**
     * 认证(登录时调用)
     */
    @Throws(AuthenticationException::class)
    override fun doGetAuthenticationInfo(authenticationToken: AuthenticationToken): AuthenticationInfo {
        val username = authenticationToken.principal as String
        val password = String(authenticationToken.credentials as CharArray)

        //查询用户信息
        val user = sysUserService!!.findByUserName(username) ?: throw UnknownAccountException("用户名不正确")

        //账号不存在

        //密码错误
        if (password != user.password) {
            throw IncorrectCredentialsException("用户名或密码不正确")
        }

        //账号禁用
        if ("0" == user.status) {
            throw LockedAccountException("用户已被禁用,请联系管理员")
        }

        val info = SimpleAuthenticationInfo(user, password, name)
        return info
    }
}