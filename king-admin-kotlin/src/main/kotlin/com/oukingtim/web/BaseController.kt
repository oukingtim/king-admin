package com.oukingtim.web

import com.baomidou.mybatisplus.mapper.EntityWrapper
import com.baomidou.mybatisplus.plugins.Page
import com.baomidou.mybatisplus.service.IService
import com.oukingtim.domain.BaseModel
import com.oukingtim.util.ShiroUtils
import com.oukingtim.util.StringTools
import com.oukingtim.web.vm.ResultVM
import com.oukingtim.web.vm.SmartPageVM
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.net.URISyntaxException
import java.util.*

/**
 * 通用Controller（增删改查）
 * Created by oukingtim
 */
abstract class BaseController<S : IService<T>, T : BaseModel<T>> {

    @Autowired
    protected var service: S? = null

    /**
     * 根据smarttable对象分页查询
     * @param spage
     * @return
     */
    @PostMapping("/getSmartData")
    fun getSmartData(@RequestBody spage: SmartPageVM<T>): ResultVM {
        val page = Page<T>(spage.pagination!!.start!!, spage.pagination!!.number!!)
        if (spage.sort!!.predicate.isNullOrBlank()) {
            page.orderByField = "update_time"
        }else{
            page.orderByField = StringTools.underscoreName(spage.sort!!.predicate)
        }
        page.isAsc = spage.sort!!.reverse
        val wrapper = EntityWrapper<T>()
        if (spage.search != null) {
            val fields = spage.search!!::class.java.getDeclaredFields()
            for (i in fields.indices) {
                try {
                    fields[i].setAccessible(true)
                    val value = fields[i].get(spage.search)
                    if (null != value && value != "") {
                        val fieldname = StringTools.underscoreName(fields[i].getName())
                        wrapper.like(fieldname, value!!.toString())
                    }
                    fields[i].setAccessible(false)
                } catch (e: Exception) {
                }

            }
        }
        return ResultVM.ok(service!!.selectPage(page, wrapper))
    }

    /**
     * 新增
     * @param t
     * @return
     */
    @PostMapping
    fun create(@RequestBody t: T) : ResultVM {
        t.createUserId = ShiroUtils.getUserId()
        t.createTime = Date()
        t.updateUserId = ShiroUtils.getUserId()
        t.updateTime = Date()
        return if (service!!.insert(t))  ResultVM.ok() else ResultVM.error()
    }

    /**
     * 更新
     * @param t
     * @return
     */
    @PutMapping
    fun update(@RequestBody t: T): ResultVM {
        t.updateUserId = ShiroUtils.getUserId()
        t.updateTime = Date()
        return if (service!!.updateById(t)) ResultVM.ok() else ResultVM.error()
    }

    /**
     * 根据id获取实体对象
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    fun getInfo(@PathVariable id: String) = service!!.selectById(id)

    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String)= if (service!!.deleteById(id))  ResultVM.ok() else ResultVM.error()

}