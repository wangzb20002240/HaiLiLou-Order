package top.endant.hidinnner;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.endant.hidinnner.mapper.DinerMapper;
import top.endant.hidinnner.mapper.DishMapper;

@SpringBootTest
class HiDinnnerApplicationTests {

    @Autowired
    private DishMapper dishMapper;

    @Autowired
    private DinerMapper dinerMapper;


    @Test
    void testSelectDish() {
        System.out.println(dishMapper.selectAllDishes());
    }

}
