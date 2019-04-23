package com.example.demo.repository.dao;

import com.example.demo.repository.entity.GoodDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: CaiZiLin
 * @Date: 2019/4/19 15:33
 */
@Mapper
public interface GoodDAO {
     List<GoodDO>  listGood(@Param("name") String name);

     int insertGood(GoodDO goodDO);
}
