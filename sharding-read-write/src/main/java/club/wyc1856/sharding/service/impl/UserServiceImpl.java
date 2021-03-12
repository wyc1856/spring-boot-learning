package club.wyc1856.sharding.service.impl;

import club.wyc1856.sharding.entity.UserEntity;
import club.wyc1856.sharding.enums.Type;
import club.wyc1856.sharding.mapper.UserMapper;
import club.wyc1856.sharding.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * todo
 *
 * @author wyc1856
 * @date 2021/3/12
 **/
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void selectWithInsert(Type type, Long id) {
        switch (type) {
            case SELECT_INSERT:
                log.info("先查询再插入>>>>");
                selectInsert(id);
                break;
            case INSERT_SELECT:
                log.info("先插入再查询>>>>");
                insertSelect(id);
                break;
            case SELECT_INSERT_SELECT:
                log.info("先查询再插入最后再查询>>>>");
                selectInsertSelect(id);
                break;
        }
    }

    private UserEntity selectInsert(Long id) {
        //第一次查询使用 slave 数据源，如果存在则切换到 master 数据源删除
        Optional.ofNullable(getById(id)).ifPresent(user -> {
            log.info("id:[{}] 已存在，先删除", id);
            removeById(user.getId());
        });
        //当前事务使用过 master 数据源，后续的查询则也使用主数据源（至于在一个事务中不同表是否也按这个规则还没做测试）
        UserEntity wyc1856 = new UserEntity().setId(id).setName("wyc1856").setAge(25);
        log.info("插入数据:{}", wyc1856);
        saveOrUpdate(wyc1856);
        return wyc1856;
    }

    private void selectInsertSelect(Long id) {
        UserEntity userEntity = selectInsert(id);
        log.info("重新查询, user:[{}]", getById(userEntity.getId()));
        throw new RuntimeException("exception");
    }

    private void insertSelect(Long id) {
        UserEntity wyc1856 = new UserEntity().setId(id).setName("insertSelect").setAge(25);
        log.info("插入数据:{}", wyc1856);
        log.info("重新查询, user:[{}]", getById(wyc1856.getId()));
        throw new RuntimeException("exception");
    }
}
