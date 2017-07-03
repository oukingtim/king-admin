package com.oukingtim.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Created by oukingtim
 */
@TableName("sys_user")
@Data
@EqualsAndHashCode(callSuper = false)
public class SysUser extends BaseModel<SysUser> {

    private String username;
    private String password;
    private String email;
    private String mobile;
    private String status;

    @TableField(exist=false)
    private List<SysRole> rolelist;


    public SysUser(String username) {
        this.username = username;
    }

    public SysUser() {
    }
}
