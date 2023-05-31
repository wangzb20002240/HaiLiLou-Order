package top.endant.hidinnner.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.endant.hidinnner.entity.dish.Dish;
import top.endant.hidinnner.entity.dish.DishCategory;
import top.endant.hidinnner.mapper.DishCategoryMapper;
import top.endant.hidinnner.mapper.DishMapper;
import top.endant.hidinnner.service.IDishService;

import java.util.List;

@RestController
@RequestMapping("/api/dishes")
@Api(tags = "菜品管理")
public class DishController {
    @Autowired
    private IDishService dishService;

    @Autowired
    private DishMapper dishMapper;
    @Autowired
    private DishCategoryMapper dishCategoryMapper;

    @GetMapping("/selectAllDishes")
    public Result selectAllDishes() {
        List<Dish> dishes = dishService.selectAllDishes();
        String msg = dishes != null ? "" : "获取餐品列表失败，请重试！";
        return new Result(dishes != null ? Code.SELECT_OK : Code.SYSTEM_ERR, dishes, msg);
    }

    @GetMapping("/selectDishesByCategoryName")
    public Result selectDishesByCategoryName(String categoryName) {
        List<Dish> dishes = dishMapper.selectByCategory(categoryName);
        String msg = dishes != null ? "" : "获取餐品列表失败，请重试！";
        return new Result(dishes != null ? Code.SELECT_OK : Code.SYSTEM_ERR, dishes, msg);
    }

    @PutMapping("/updateDish")
    public Result updateDish(@RequestBody Dish dish) {
        boolean flag = dishService.updateDish(dish) >= 1;
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
    }

    @GetMapping("/selectCategory")
    public Result selectCategory(){
        List<DishCategory> dishCategories = dishCategoryMapper.selectList(null);
        String msg = dishCategories != null ? "" : "获取餐品目录列表失败，请重试！";
        return new Result(dishCategories != null ? Code.SELECT_OK : Code.SYSTEM_ERR, dishCategories, msg);
    }

}
