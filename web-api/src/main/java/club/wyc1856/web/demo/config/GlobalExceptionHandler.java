package club.wyc1856.web.demo.config;

import club.wyc1856.web.demo.enums.ResultCodeEnum;
import club.wyc1856.web.demo.exception.ApiException;
import club.wyc1856.web.demo.vo.ResultVO;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * todo
 *
 * @author wyc1856
 * @date 2020/4/11
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVO<String> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e){
        //从异常对象中活动 ObjectError
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        //返回异常信息
        return new ResultVO<>(ResultCodeEnum.VALIDATE_FAILED, objectError.getDefaultMessage());
    }

    @ExceptionHandler(ApiException.class)
    public ResultVO<String> apiExceptionHandler(ApiException e){
        return new ResultVO<>(ResultCodeEnum.FAILED, e.getErrorMsg());
    }

    @ExceptionHandler(Exception.class)
    public ResultVO<String> exceptionHandler(Exception e){
        return new ResultVO<>(ResultCodeEnum.ERROR, e.getMessage());
    }
}
