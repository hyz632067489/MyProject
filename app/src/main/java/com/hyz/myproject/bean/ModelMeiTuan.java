package com.hyz.myproject.bean;

/**
 * Created by hyz on 2016/10/17.
 * powered by company
 */

public class ModelMeiTuan {
    private  String name;
    private int iconRes;

    public ModelMeiTuan(String name) {
        this.name = name;
    }

    public ModelMeiTuan(String name, int iconRes) {
        this.name = name;
        this.iconRes = iconRes;
    }

    public String getName() {
        return name;
    }

    public ModelMeiTuan setName(String name) {
        this.name = name;
        return this;
    }

    public int getIconRes() {
        return iconRes;
    }

    public ModelMeiTuan setIconRes(int iconRes) {
        this.iconRes = iconRes;
        return this;
    }
}
