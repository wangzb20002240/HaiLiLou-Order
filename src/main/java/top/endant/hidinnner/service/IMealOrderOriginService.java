package top.endant.hidinnner.service;

import org.springframework.transaction.annotation.Transactional;
import top.endant.hidinnner.entity.mealOrder.MealOrderOrigin;

@Transactional
public interface IMealOrderOriginService {

    /**
     * 提交订单的操作
     * @param mealOrderOrigin
     * @return
     */
    boolean insertOrderAndContents(MealOrderOrigin mealOrderOrigin);

    /**
     * 查询最近的那次订单包括全部全部菜品id，份数，但不包括具体菜品的信息
     * @param dinerId
     * @return
     */
    MealOrderOrigin selectMealOrderOrigin(String dinerId);

}
