package com.oukingtim.web;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.oukingtim.domain.BaseModel;
import com.oukingtim.util.ShiroUtils;
import com.oukingtim.util.StringTools;
import com.oukingtim.web.vm.ResultVM;
import com.oukingtim.web.vm.SmartPageVM;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.net.URISyntaxException;
import java.util.Date;

/**
 * 通用Controller（增删改查）
 * Created by oukingtim
 */
public abstract class BaseController<S extends IService<T>, T extends BaseModel<T>> {

    @Autowired
    protected S service;

    /**
     * 根据smarttable对象分页查询
     * @param spage
     * @return
     */
    @PostMapping("/getSmartData")
    public ResultVM getSmartData(@RequestBody SmartPageVM<T> spage){
        Page<T> page = new Page<T>(spage.getPagination().getStart()
                ,spage.getPagination().getNumber());

        if (StringUtils.isBlank(spage.getSort().getPredicate())) {
            spage.getSort().setPredicate("update_time");
        }
        page.setOrderByField(spage.getSort().getPredicate());
        page.setAsc(spage.getSort().getReverse());
        EntityWrapper<T> wrapper = new EntityWrapper<T>();
        if (spage.getSearch()!=null){
            Field[] fields = spage.getSearch().getClass().getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                try {
                    fields[i].setAccessible(true);
                    Object value = fields[i].get(spage.getSearch());
                    if (null != value && !value.equals("")) {
                        String fieldname = StringTools.underscoreName(fields[i].getName());
                        wrapper.like(fieldname,value.toString());
                    }
                    fields[i].setAccessible(false);
                } catch (Exception e) {
                }
            }
        }
        return  ResultVM.ok(service.selectPage(page,wrapper));
    }

    /**
     * 新增
     * @param t
     * @return
     */
    @PostMapping
    public ResultVM create(@RequestBody T t) {

        t.setCreateUserId(ShiroUtils.getUserId());
        t.setCreateTime(new Date());
        t.setUpdateTime(new Date());
        t.setUpdateUserId(ShiroUtils.getUserId());
        if(service.insert(t)){
            return ResultVM.ok();
        }else{
            return ResultVM.error();
        }
    }

    /**
     * 更新
     * @param t
     * @return
     */
    @PutMapping
    public ResultVM update(@RequestBody T t) {

        t.setUpdateTime(new Date());
        t.setUpdateUserId(ShiroUtils.getUserId());
        if(service.updateById(t)){
            return ResultVM.ok();
        }else{
            return ResultVM.error();
        }
    }

    /**
     * 根据id获取实体对象
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public T getInfo(@PathVariable String id) {
        return service.selectById(id);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResultVM delete(@PathVariable String id) {
        if(service.deleteById(id)){
            return ResultVM.ok();
        }else{
            return ResultVM.error();
        }
    }
}
