import club.wyc1856.sharding.ShardingApplication;
import club.wyc1856.sharding.entity.OrderEntity;
import club.wyc1856.sharding.service.OrderService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * todo
 *
 * @author wyc1856
 * @date 2021/3/21
 **/
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShardingApplication.class)
public class OrderTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void test() {
        LambdaQueryWrapper<OrderEntity> queryWrapper = Wrappers.lambdaQuery(OrderEntity.class).in(OrderEntity::getId, 99, 100);
        orderService.list(queryWrapper).forEach(order -> log.info("{}", order));
    }
}
