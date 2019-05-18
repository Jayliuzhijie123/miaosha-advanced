package com.miaosha.enums;

import lombok.Getter;

/**
 * Created by lzj on 2019/04/05
 *
 * @author lzj
 */
@Getter
public enum ResultEnum {
    /**
     * 返回的状态
     */
    SUCCESS(0, "获得了抢购资格！"),
    FAIL(-1, "失败");

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
