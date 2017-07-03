package com.oukingtim.web;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.oukingtim.domain.SysRole;
import com.oukingtim.domain.SysUser;
import com.oukingtim.service.SysMenuService;
import com.oukingtim.service.SysRoleService;
import com.oukingtim.service.SysUserService;
import com.oukingtim.util.ShiroUtils;
import com.oukingtim.web.vm.ResultVM;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by oukingtim
 */
@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private SysMenuService sysMenuService;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysRoleService sysRoleService;

    @PostMapping("/login")
    public ResultVM login(@RequestBody Map<String, String> map) {
        UsernamePasswordToken token = null;
        try {
            String password = map.get("password");
            String username = map.get("username");
            Subject subject = ShiroUtils.getSubject();
            //sha256加密
            password = new Sha256Hash(password).toHex();
            token = new UsernamePasswordToken(username, password);
            subject.login(token);
        } catch (UnknownAccountException e) {
            return ResultVM.error(e.getMessage());
        } catch (IncorrectCredentialsException e) {
            return ResultVM.error(e.getMessage());
        } catch (LockedAccountException e) {
            return ResultVM.error(e.getMessage());
        }
        return ResultVM.ok();
    }

    @GetMapping("/signout")
    public ResultVM logout() {
        ShiroUtils.logout();
        return ResultVM.ok();
    }

    @GetMapping("/isLogin")
    public ResultVM isLogin() {
        if (ShiroUtils.isLogin()) {
            Map<String, Object> map = new HashedMap();
            map.put("user", ShiroUtils.getUser());
            map.put("menu", sysMenuService.getMenu(ShiroUtils.getUserId()));
            map.put("perms", sysMenuService.getPermissions(ShiroUtils.getUserId()));
            return ResultVM.ok(map);
        }
        return ResultVM.error();
    }

    @PutMapping("/password")
    public ResultVM reSetPassword(@RequestBody Map<String, String> map) {
        UsernamePasswordToken token = null;
        String password = map.get("password");
        String newpassword = map.get("newpassword");
        if (StringUtils.isBlank(password)){
            return ResultVM.error("原密码不能为空");
        }
        if (StringUtils.isBlank(newpassword)){
            return ResultVM.error("新密码不能为空");
        }
        SysUser user = ShiroUtils.getUser();
        //sha256加密
        password = new Sha256Hash(password).toHex();
        if (!user.getPassword().equals(password)) {
            return ResultVM.error("密码错误");
        }
        newpassword = new Sha256Hash(newpassword).toHex();
        user.setPassword(newpassword);
        sysUserService.updateAllColumnById(user);
        return ResultVM.ok();
    }

    @PostMapping("/sign")
    public ResultVM sign(@RequestBody Map<String, String> map) {
        UsernamePasswordToken token = null;
        try {
            String password = map.get("password");
            String username = map.get("username");
            String email = map.get("email");
            SysUser user = new SysUser(username);
            user.setPassword(password);
            user.setEmail(email);
            //添加默认用户user1权限
            List<SysRole> rlist = sysRoleService.selectList(new EntityWrapper<>(new SysRole("user1")));
            for (SysRole role: rlist){
                role.setChecked(true);
            }
            user.setRolelist(rlist);
            sysUserService.insert(user);

            Subject subject = ShiroUtils.getSubject();
            token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
            subject.login(token);
        } catch (UnknownAccountException e) {
            return ResultVM.error(e.getMessage());
        } catch (IncorrectCredentialsException e) {
            return ResultVM.error(e.getMessage());
        } catch (LockedAccountException e) {
            return ResultVM.error(e.getMessage());
        }
        return ResultVM.ok();
    }
}
