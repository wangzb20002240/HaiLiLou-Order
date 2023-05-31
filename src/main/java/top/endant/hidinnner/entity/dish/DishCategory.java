package top.endant.hidinnner.entity.dish;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@TableName("dish_category")
public class DishCategory {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("category_name")
    private String categoryName;//    category         varchar(32) comment '菜品类别',
}
