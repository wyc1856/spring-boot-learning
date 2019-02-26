package club.wyc1856.mybatisspringboot.controller;

import club.wyc1856.mybatisspringboot.domain.Action;
import club.wyc1856.mybatisspringboot.domain.User;
import club.wyc1856.mybatisspringboot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wyc1856
 * @date 2019/2/17 17:10
 * @description 用户相关控制器
 **/
@RestController
@Slf4j
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("user/info/{userId}")
    public User getUserById(@PathVariable("userId") Integer userId){
        return userService.findUserById(userId);
    }

    @GetMapping("user/action/{userId}")
    public Action getActionByUserId(@PathVariable("userId") Integer userId){
        return userService.findActionByUserId(userId);
    }
}
