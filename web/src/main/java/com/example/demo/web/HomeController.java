package com.example.demo.web;

import com.example.demo.api.domain.GoodVO;
import com.example.demo.biz.service.GoodService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: CaiZiLin
 * @Date: 2019/4/19 11:35
 */
@RestController
@RequestMapping(value = "/")
public class HomeController {
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(HomeController.class);
    @Autowired
    GoodService goodService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String Index() {
        logger.info("Hello World订单");
        return "Hello World订单";
    }

    @RequestMapping(value = "/good/list", method = RequestMethod.GET)
    public List<String> GetGoodList() {
        List<String> list=new ArrayList<>();
        list.add("苹果");
        list.add("香蕉");
        return list;
    }

    @RequestMapping(value = "/good/list/{name}", method = RequestMethod.GET)
    public List<GoodVO> GetGoodList(@PathVariable String name) {
        logger.info("GetGoodList:"+name);
        return goodService.listGood(name);
    }

    @RequestMapping(value = "/good/listredis/{name}", method = RequestMethod.GET)
    public List<GoodVO> GetGoodListByRedis(@PathVariable String name) {
        return goodService.listGoodByRedis(name);
    }

    @RequestMapping(value = "/good/insert", method = RequestMethod.POST)
    public void InsertGood(@RequestParam String name, @RequestParam BigDecimal price) {
         goodService.insertGood(name,price);
    }
}
