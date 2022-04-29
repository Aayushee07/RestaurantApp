package com.example.restaurantapp;

public class MyCartModel {

String productName,productPrice;
int totalPrice;

    public MyCartModel() {
    }

    public MyCartModel(String productName, String productPrice,int totalPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.totalPrice = totalPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName() {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public int getTotalPrice(){
        return totalPrice;
    }
    public void setTotalPrice(int totalPrice){
        this.totalPrice = totalPrice;
    }
}
