package com.shoppingcartvobjects;

//Class for work using articles as objetcs
public class Article {

    //Attributes
    public String name;
    public double unitPrize;
    public int quantity;

    //Constructor
    Article(String name, double unitPrize, int quantity){
        this.name = name;
        this.unitPrize = unitPrize;
        this.quantity = quantity;
    }

}