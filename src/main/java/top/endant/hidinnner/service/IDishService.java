package top.endant.hidinnner.service;

import org.springframework.transaction.annotation.Transactional;
import top.endant.hidinnner.entity.dish.Dish;

import java.util.List;

@Transactional
public interface IDishService {

    public List<Dish> selectAllDishes();

    public Integer updateDish(Dish dish);
}
