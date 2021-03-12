package club.wyc1856.autoconfigurer;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * todo
 *
 * @author wyc1856
 * @date 2021/3/12
 **/
@Data
@Accessors(chain = true)
@TableName("user")
public class User {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
}
