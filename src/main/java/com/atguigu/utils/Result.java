package com.atguigu.utils;

import java.io.Serializable;

public class Result implements Serializable {
    private boolean status ; //响应状态  true  false
    private String msg ;  // 响应信息
    private Object data ;  //处理成功的响应数据

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static Result ok(Object data) {
        Result result = new Result();
        result.setStatus(true);
        result.setData(data);
        result.setMsg("查询成功");
        return result;
    }

    public static Result error() {
        Result result = new Result();
        result.setStatus(true);
        result.setMsg("查询失败");
        return result;
    }
}
