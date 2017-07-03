package com.oukingtim.web.vm

import com.oukingtim.domain.SysMenu
import org.springframework.beans.BeanUtils

/**
 * Created by oukingtim
 */
class MenuVM() {
     var id: String? = null
     var parentId: String? = null
     var name: String? = null
     var stateRef: String? = null
     var type: String? = null
     var icon: String? = null
     var title: String? = null
     var level: Int? = null
     var order: Int? = null
     var subMenu: List<MenuVM>? = null
    constructor(sm : SysMenu):this(){
        this.stateRef = sm.name
        this.name = sm.name
        this.type = sm.type
        this.icon = sm.icon
        this.title = sm.title
        this.level = sm.level
        this.order = sm.order
        this.parentId = sm.parentId
        this.id = sm.id
    }
}