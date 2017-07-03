package com.oukingtim.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.oukingtim.domain.TbDict;

import java.util.List;


/**
 * Created by oukingtim
 */
public interface TbDictMapper extends BaseMapper<TbDict> {

    /**
     * 根据分类编号查询字典数据
     * @param classCode
     * @return
     */
    List<TbDict> selectByClassCode(String classCode);
}
