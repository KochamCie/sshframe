package com.hama.ssm.informationDisclosure.entity.EchartOption;/**
 * Created by Administrator on 2017/4/17.
 */

import com.hama.ssm.util.base.BaseObject;

/**
 * title选项
 *
 * @author Administrator
 * @create 2017-04-17 18:29
 */
public class Title  extends BaseObject {

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
