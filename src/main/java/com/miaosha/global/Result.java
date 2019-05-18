package com.miaosha.global;

import com.miaosha.enums.ResultEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lzj on 2019/04/05
 */
public class Result {

    public static Map<String, Object> success() {
        Map<String, Object> map = new HashMap<>(3);
        ResultEnum success = ResultEnum.SUCCESS;
        map.put("code", success.getCode());
        map.put("message", success.getMessage());
        return map;
    }

    public static Map<String, Object> fail(String message) {
        Map<String, Object> map = new HashMap<>(3);
        ResultEnum fail = ResultEnum.FAIL;
        map.put("code", fail.getCode());
        map.put("message", message);
        return map;
    }
}
