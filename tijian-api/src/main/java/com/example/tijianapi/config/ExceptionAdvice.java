package com.example.tijianapi.config;
import cn.dev33.satoken.exception.NotLoginException;
import cn.felord.payment.PayException;
import cn.hutool.json.JSONObject;
import com.example.tijianapi.exception.HisException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {
    /*
     * 捕获异常，并且返回500状态码
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Exception e) {
        JSONObject json = new JSONObject();
        if (e instanceof HttpMessageNotReadableException) {
            HttpMessageNotReadableException exception = (HttpMessageNotReadableException) e;
            log.error("error", exception);
            json.set("error", "请求未提交数据或者数据有误");
        }
        else if (e instanceof MissingServletRequestPartException) {
            MissingServletRequestPartException exception = (MissingServletRequestPartException) e;
            log.error("error", exception);
            json.set("error", "请求提交数据错误");
        }
        else if (e instanceof HttpRequestMethodNotSupportedException) {
            HttpRequestMethodNotSupportedException exception = (HttpRequestMethodNotSupportedException) e;
            log.error("error", exception);
            json.set("error", "HTTP请求方法类型错误");
        }
        //Web方法参数数据类型转换异常，比如String[]数组类型的参数，你上传的数据却是String类型
        else if (e instanceof BindException) {
            BindException exception = (BindException) e;
            String defaultMessage = exception.getFieldError().getDefaultMessage();
            log.error(defaultMessage, exception);
            json.set("error", defaultMessage);
        }
        //没有通过后端验证产生的异常
        else if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException exception = (MethodArgumentNotValidException) e;
            json.set("error", exception.getBindingResult().getFieldError().getDefaultMessage());
        }
        //处理业务异常
        else if (e instanceof HisException) {
            log.error("执行异常", e);
            HisException exception = (HisException) e;
            json.set("error", exception.getMsg());
        }
        //微信支付异常
        else if (e instanceof PayException) {
            PayException exception = (PayException) e;
            log.error("微信支付异常", exception);
            json.set("error", "微信支付异常");
        }
        //处理其余的异常
        else {
            log.error("执行异常", e);
            json.set("error", "执行异常");
        }
        return json.toString();
    }

    /*
     * 捕获异常，并且返回401状态码
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(NotLoginException.class)
    public String unLoginHandler(Exception e) {
        JSONObject json = new JSONObject();
        json.set("error", e.getMessage());
        return json.toString();
    }

}
