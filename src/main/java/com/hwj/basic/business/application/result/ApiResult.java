package com.hwj.basic.business.application.result;

import com.hwj.basic.result.RpcResult;

import java.io.Serializable;
import java.util.StringJoiner;

/**
 * @Program: hwj
 * @Description:
 * @author: peng.huang
 * @since: 2025-03-18 11:02:03
 */
public class ApiResult<T> implements Serializable {

    private static final long serialVersionUID = 7646046032863198811L;

    private static final String SUCCESS_CODE = "200";

    private String code;

    private String msg;

    private T data;

    /**
     * 请求成功
     * @return ApiResult<T>
     * @param <T> 泛型
     */
    public static <T> ApiResult<T> success() {
        ApiResult<T> response = new ApiResult<>();
        response.setCode(SUCCESS_CODE);
        return response;
    }

    /**
     * 请求成功
     * @param data 响应数据
     * @return ApiResult<T>
     * @param <T> 泛型
     */
    public static <T> ApiResult<T> success(T data) {
        ApiResult<T> response = new ApiResult<>();
        response.setCode(SUCCESS_CODE);
        response.setData(data);
        return response;
    }

    /**
     * 请求失败
     * @param code 错误码
     * @param msg 错误信息
     * @return ApiResult<T>
     * @param <T> 泛型
     */
    public static <T> ApiResult<T> failed(String code, String msg) {
        ApiResult<T> response = new ApiResult<>();
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }

    /**
     * 请求失败
     * @param rpcResult 服务端错误结果
     * @return ApiResult<T>
     * @param <T> 泛型
     */
    public static <T> ApiResult<T> failed(RpcResult<?> rpcResult) {
        ApiResult<T> response = new ApiResult<>();
        response.setCode(rpcResult.getCode());
        response.setMsg(rpcResult.getMsg());
        return response;
    }

    private ApiResult() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ApiResult.class.getSimpleName() + "[", "]")
                .add("code='" + code + "'")
                .add("msg='" + msg + "'")
                .add("data=" + data)
                .toString();
    }
}
