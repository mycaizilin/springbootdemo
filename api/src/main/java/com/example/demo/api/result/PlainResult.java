package com.example.demo.api.result;

/**
 * @Author: CaiZiLin
 * @Date: 2019/4/25 15:42
 */
public class PlainResult<T> extends  BaseResult{

    private T data;

    public static <S> PlainResult<S> newSuccessResult(S data) {
        PlainResult<S> result = new PlainResult();
        result.setData(data);
        return result;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
