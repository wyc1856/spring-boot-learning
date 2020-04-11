package club.wyc1856.web.demo.enums;

import lombok.Getter;

/**
 * 返回结果枚举
 *
 * @author wyc1856
 * @date 2020/4/11
 **/
@Getter
public enum ResultCodeEnum {
    SUCCESS(1000, "处理成功"),
    FAILED(2000, "操作失败"),
    VALIDATE_FAILED(2001,"参数校验失败"),
    ERROR(5000, "未知错误")
    ;
    private int code;
    private String msg;

    ResultCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
