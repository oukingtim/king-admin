package com.oukingtim.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.oukingtim.domain.TbDict;
import com.oukingtim.mapper.TbDictMapper;
import com.oukingtim.service.TbDictService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by oukingtim
 */
@Service
public class TbDictServiceImpl extends ServiceImpl<TbDictMapper,TbDict> implements TbDictService {
    @Override
    public List<TbDict> findByClassCode(String classCode) {
        return baseMapper.selectByClassCode(classCode);
    }
}
