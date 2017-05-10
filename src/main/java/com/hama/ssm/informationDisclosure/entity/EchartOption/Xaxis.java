package com.hama.ssm.informationDisclosure.entity.EchartOption;/**
 * Created by Administrator on 2017/4/17.
 */

import com.hama.ssm.util.base.BaseObject;

/**
 * xAxis
 *
 * @author Administrator
 * @create 2017-04-17 18:33
 */
public class Xaxis  extends BaseObject {

    private String [] data;

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }
}
