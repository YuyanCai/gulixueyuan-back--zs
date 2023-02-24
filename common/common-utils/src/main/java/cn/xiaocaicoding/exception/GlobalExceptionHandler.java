package cn.xiaocaicoding.exception;

import cn.xiaocaicoding.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: xiaocai
 * @since: 2023/02/23/21:35
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    //全局异常处理,当遇见Exception异常的时候调用error方法
    @ExceptionHandler(Exception.class)
    @ResponseBody//返回数据(它不在controller中所以要加上ResponseBody注解)
    public R error(Exception e){
        e.printStackTrace();
        return R.error().message("执行了全局异常处理....");
    }

    //    特定异常
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody//返回数据(它不在controller中所以要加上ResponseBody注解)
    public R error(ArithmeticException e){
        e.printStackTrace();
        return R.error().message("执行了ArithmeticException异常处理....");
    }

    //    自定义异常处理
    @ExceptionHandler(Guliexception.class)
    @ResponseBody//返回数据(它不在controller中所以要加上ResponseBody注解)
    public R error(Guliexception e){
        log.error(e.getMessage());
        e.printStackTrace();
        //这一套链式调用记得多debug
        return R.error().code(e.getCode()).message(e.getMsg());
    }
}
