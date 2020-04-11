package club.wyc1856.web.demo.service.impl;

import club.wyc1856.web.demo.entity.User;
import club.wyc1856.web.demo.enums.ApiExceptionEnum;
import club.wyc1856.web.demo.exception.ApiException;
import club.wyc1856.web.demo.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * 用户服务（实现）
 *
 * @author wyc1856
 * @date 2020/4/11
 **/
@Service
@Slf4j
public class UserServiceImpl implements IUserService {

    @Value("${user.bound:10}")
    private int bound;

    @Override
    public User getUser() {
        Random random = new Random();
        if (random.nextInt(bound) > bound / 2) {
            throw new ApiException(ApiExceptionEnum.SYSTEM_ERROR);
        }
        return User.builder()
                .id(1L)
                .account("wyc1856")
                .email("wyc1856@qq.com")
                .password("123456")
                .build();
    }
}
