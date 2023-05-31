package top.endant.hidinnner.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.endant.hidinnner.entity.OrderContent;

import java.util.List;

@Mapper
public interface OrderContentMapper extends BaseMapper<OrderContent> {

    @Select("select * from order_content where order_id = #{orderId}")
    List<OrderContent> selectByOrderId(Integer orderId);

    @Insert("insert into order_content(order_id,dish_id,dish_amount,dish_status)" +
            "values(#{orderId},#{dishId},#{dishAmount},#{dishStatus})")
    Integer insertOrderContent(OrderContent orderContent);
}
