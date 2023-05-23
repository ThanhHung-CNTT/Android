package com.nguyenphamthanhhung.test.Module;

import java.io.Serializable;

public class Tour implements Serializable {
    int ID;
    String Ten;
    String Mota;
    int Soluong;
    String Lichtrinh;
    double Gia;

    public Tour(int ID, String ten, String mota, int soluong, String lichtrinh, double gia) {
        this.ID = ID;
        Ten = ten;
        Mota = mota;
        Soluong = soluong;
        Lichtrinh = lichtrinh;
        Gia = gia;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String mota) {
        Mota = mota;
    }

    public int getSoluong() {
        return Soluong;
    }

    public void setSoluong(int soluong) {
        Soluong = soluong;
    }

    public String getLichtrinh() {
        return Lichtrinh;
    }

    public void setLichtrinh(String lichtrinh) {
        Lichtrinh = lichtrinh;
    }

    public double getGia() {
        return Gia;
    }

    public void setGia(double gia) {
        Gia = gia;
    }
}
