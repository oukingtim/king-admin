package com.oukingtim.service;

import com.baomidou.mybatisplus.service.IService;
import com.oukingtim.domain.TbDict;

import java.util.List;


/**
 * Created by oukingtim
 */
public interface TbDictService extends IService<TbDict> {

    /**
     * 根据分类编号查询字典
     * @param classCode
     * @return
     */
    List<TbDict> findByClassCode(String classCode);
}
