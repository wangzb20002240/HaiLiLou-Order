package top.endant.hidinnner.service.impl;

import cn.hutool.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.endant.hidinnner.entity.diner.Diner;
import top.endant.hidinnner.entity.diner.Login;
import top.endant.hidinnner.mapper.DinerMapper;
import top.endant.hidinnner.service.IDinerService;
import top.endant.hidinnner.util.WeChatUtil;

import java.util.List;
import java.util.Objects;

@Service
public class DinerServiceImpl implements IDinerService {

    @Autowired
    private DinerMapper dinerMapper;

    @Override
    public Diner selectDinerById(String id) {
        return dinerMapper.selectById(id);
    }

    @Override
    public Diner selectDinerByPhoneNumber(String phoneNumber) {
        return dinerMapper.selectByPhoneNumber(phoneNumber);
    }

    @Override
    public Boolean updateDiner(Diner diner) {
        Diner diner1 = dinerMapper.selectByPhoneNumber(diner.getPhoneNumber());
        if (diner1 != null && !Objects.equals(diner1.getId(), diner.getId())) {
            return false;
        }
        return dinerMapper.updateById(diner) >= 1;
    }

    @Override
    public List<Diner> selectAllDiners() {
        return dinerMapper.selectList(null);
    }

    @Override
    public Diner loginOrRegister(Login login) {
        String code = login.getCode();
        JSONObject jsonObject = WeChatUtil.getSessionKeyOrOpenId(code);
        String openid = jsonObject.get("openid", String.class);
        if (openid == null) return null;
        Diner diner = dinerMapper.selectById(openid);
        if (diner == null) {
            diner = new Diner();
            diner.setId(openid);
            diner.setDinerName(login.getNickName());
            String gender = login.getGender();
            gender = "0".equals(gender) ? null : Integer.toString(Integer.parseInt(gender) - 1);
            diner.setGender(gender);
            int insert = dinerMapper.insert(diner);
            if (insert == 1) System.out.println("注册成功");
        }
        return diner;
    }
}
