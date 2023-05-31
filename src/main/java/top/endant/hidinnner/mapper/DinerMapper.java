package top.endant.hidinnner.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.endant.hidinnner.entity.diner.Diner;

@Mapper
public interface DinerMapper extends BaseMapper<Diner> {

    @Select("select * from diner where phone_number = #{phoneNumber}")
    public Diner selectByPhoneNumber(String phoneNumber);

}
