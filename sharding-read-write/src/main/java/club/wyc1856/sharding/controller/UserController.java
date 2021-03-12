package club.wyc1856.sharding.controller;

import club.wyc1856.sharding.entity.UserEntity;
import club.wyc1856.sharding.enums.Type;
import club.wyc1856.sharding.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * todo
 *
 * @author wyc1856
 * @date 2021/3/12
 **/
@Slf4j
@RestController
@RequestMapping("test/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public void addUser(@RequestBody UserEntity userEntity) {
        userService.save(userEntity);
    }

    @GetMapping("{user_id}")
    public void getUser(@PathVariable("user_id") Long id) {
        Optional.ofNullable(userService.getById(id)).ifPresent(user -> log.info("{}", user));
    }

    @PutMapping("{user_id}")
    public void insertWithSelect(@PathVariable("user_id") Long id, @RequestParam("type") String type) {
        userService.selectWithInsert(Type.valueOf(type), id);
    }
}
