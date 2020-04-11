package club.wyc1856.web.demo.enums;

import lombok.Getter;

/**
 * 异常枚举
 *
 * @author wyc1856
 * @date 2020/4/11
 **/
@Getter
public enum ApiExceptionEnum {
    SYSTEM_ERROR("系统异常");

    private String errorMsg;

    ApiExceptionEnum(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
