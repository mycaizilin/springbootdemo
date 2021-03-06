package com.example.demo.repository.entity;

import java.math.BigDecimal;

/**
 * @Author: CaiZiLin
 * @Date: 2019/4/19 14:47
 */
public class GoodDO {
    private Long id;
    private String  name;
    private BigDecimal  price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

