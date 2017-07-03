package com.oukingtim.domain;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by oukingtim
 */
@TableName("tb_todo")
@Data
@EqualsAndHashCode(callSuper = false)
public class TbTodo extends BaseModel<TbTodo> {

    private String text;

}
