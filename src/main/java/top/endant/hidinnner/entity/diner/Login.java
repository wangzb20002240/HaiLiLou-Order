package top.endant.hidinnner.entity.diner;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Login {
    private String code;
    private String nickName;
    private String gender;
}
