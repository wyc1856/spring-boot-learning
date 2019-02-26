package club.wyc1856.mybatisspringboot.mapper.wyc1995;

import club.wyc1856.mybatisspringboot.domain.Action;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author wyc1856
 * @date 2019/2/17 17:06
 * @description 行动表mapper
 **/
@Mapper
public interface ActionMapper {

    Action findByUserId(@Param("userId") Integer userId);

    Integer insert(Action action);

    Integer updateUserAction(Action action);
}
