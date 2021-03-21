package club.wyc1856.sharding.service.impl;

import club.wyc1856.sharding.entity.OrderEntity;
import club.wyc1856.sharding.mapper.OrderMapper;
import club.wyc1856.sharding.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * todo
 *
 * @author wyc1856
 * @date 2021/3/21
 **/
@Slf4j
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, OrderEntity> implements OrderService {
}
