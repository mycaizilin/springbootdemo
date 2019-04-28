package com.example.demo.api.result;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: CaiZiLin
 * @Date: 2019/4/25 15:44
 */
public class ListResult<T>  extends BaseResult {

    private List<T> dataList = new ArrayList();

    public static <S> ListResult<S> newSuccessResult(List<S> data) {
        ListResult<S> result = new ListResult();
        result.setDataList(data);
        return result;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }
}
