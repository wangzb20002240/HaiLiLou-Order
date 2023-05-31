package top.endant.hidinnner.entity.mealOrder;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MealInOrder {

    private Integer dishId;//'菜品编号'
    private Integer dishAmount;//'菜品数量'
    private String dishStatus;//'0 为未完成，1 为已完成'

    public MealInOrder() {
    }

    public MealInOrder(Integer dishId, Integer dishAmount, String dishStatus) {
        this.dishId = dishId;
        this.dishAmount = dishAmount;
        this.dishStatus = dishStatus;
    }
}
