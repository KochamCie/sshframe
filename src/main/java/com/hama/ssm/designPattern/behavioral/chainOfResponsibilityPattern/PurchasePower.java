package com.hama.ssm.designPattern.behavioral.chainOfResponsibilityPattern;/**
 * Created by Administrator on 2017/5/31.
 */

/**
 * The PurchasePower abstract class with the abstract method processRequest.
 *
 * @author Administrator
 * @create 2017-05-31 21:19
 */
public abstract class PurchasePower {

    protected static final double BASE = 500;

    protected PurchasePower successor;

    abstract protected double getAllowable();

    abstract protected String getRole();

    public void setSuccessor(PurchasePower successor) {
        this.successor = successor;
    }

    public void processRequest(PurchaseRequest request) {
        if (request.getAmount() < this.getAllowable()) {
            System.out.println(this.getRole() + " will approve $" + request.getAmount());
        } else if (successor != null) {
            successor.processRequest(request);
        } else {
            System.out.println("no one can approve");
        }

    }


}
