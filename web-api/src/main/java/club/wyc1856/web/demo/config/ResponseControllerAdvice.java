package club.wyc1856.web.demo.config;

import club.wyc1856.web.demo.enums.ApiExceptionEnum;
import club.wyc1856.web.demo.exception.ApiException;
import club.wyc1856.web.demo.vo.ResultVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * todo
 *
 * @author wyc1856
 * @date 2020/4/11
 **/
@Slf4j
@RestControllerAdvice(basePackages = "club.wyc1856.web.demo.controller")
public class ResponseControllerAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        //返回为true才会执行beforeBodyWrite方法进行增强
        return !returnType.getGenericParameterType().equals(ResultVO.class);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (returnType.getGenericParameterType().equals(String.class)) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                return objectMapper.writeValueAsString(new ResultVO<>(body));
            } catch (JsonProcessingException e) {
                log.error("返回类型为 String，转换时出现异常:", e);
                throw new ApiException(ApiExceptionEnum.SYSTEM_ERROR);
            }
        }
        return new ResultVO<>(body);
    }
}
