package top.endant.hidinnner.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.endant.hidinnner.entity.mealOrder.MealOrder;

import java.util.List;

@Mapper
public interface MealOrderMapper extends BaseMapper<MealOrder> {

    @Select("select * from meal_order where diner_id = #{dinerId}")
    List<MealOrder> selectByDinerId(String dinerId);

    /**
     * 找的是时间最近的一条记录
     */
    @Select("select * from meal_order as mo join(select max(submit_time) as mst from meal_order where diner_id = #{dinerId} group by diner_id) as m on mst = mo.submit_time")
    MealOrder selectByDinerIdRecent(String dinerId);
}
