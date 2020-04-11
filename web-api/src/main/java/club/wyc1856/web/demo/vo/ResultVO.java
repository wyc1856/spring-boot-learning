package club.wyc1856.web.demo.vo;

import club.wyc1856.web.demo.enums.ResultCodeEnum;
import lombok.Getter;

/**
 * 统一返回实体
 *
 * @author wyc1856
 * @date 2020/4/11
 **/
@Getter
public class ResultVO<T> {

    private int code;

    private String msg;

    private T data;

    public ResultVO(T data){
        this(ResultCodeEnum.SUCCESS, data);
    }

    public ResultVO(ResultCodeEnum codeEnum, T data){
        this.code = codeEnum.getCode();
        this.msg = codeEnum.getMsg();
        this.data = data;
    }
}
