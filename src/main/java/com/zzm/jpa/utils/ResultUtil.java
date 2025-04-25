package com.zzm.jpa.utils;

import com.zzm.jpa.common.Result;

/**
 * @ClassName: ResultUtil
 * @Description: 统一返回格式
 * @Author: 邹智敏
 * @Date: 2018/8/13   16:06
 * @Version: 1.0
 */
public class ResultUtil {

    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("ok");
        result.setData(object);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(String msg) {
        Result result = new Result();
        result.setCode(-1);
        result.setMsg(msg);
        return result;
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
