/**
 * Project Name:km-ms
 * File Name:SerieTreeVo.java
 * Package Name:com.kingmed.ms.sales.vo
 * Date:2015年5月7日下午4:10:25
 * Copyright (c) 2015, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.oukingtim.web.vm;

import com.oukingtim.domain.SysMenu;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.List;

/**
 * 菜单数据返回对象
 * Created by oukingtim
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MenuVM implements Serializable {

    private String id;
    private String parentId;
    private String name;
    private String stateRef;
    private String type;
    private String icon;
    private String title;
    private Integer level;
    private Integer order;
    private List<MenuVM> subMenu;
	public MenuVM() {
	}
	public MenuVM(SysMenu sm) {
        BeanUtils.copyProperties(sm, this);
        this.stateRef = sm.getName();
    }
	
}

