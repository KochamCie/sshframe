package com.hama.ssm.designPattern.behavioral.chainOfResponsibilityPattern;/**
 * Created by Administrator on 2017/5/31.
 */

/**
 * @author Rns
 * @create 2017-05-31 21:32
 */
public class DirectorPower extends PurchasePower {
    protected double getAllowable() {
        return BASE*20;
    }

    protected String getRole() {
        return "Director";
    }
}
