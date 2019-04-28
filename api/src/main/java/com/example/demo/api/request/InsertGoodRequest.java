package com.example.demo.api.request;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author: CaiZiLin
 * @Date: 2019/4/25 18:09
 */
public class InsertGoodRequest implements Serializable {
    private String name;
    private BigDecimal price;

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
