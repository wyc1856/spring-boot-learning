package club.wyc1856.web.demo.controller;

import club.wyc1856.web.demo.entity.User;
import club.wyc1856.web.demo.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * todo
 *
 * @author wyc1856
 * @date 2020/4/11
 **/
@Slf4j
@Api("用户接口")
@RequestMapping("user")
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("get_user")
    @ApiOperation("获取用户信息")
    public User getUser(){
        return userService.getUser();
    }

    @PostMapping("add_user")
    @ApiOperation("添加新用户")
    public String addUser(@RequestBody @Valid User user){
        log.info("添加新用户:{}", user);
        return "success";
    }
}
