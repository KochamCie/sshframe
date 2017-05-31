package com.hama.ssm.designPattern.behavioral.chainOfResponsibilityPattern;/**
 * Created by Administrator on 2017/5/31.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Rns
 * @create 2017-05-31 21:35
 */
public class CheckAuthority {

    public static void main(String[] args) {
        ManagerPower manager = new ManagerPower();
        DirectorPower director = new DirectorPower();
        VicePresidentPower vicePresident = new VicePresidentPower();
        PresidentPower president = new PresidentPower();
        // set their successor
        manager.setSuccessor(director);
        director.setSuccessor(vicePresident);
        vicePresident.setSuccessor(president);

        // func
        try {
            while (true) {
                System.out.println("Enter the amount to check who should approve your expenditure.");
                System.out.print(">");
                double d = Double.parseDouble(new BufferedReader(new InputStreamReader(System.in)).readLine());
                manager.processRequest(new PurchaseRequest(d, "General"));
            }
        } catch (Exception exc) {
            System.exit(1);
        }
    }


}
