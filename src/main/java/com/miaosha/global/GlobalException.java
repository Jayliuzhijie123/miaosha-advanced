package com.miaosha.global;

import com.miaosha.exception.SeckillException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

/**
 * Created by lzj on 2019/04/05
 */
@RestControllerAdvice
@Slf4j
public class GlobalException {

    @ExceptionHandler(SeckillException.class)
    public Map<String, Object> handle(SeckillException e) {
        log.error(e.getMessage());
        return Result.fail(e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public Map<String, Object> handle(RuntimeException e) {
        log.error(e.getMessage());
        return Result.fail(e.getMessage());
    }
}
