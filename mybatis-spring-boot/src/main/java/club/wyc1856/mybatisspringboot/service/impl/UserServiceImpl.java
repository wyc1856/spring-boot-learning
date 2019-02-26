package club.wyc1856.mybatisspringboot.service.impl;

import club.wyc1856.mybatisspringboot.domain.Action;
import club.wyc1856.mybatisspringboot.domain.User;
import club.wyc1856.mybatisspringboot.mapper.wyc1856.UserMapper;
import club.wyc1856.mybatisspringboot.mapper.wyc1995.ActionMapper;
import club.wyc1856.mybatisspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wyc1856
 * @date 2019/2/17 17:08
 * @description 用户相关服务实现
 **/
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final ActionMapper actionMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper, ActionMapper actionMapper) {
        this.userMapper = userMapper;
        this.actionMapper = actionMapper;
    }

    @Override
    public User findUserById(Integer id) {
        return userMapper.findById(id);
    }

    @Override
    public Action findActionByUserId(Integer userId) {
        return actionMapper.findByUserId(userId);
    }
}
