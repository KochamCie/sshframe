package com.hama.ssm.informationDisclosure.entity;/**
 * Created by Administrator on 2017/4/17.
 */

import com.hama.ssm.informationDisclosure.entity.EchartOption.*;
import com.hama.ssm.util.base.BaseObject;

/**
 * 柱状图
 *
 * @author Administrator
 * @create 2017-04-17 18:27
 */
public class HistogramOption  extends BaseObject {

    private Title title;
    private Tooltip tooltip;
    private Legend legend;

    private Xaxis xAxis;
    private Xaxis yAxis;

    private Data [] series;

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Tooltip getTooltip() {
        return tooltip;
    }

    public void setTooltip(Tooltip tooltip) {
        this.tooltip = tooltip;
    }

    public Legend getLegend() {
        return legend;
    }

    public void setLegend(Legend legend) {
        this.legend = legend;
    }

    public Xaxis getxAxis() {
        return xAxis;
    }

    public void setxAxis(Xaxis xAxis) {
        this.xAxis = xAxis;
    }

    public Xaxis getyAxis() {
        return yAxis;
    }

    public void setyAxis(Xaxis yAxis) {
        this.yAxis = yAxis;
    }

    public Data[] getSeries() {
        return series;
    }

    public void setSeries(Data[] series) {
        this.series = series;
    }
}
