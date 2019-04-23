package com.example.demo.biz.service;

import com.example.demo.api.domain.GoodVO;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: CaiZiLin
 * @Date: 2019/4/19 15:47
 */

public interface GoodService {


    List<GoodVO> listGood(String name);

    List<GoodVO> listGoodByRedis(String name);

    void  insertGood(String name, BigDecimal price);
}
