package top.endant.hidinnner.entity.mealOrder;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * 食客订单
 */
@Data
@TableName("meal_order")
@ToString
public class MealOrder {
    @TableId(type = IdType.AUTO)
    private Integer id;//    id                int primary key auto_increment comment '订单编号',
    @TableField("total_amount")
    private Double totalAmount;//    total_amount      int comment '订单总金额（派生属性）',
    @TableField("submit_time")
    private LocalDateTime submitTime;//    submit_time       datetime comment '订单提交时间',
    @TableField("payment_status")
    private String paymentStatus;//    payment_status    char(1) comment '0 为未支付，1 为已支付',
    @TableField("completion_status")
    private String completionStatus;//    completion_status char(1) comment '0 为未完成，1 为已完成',
    @TableField("diner_id")
    private String dinerId;//    diner_id          int comment '食客编号',
    @TableField("table_id")
    private Integer tableId;//    table_id          int comment '餐桌编号',
    @TableField("employee_id")
    private Integer employeeId;//    employee_id       int comment '外码'

    public MealOrder() {
    }

    public MealOrder(Integer id, Double totalAmount, LocalDateTime submitTime, String paymentStatus, String completionStatus, String dinerId, Integer tableId, Integer employeeId) {
        this.id = id;
        this.totalAmount = totalAmount;
        this.submitTime = submitTime;
        this.paymentStatus = paymentStatus;
        this.completionStatus = completionStatus;
        this.dinerId = dinerId;
        this.tableId = tableId;
        this.employeeId = employeeId;
    }

    public MealOrderOrigin toMealOrderOrigin(){
        return new MealOrderOrigin(id,totalAmount,submitTime,paymentStatus,completionStatus,dinerId,tableId,employeeId,null);
    }
}
