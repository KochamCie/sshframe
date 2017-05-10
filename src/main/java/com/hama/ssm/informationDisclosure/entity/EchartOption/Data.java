package com.hama.ssm.informationDisclosure.entity.EchartOption;/**
 * Created by Administrator on 2017/4/17.
 */

import com.hama.ssm.util.base.BaseObject;

/**
 * data
 *
 * @author Administrator
 * @create 2017-04-17 18:35
 */
public class Data extends BaseObject {

    private String name;
    private String type;
    private String barWidth;
    private int [] data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBarWidth() {
        return barWidth;
    }

    public void setBarWidth(String barWidth) {
        this.barWidth = barWidth;
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }
}
