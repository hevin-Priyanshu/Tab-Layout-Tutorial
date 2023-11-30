package com.demo.tablayoutapp.Model;

public class MyData {

    private final int stringResourceId;

    private final int imageResourceId;

    public MyData(int stringResourceId, int imageResourceId) {
        this.stringResourceId = stringResourceId;
        this.imageResourceId = imageResourceId;
    }

    public int getStringResourceId() {
        return stringResourceId;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
