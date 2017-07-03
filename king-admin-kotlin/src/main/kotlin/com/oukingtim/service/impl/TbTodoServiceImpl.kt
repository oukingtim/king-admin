package com.oukingtim.service.impl

import com.baomidou.mybatisplus.service.impl.ServiceImpl
import com.oukingtim.domain.TbTodo
import com.oukingtim.mapper.TbTodoMapper
import com.oukingtim.service.TbTodoService
import org.springframework.stereotype.Service

/**
 * Created by oukingtim
 */
@Service
class TbTodoServiceImpl : ServiceImpl<TbTodoMapper, TbTodo>(),TbTodoService