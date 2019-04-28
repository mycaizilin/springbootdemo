package com.example.demo.api.api;

import com.example.demo.api.domain.GoodVO;

import java.util.List;

/**
 * @Author: CaiZiLin
 * @Date: 2019/4/26 15:16
 */
public interface MyFacade {

    List<GoodVO>  getHotGoodList();

}
