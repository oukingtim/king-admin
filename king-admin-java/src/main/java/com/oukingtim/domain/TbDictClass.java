package com.oukingtim.domain;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by oukingtim
 */
@TableName("tb_dict_class")
@Data
@EqualsAndHashCode(callSuper = false)
public class TbDictClass extends BaseModel<TbDictClass> {

    private String code;
    private String remark;

}
