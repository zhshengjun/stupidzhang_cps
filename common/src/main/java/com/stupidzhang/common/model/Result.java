package com.stupidzhang.common.model;


public class Result<T> {

    private static final Result<String> RESULT_OK = new Result<>(ResultCode._200, "success");

    private static final Result<String> RESULT_FAILED = new Result<>(ResultCode._500);

    private Integer code;

    private String message;

    private T data;

    public Result() {

    }

    public Result(int code) {
        this.code = code;
    }

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    /**
     * @return 默认成功 200
     */
    public static Result<String> ok() {
        return RESULT_OK;
    }

    /**
     * @return 默认失败 500
     */
    public static Result<String> failed() {
        return RESULT_FAILED;
    }

    public static <T> Result<T> ok(T data) {
        return new Result<T>(ResultCode._200, null, data);
    }

    public static <T> Result<T> of(int code, String msg) {
        return new Result<T>(code, msg);
    }

    public static boolean isNotOk(Result<String> result) {
        return !isOk(result);
    }

    public static boolean isOk(Result<?> result) {
        if (result == null) {
            return false;
        }
        return RESULT_OK.getCode().equals(result.getCode());
    }

    public boolean isOk() {
        return isOk(this);
    }

}
