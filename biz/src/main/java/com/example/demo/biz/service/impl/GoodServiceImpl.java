package com.example.demo.biz.service.impl;

import com.example.demo.api.domain.GoodVO;
import com.example.demo.biz.service.GoodService;
import com.example.demo.repository.dao.GoodDAO;
import com.example.demo.repository.entity.GoodDO;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: CaiZiLin
 * @Date: 2019/4/19 15:48
 */
@Service
public class GoodServiceImpl implements GoodService {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(GoodServiceImpl.class);
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    GoodDAO goodDAO;
    @Override
    public List<GoodVO> listGood(String name) {
        List<GoodDO> goodDOList= goodDAO.listGood(name);
        List<GoodVO> goodVOList=convertGoodDOToGoodVO(goodDOList);
        return goodVOList;
    }

    @Override
    public List<GoodVO> listGoodByRedis(String name) {
        List<GoodVO> object = (List<GoodVO>) redisTemplate.opsForValue().get(name);
        if(object==null){
            List<GoodDO> goodDOList= goodDAO.listGood(name);
            object=convertGoodDOToGoodVO(goodDOList);
            redisTemplate.opsForValue().set(name,object);
        }
        return object;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertGood(String name, BigDecimal price) {
        GoodDO goodDO=new GoodDO();
        goodDO.setName(name);
        goodDO.setPrice(price);
        goodDAO.insertGood(goodDO);
    }

    List<GoodVO>  convertGoodDOToGoodVO(List<GoodDO> goodDOList){
        List<GoodVO> goodVOList=new ArrayList<>();
        if(!CollectionUtils.isEmpty(goodDOList)){
            goodDOList.stream().forEach(x->{
                GoodVO goodVO=new GoodVO();
                goodVO.setId(x.getId());
                goodVO.setName(x.getName());
                goodVO.setPrice(x.getPrice());
                goodVOList.add(goodVO);
            });
        }
        return goodVOList;
    }
}
