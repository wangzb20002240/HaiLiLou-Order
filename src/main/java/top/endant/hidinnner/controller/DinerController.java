package top.endant.hidinnner.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.endant.hidinnner.entity.diner.Diner;
import top.endant.hidinnner.entity.diner.Login;
import top.endant.hidinnner.service.IDinerService;

@RestController
@RequestMapping("/api/diners")
@Api(tags = "用户管理")
public class DinerController {

    @Autowired
    private IDinerService dinerService;

    @ApiOperation(value = "根据ID获取用户信息")
    @GetMapping("/selectDinerById")
    public Result selectDinerById(String id) {
        Diner diner = dinerService.selectDinerById(id);
        String msg = diner != null ? "" : "获取用户信息失败，请重试！";
        return new Result(diner != null ? Code.SELECT_OK : Code.SYSTEM_ERR, diner, msg);
    }

    @ApiOperation(value = "根据手机号获取用户信息")
    @GetMapping("/selectDinerByPhoneNumber")
    public Result selectDinerByPhoneNumber(String phoneNumber) {
        Diner diner = dinerService.selectDinerByPhoneNumber(phoneNumber);
        String msg = diner != null ? "" : "获取用户信息失败，请重试！";
        return new Result(diner != null ? Code.SELECT_OK : Code.SYSTEM_ERR, diner, msg);
    }

    @ApiOperation(value = "根据更新用户信息")
    @PutMapping("/updateDiner")
    public Result updateDiner(@RequestBody Diner diner) {
        boolean flag = dinerService.updateDiner(diner);
        String msg = flag ? "" : "更新用户信息失败，可能是手机号重复了，请重试！";
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag, msg);
    }

    @ApiOperation(value = "注册或登录")
    @PostMapping("/login")
    public Result updateDiner(@RequestBody Login login) {
        Diner diner = dinerService.loginOrRegister(login);
        String msg = diner != null ? "" : "注册或登录异常，可能的原因是code错误或者登录过期，请重试";
        return new Result(diner != null ? Code.UPDATE_OK : Code.UPDATE_ERR, diner, msg);
    }
}
