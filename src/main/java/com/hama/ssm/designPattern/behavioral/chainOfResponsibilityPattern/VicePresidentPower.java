package com.hama.ssm.designPattern.behavioral.chainOfResponsibilityPattern;/**
 * Created by Administrator on 2017/5/31.
 */

/**
 * @author Rns
 * @create 2017-05-31 21:33
 */
public class VicePresidentPower extends PurchasePower {
    protected double getAllowable() {
        return BASE*40;
    }

    protected String getRole() {
        return "VicePresent";
    }
}
