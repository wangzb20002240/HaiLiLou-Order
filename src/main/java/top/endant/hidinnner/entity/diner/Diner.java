package top.endant.hidinnner.entity.diner;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

/**
 * '食客'
 */
@TableName("diner")
@Data
@ToString
//（id，diner_name，gender，phone_number）
public class Diner {

    @TableId
    private String id; // int primary key auto_increment comment '食客编号',
    @TableField(value = "diner_name")
    private String dinerName;//varchar(32) comment '食客昵称',
    private String gender;
    @TableField("phone_number")
    private String phoneNumber;
}
