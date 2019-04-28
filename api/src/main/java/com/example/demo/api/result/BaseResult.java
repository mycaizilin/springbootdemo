package com.example.demo.api.result;

import java.io.Serializable;

/**
 * @Author: CaiZiLin
 * @Date: 2019/4/25 15:17
 */
public class BaseResult implements Serializable {

    private String code="001";

    private String message="成功";

    private boolean success=true;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
