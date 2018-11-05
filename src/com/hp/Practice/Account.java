package com.hp.Practice;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *取款机总额实体类
 */
public class Account  {
    private Double money=10000.0;//存钱总额

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
