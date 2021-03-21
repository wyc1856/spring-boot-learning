package club.wyc1856.sharding.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * todo
 *
 * @author wyc1856
 * @date 2021/3/21
 **/
@Data
@TableName("t_order")
public class OrderEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String orderNo;

    private Long orderAmount;

    private String remark;
}
