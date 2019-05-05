package com.example.demo.web.controller;

import com.example.demo.api.request.InsertGoodRequest;
import com.example.demo.api.result.BaseResult;
import com.example.demo.api.result.ListResult;
import com.example.demo.api.result.PlainResult;
import com.example.demo.biz.service.GoodService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public BaseResult Index() {
        logger.info("Hello World订单");
        return PlainResult.newSuccessResult("Hello World订单");
    }

    @RequestMapping(value = "/good/list", method = RequestMethod.GET)
    public BaseResult GetGoodList() {
        List<String> list = new ArrayList<>();
        list.add("苹果");
        list.add("香蕉");
        return ListResult.newSuccessResult(list);
    }

    @RequestMapping(value = "/good/list/{name}", method = RequestMethod.GET)
    public BaseResult GetGoodList(@PathVariable String name) {
        logger.info("GetGoodList:" + name);
        return ListResult.newSuccessResult(goodService.listGood(name));
    }

    @RequestMapping(value = "/good/list/redis/{name}", method = RequestMethod.GET)
    public BaseResult GetGoodListWithRedis(@PathVariable String name) {
        return ListResult.newSuccessResult(goodService.listGoodWithRedis(name));
    }

    @RequestMapping(value = "/good/list/mq/{name}", method = RequestMethod.GET)
    public BaseResult GetGoodListWithMq(@PathVariable String name) {
        return ListResult.newSuccessResult(goodService.listGoodWithMq(name));
    }

    @RequestMapping(value = "/good/list/dubbo/{name}", method = RequestMethod.GET)
    public BaseResult GetGoodListWithDubbo(@PathVariable String name) {
        return ListResult.newSuccessResult(goodService.listGoodWithDubbo(name));
    }

    @RequestMapping(value = "/good/list/ex/{name}", method = RequestMethod.GET)
    public BaseResult GetGoodListWithException(@PathVariable String name) throws Exception {
        throw new Exception("自定义异常");
    }

    @RequestMapping(value = "/good/insert", method = RequestMethod.POST)
    public BaseResult InsertGood(@RequestBody InsertGoodRequest insertGoodRequest, HttpServletRequest request) {
        goodService.insertGood(insertGoodRequest.getName(), insertGoodRequest.getPrice());
        return PlainResult.newSuccessResult("");
    }
}
