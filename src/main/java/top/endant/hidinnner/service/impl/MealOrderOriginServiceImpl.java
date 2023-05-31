package top.endant.hidinnner.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.endant.hidinnner.entity.OrderContent;
import top.endant.hidinnner.entity.mealOrder.MealInOrder;
import top.endant.hidinnner.entity.mealOrder.MealOrder;
import top.endant.hidinnner.entity.mealOrder.MealOrderOrigin;
import top.endant.hidinnner.mapper.MealOrderMapper;
import top.endant.hidinnner.mapper.OrderContentMapper;
import top.endant.hidinnner.service.IMealOrderOriginService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MealOrderOriginServiceImpl implements IMealOrderOriginService {

    @Autowired
    private MealOrderMapper mealOrderMapper;
    @Autowired
    private OrderContentMapper orderContentMapper;

    @Override
    public boolean insertOrderAndContents(MealOrderOrigin mealOrderOrigin) {
        //订单加入
        mealOrderOrigin.setSubmitTime(LocalDateTime.now());
        mealOrderOrigin.setPaymentStatus("0");
        mealOrderOrigin.setCompletionStatus("0");
        MealOrder mealOrder = mealOrderOrigin.toMealOrder();
        boolean insert1 = mealOrderMapper.insert(mealOrder) >= 1;
        //订单菜品加入
        boolean insert2 = true;
        int length = mealOrderOrigin.getMealsInOrder().length;
        for (int i = 0; i < length; i++) {
            OrderContent orderContent = new OrderContent(
                    mealOrder.getId(),
                    mealOrderOrigin.getMealsInOrder()[i].getDishId(),
                    mealOrderOrigin.getMealsInOrder()[i].getDishAmount(),
                    "0"
            );
            insert2 = insert2 && orderContentMapper.insertOrderContent(orderContent) >= 1;
        }
        return insert1 && insert2;
    }

    @Override
    public MealOrderOrigin selectMealOrderOrigin(String dinerId) {
        MealOrder mealOrder = mealOrderMapper.selectByDinerIdRecent(dinerId);
        if (mealOrder==null) return null;
        List<OrderContent> orderContents = orderContentMapper.selectByOrderId(mealOrder.getId());
        int length = orderContents.size();
        MealInOrder[] mealInOrders = new MealInOrder[length];
        for (int i = 0; i < length; i++) {
            mealInOrders[i] = new MealInOrder(
                    orderContents.get(i).getDishId(),
                    orderContents.get(i).getDishAmount(),
                    orderContents.get(i).getDishStatus()
            );
        }
        MealOrderOrigin mealOrderOrigin = mealOrder.toMealOrderOrigin();
        mealOrderOrigin.setMealsInOrder(mealInOrders);
        return mealOrderOrigin;
    }
}
