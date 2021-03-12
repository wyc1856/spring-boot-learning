package club.wyc1856.sharding.service;

import club.wyc1856.sharding.entity.UserEntity;
import club.wyc1856.sharding.enums.Type;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * todo
 *
 * @author wyc1856
 * @date 2021/3/12
 **/
public interface UserService extends IService<UserEntity> {

    void selectWithInsert(Type type, Long id);
}
