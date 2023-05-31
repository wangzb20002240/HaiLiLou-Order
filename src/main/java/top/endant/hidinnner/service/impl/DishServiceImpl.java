package top.endant.hidinnner.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.endant.hidinnner.entity.dish.Dish;
import top.endant.hidinnner.mapper.DishMapper;
import top.endant.hidinnner.service.IDishService;

import java.util.List;

@Service
public class DishServiceImpl implements IDishService {

    @Autowired
    private DishMapper dishMapper;

    @Override
    public List<Dish> selectAllDishes() {
        return dishMapper.selectAllDishes();
    }

    @Override
    public Integer updateDish(Dish dish) {
        return dishMapper.updateDish(dish);
    }
}
