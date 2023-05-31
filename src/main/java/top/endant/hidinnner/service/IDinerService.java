package top.endant.hidinnner.service;

import org.springframework.transaction.annotation.Transactional;
import top.endant.hidinnner.entity.diner.Diner;
import top.endant.hidinnner.entity.diner.Login;

import java.util.List;

@Transactional
public interface IDinerService {

    Diner selectDinerById(String id);

    Diner selectDinerByPhoneNumber(String phoneNumber);

    Boolean updateDiner(Diner diner);

    List<Diner> selectAllDiners();

    Diner loginOrRegister(Login login);
}
