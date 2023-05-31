package top.endant.hidinnner.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

/**
 * 员工
 */
@Data
@ToString
@TableName("employee")
public class Employee {
    @TableId(type = IdType.AUTO)
    private Integer id;// int primary key auto_increment comment '员工工号',
    @TableField("employee_name")
    private String employeeName;//varchar(32) comment '员工姓名',
    @TableField("employee_password")
    private String employeePassword;
    private String gender;//char(1) comment '员工性别',
    @TableField("phone_number")
    private String phoneNumber;//char(11) comment '员工联系电话',
    private String job;//varchar(32) comment '员工职务',
    @TableField("department_id")
    private Integer departmentId;// int comment '员工所属部门号'
}
