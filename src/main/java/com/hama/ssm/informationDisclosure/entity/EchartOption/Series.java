package com.hama.ssm.informationDisclosure.entity.EchartOption;/**
 * Created by Administrator on 2017/4/17.
 */

import com.hama.ssm.util.base.BaseObject;

/**
 * series
 *
 * @author Administrator
 * @create 2017-04-17 18:34
 */
public class Series  extends BaseObject {

    private Data [] data;

    public Data[] getData() {
        return data;
    }

    public void setData(Data[] data) {
        this.data = data;
    }
}
