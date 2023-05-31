package top.endant.hidinnner.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

/**
 * 部门
 */
@Data
@ToString
@TableName("department")
public class Department {
    @TableId(type = IdType.AUTO)
    private Integer id;// int primary key auto_increment comment '部门编号',
    @TableField("department_name")
    private String departmentName;//varchar(32) comment '部门名称',
    private Integer quantity;// int comment '部门人数（派生属性）'
}
