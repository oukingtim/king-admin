package com.oukingtim.domain;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by oukingtim
 */
@TableName("tb_dict")
@Data
@EqualsAndHashCode(callSuper = false)
public class TbDict extends BaseModel<TbDict> {

    private String code;
    private String text;
    private String remark;
    private String dictClassId;

}
