package top.endant.hidinnner.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import top.endant.hidinnner.entity.dish.Dish;
import top.endant.hidinnner.entity.dish.DishCategory;

import java.util.List;

@Mapper
public interface DishMapper extends BaseMapper<Dish> {

    @Select("select * from dish")
    public List<Dish>  selectAllDishes();

    @Select("select * from dish as d join dish_category as dc on d.category = dc.id where dc.category_name = #{categoryName}")
    public List<Dish> selectByCategory(String categoryName);

    //关于修改图片的事情后面考虑
    @Update("update dish set dish_name = #{dishName}, price = #{price}, category = #{category}, dish_description = #{dishDescription} where id = #{id}")
    public Integer updateDish(Dish dish);

}
