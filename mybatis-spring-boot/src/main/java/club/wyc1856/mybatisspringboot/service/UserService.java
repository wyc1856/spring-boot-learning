package club.wyc1856.mybatisspringboot.service;

import club.wyc1856.mybatisspringboot.domain.Action;
import club.wyc1856.mybatisspringboot.domain.User;

/**
 * @author wyc1856
 * @date 2019/2/17 17:07
 * @description 用户相关服务接口
 **/
public interface UserService {

    User findUserById(Integer id);

    Action findActionByUserId(Integer userId);

}
