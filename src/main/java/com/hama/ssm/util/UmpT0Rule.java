package com.hama.ssm.util;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author kdliu
 */

//@XmlRootElement(name = "rule")
//@XmlAccessorType(XmlAccessType.FIELD)
public class UmpT0Rule {

    //@XmlElement(name = "holiday",required = true)
    private boolean holiday;

    //@XmlElement(name = "start",required = true)
    private String start;

    //@XmlElement(name = "end",required = true)
    private String end;

    //@XmlElement(name = "amountLimit",required = true)
    private int amountLimit;

    public UmpT0Rule() {
    }

    public boolean isHoliday() {
        return holiday;
    }

    public void setHoliday(boolean holiday) {
        this.holiday = holiday;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public int getAmountLimit() {
        return amountLimit;
    }

    public void setAmountLimit(int amountLimit) {
        this.amountLimit = amountLimit;
    }

    public UmpT0Rule(boolean holiday, String start, String end, int amountLimit) {
        this.holiday = holiday;
        this.start = start;
        this.end = end;
        this.amountLimit = amountLimit;
    }
}
