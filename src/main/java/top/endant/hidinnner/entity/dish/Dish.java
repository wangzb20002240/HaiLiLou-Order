package top.endant.hidinnner.entity.dish;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

/**
 * 菜品
 */
@TableName("dish")
@Data
@ToString
public class Dish {

    @TableId(type = IdType.AUTO)
    private Integer id;// id               int primary key auto_increment comment '菜品编号',
    @TableField(value = "dish_name")
    private String dishName;//    dish_name        varchar(32) comment '菜品名称',
    private Double price;//    price            int comment '菜品价格',
    private Integer category;//    category
    @TableField(value = "dish_description")
    private String dishDescription;//    dish_description text comment '菜品描述',
    private String picture;//    picture          varchar(104) comment '菜品图片路径'

}
