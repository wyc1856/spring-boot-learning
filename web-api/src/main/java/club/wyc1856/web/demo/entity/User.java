package club.wyc1856.web.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * User 实体类
 *
 * @author wyc1856
 * @date 2020/4/11
 **/
@Data
@Builder
@ApiModel("用户信息")
@ToString
public class User {

    @NotNull(message = "用户 id 不能为空")
    @ApiModelProperty("用户 id")
    private Long id;

    @Size(min = 5, max = 11, message = "账号长度必须是 5-11 个字符")
    @NotNull(message = "用户账号不能为空")
    @ApiModelProperty("用户账号")
    private String account;

    @NotNull(message = "用户密码不能为空")
    @Size(min = 6, max = 12, message = "密码长度必须是 6-12 个字符")
    @ApiModelProperty("用户密码")
    private String password;

    @Email(message = "邮箱格式无效")
    @NotNull(message = "邮箱不嫩为空")
    @ApiModelProperty("用户邮箱")
    private String email;
}
