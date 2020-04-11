package club.wyc1856.web.demo.exception;

import club.wyc1856.web.demo.enums.ApiExceptionEnum;
import lombok.Getter;

/**
 * 自定义异常
 *
 * @author wyc1856
 * @date 2020/4/11
 **/
@Getter
public class ApiException extends RuntimeException {

    private String errorMsg;

    public ApiException(ApiExceptionEnum exceptionEnum) {
        super(exceptionEnum.getErrorMsg());
        this.errorMsg = exceptionEnum.getErrorMsg();
    }
}
