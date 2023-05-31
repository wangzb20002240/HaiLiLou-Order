package top.endant.hidinnner.entity.mealOrder;

import lombok.Data;
import lombok.ToString;

import java.sql.Date;
import java.time.LocalDateTime;

/**
 * 原始订单
 */
@Data
@ToString
public class MealOrderOrigin {
    private Integer id;//    id                int primary key auto_increment comment '订单编号',
    private Double totalAmount;//    total_amount      int comment '订单总金额（派生属性）',
    private LocalDateTime submitTime;//    submit_time       datetime comment '订单提交时间',
    private String paymentStatus;//    payment_status    char(1) comment '0 为未支付，1 为已支付',
    private String completionStatus;//    completion_status char(1) comment '0 为未完成，1 为已完成',
    private String dinerId;//    diner_id          int comment '食客编号',
    private Integer tableId;//    table_id          int comment '餐桌编号',
    private Integer employeeId;//    employee_id       int comment '外码'
    //额外的配置，传来多个菜的id和份数
    private MealInOrder[] mealsInOrder;

    public MealOrderOrigin() {
    }

    public MealOrderOrigin(Integer id, Double totalAmount, LocalDateTime submitTime, String paymentStatus, String completionStatus, String dinerId, Integer tableId, Integer employeeId, MealInOrder[] mealsInOrder) {
        this.id = id;
        this.totalAmount = totalAmount;
        this.submitTime = submitTime;
        this.paymentStatus = paymentStatus;
        this.completionStatus = completionStatus;
        this.dinerId = dinerId;
        this.tableId = tableId;
        this.employeeId = employeeId;
        this.mealsInOrder = mealsInOrder;
    }

    public MealOrder toMealOrder(){
        return new MealOrder(id,totalAmount,submitTime,paymentStatus,completionStatus,dinerId,tableId,employeeId);
    }
}
