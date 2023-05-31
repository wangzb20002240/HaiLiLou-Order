package top.endant.hidinnner.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

/**
 * 订单内容（食客订单-菜品 中间表）
 * primary key (order_id, dish_id)
 */
@Data
@TableName("order_content")
@ToString
public class OrderContent {
    @TableId(type = IdType.AUTO)
    private Integer orderId;//'订单编号'
    @TableField("dish_id")
    private Integer dishId;//'菜品编号'
    @TableField("dish_amount")
    private Integer dishAmount;//'菜品数量'
    @TableField("dish_status")
    private String dishStatus;//'0 为未完成，1 为已完成'

    public OrderContent() {
    }

    public OrderContent(Integer orderId, Integer dishId, Integer dishAmount, String dishStatus) {
        this.orderId = orderId;
        this.dishId = dishId;
        this.dishAmount = dishAmount;
        this.dishStatus = dishStatus;
    }
}
