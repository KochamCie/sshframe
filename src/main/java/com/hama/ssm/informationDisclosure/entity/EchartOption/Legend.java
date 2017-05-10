package com.hama.ssm.informationDisclosure.entity.EchartOption;/**
 * Created by Administrator on 2017/4/17.
 */

import com.hama.ssm.util.base.BaseObject;

/**
 * legend
 *
 * @author Administrator
 * @create 2017-04-17 18:30
 */
public class Legend  extends BaseObject {

    private String data;

    /*private String orient;

    private String x; // 'center',               // 水平安放位置，默认为全图居中，可选为：
    // 'center' ¦ 'left' ¦ 'right'
    // ¦ {number}（x坐标，单位px）
    private String y;// 'top',                  // 垂直安放位置，默认为全图顶端，可选为：
    // 'top' ¦ 'bottom' ¦ 'center'
    // ¦ {number}（y坐标，单位px）
    private String backgroundColor;// 'rgba(0,0,0,0)',
    private String borderColor;// '#ccc',       // 图例边框颜色
    private int borderWidth;// 0,            // 图例边框线宽，单位px，默认为0（无边框）
    private int padding;// 5,                // 图例内边距，单位px，默认各方向内边距为5，
    // 接受数组分别设定上右下左边距，同css
    private int itemGap;// 10,               // 各个item之间的间隔，单位px，默认为10，
    // 横向布局时为水平间隔，纵向布局时为纵向间隔
    private int itemWidth;// 20,             // 图例图形宽度
    private int itemHeight;// 14,            // 图例图形高度
*/

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    /*public String getOrient() {
        return orient;
    }

    public void setOrient(String orient) {
        this.orient = orient;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public int getBorderWidth() {
        return borderWidth;
    }

    public void setBorderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
    }

    public int getPadding() {
        return padding;
    }

    public void setPadding(int padding) {
        this.padding = padding;
    }

    public int getItemGap() {
        return itemGap;
    }

    public void setItemGap(int itemGap) {
        this.itemGap = itemGap;
    }

    public int getItemWidth() {
        return itemWidth;
    }

    public void setItemWidth(int itemWidth) {
        this.itemWidth = itemWidth;
    }

    public int getItemHeight() {
        return itemHeight;
    }

    public void setItemHeight(int itemHeight) {
        this.itemHeight = itemHeight;
    }*/
}
