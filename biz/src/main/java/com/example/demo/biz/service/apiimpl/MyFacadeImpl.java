package com.example.demo.biz.service.apiimpl;

import com.example.demo.api.api.MyFacade;
import com.example.demo.api.domain.GoodVO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: CaiZiLin
 * @Date: 2019/4/26 15:32
 */
//@Service
public class MyFacadeImpl implements MyFacade {

    @Override
    public List<GoodVO> getHotGoodList() {
        List<GoodVO>  list=new ArrayList<>();
        GoodVO vo=new GoodVO();
        vo.setName("可乐");
        vo.setPrice(new BigDecimal(2.33));
        list.add(vo);
        return  list;
    }
}
