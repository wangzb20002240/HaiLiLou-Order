package top.endant.hidinnner.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

/**
 * 餐桌
 */
@Data
@ToString
@TableName("dining_table")
public class DiningTable {
    @TableId(type = IdType.AUTO)
    private Integer id;// int primary key auto_increment comment '餐桌编号',
    @TableField("maximum_use")
    private Integer maximumUse;// int comment '餐桌最大使用人数',
    @TableField("use_status")
    private String useStatus;//char(1) comment '餐桌使用状态'
}
