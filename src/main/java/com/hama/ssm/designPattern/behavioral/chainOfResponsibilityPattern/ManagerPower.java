package com.hama.ssm.designPattern.behavioral.chainOfResponsibilityPattern;/**
 * Created by Administrator on 2017/5/31.
 */

/**
 * @author Rns
 * @create 2017-05-31 21:31
 */
public class ManagerPower extends PurchasePower {
    protected double getAllowable() {
        return BASE*10;
    }

    protected String getRole() {
        return "Manager";
    }
}
