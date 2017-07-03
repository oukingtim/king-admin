package com.oukingtim.util;


import com.oukingtim.domain.SysMenu;
import com.oukingtim.web.vm.MenuVM;

import java.util.ArrayList;
import java.util.List;

/**
 * 组装菜单树工具类
 * Created by oukingtim
 */
public class MenuTreeUtil {

	public static MenuVM getTree(List<SysMenu> list)  {

		if(list==null||list.size()<1)	return null;
		return buildTree(getRoot(list),list);
	}

	private static MenuVM buildTree(MenuVM pnode, List<SysMenu> nodes) {
		List<MenuVM> childs = new ArrayList<MenuVM>();
		for( SysMenu tmp : nodes ){
			if( pnode.getId().equals(tmp.getParentId()) ){
				childs.add(new MenuVM(tmp));
			}
		}

		if( childs.size()>0 ){
			pnode.setSubMenu(childs);
			for( MenuVM ptmp : childs ){
				buildTree(ptmp, nodes);
			}
		}
		return pnode;
	}

	private static MenuVM getRoot(List<SysMenu> list) {
		for (SysMenu po : list){
			if("#".equals(po.getParentId())){
				return new MenuVM(po);
			}
		}
		return null;
	}
    public static List<MenuVM> getMenu(List<SysMenu> list) {

        if(list==null||list.size()<1)	return null;

        return getTree(list)==null?null:getTree(list).getSubMenu();
    }

}
