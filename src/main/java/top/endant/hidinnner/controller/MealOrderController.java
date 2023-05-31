package top.endant.hidinnner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.endant.hidinnner.entity.mealOrder.MealOrderOrigin;
import top.endant.hidinnner.service.IMealOrderOriginService;

@RestController
@RequestMapping("/api/mealOrders")
public class MealOrderController {

    @Autowired
    private IMealOrderOriginService mealOrderOriginService;

    @PostMapping("/insertMealOrders")
    public Result insertOriginMealOrders(@RequestBody MealOrderOrigin mealOrderOrigin) {
        boolean flag = mealOrderOriginService.insertOrderAndContents(mealOrderOrigin);
        return new Result(flag ? Code.INSERT_OK : Code.INSERT_ERR, flag);
    }

    @GetMapping("/selectMealOrdersByDinerId")
    public Result selectOriginMealOrders(String dinerId) {
        MealOrderOrigin mealOrderOrigin = mealOrderOriginService.selectMealOrderOrigin(dinerId);
        String msg = mealOrderOrigin != null ? "" : "获取订单数据失败或该用户未曾下单，请重试！";
        return new Result(mealOrderOrigin != null ? Code.SELECT_OK : Code.SYSTEM_ERR, mealOrderOrigin, msg);
    }

}
