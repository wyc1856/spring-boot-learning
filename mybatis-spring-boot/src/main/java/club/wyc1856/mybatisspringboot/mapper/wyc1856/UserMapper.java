package club.wyc1856.mybatisspringboot.mapper.wyc1856;

import club.wyc1856.mybatisspringboot.domain.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author wyc1856
 * @date 2019/2/17 17:05
 * @description 用户表mapper
 **/
public interface UserMapper {

    User findById(@Param("id") Integer id);
}
