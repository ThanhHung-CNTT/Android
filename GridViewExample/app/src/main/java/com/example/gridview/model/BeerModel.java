package com.example.gridview.model;

import java.io.Serializable;

public class BeerModel implements Serializable {
    //Serializable: đồng bộ hóa giúp chuyển dữ liệu dù ở các tiến trình khác trở lại trạng thái object ban đầu
    private String beerName;
    private int imgID;

    public BeerModel() { }

    public BeerModel(String name, int id) {
        this.beerName = name;
        this.imgID = id;
    }

    public String getBeerName() {
        return beerName;
    }

    public void setBeerName(String beerName) {
        this.beerName = beerName;
    }

    public int getImgID() {
        return imgID;
    }

    public void setImgID(int imgID) {
        this.imgID = imgID;
    }
}
