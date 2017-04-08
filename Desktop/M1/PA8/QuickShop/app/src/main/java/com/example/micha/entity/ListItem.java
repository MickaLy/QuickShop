package com.example.micha.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by micha on 22/03/2017.
 */

public class ListItem {
    private List<Product> listItem;


    public ListItem(){
        this.listItem = new ArrayList<Product>();
    }

    public void add(Product product){
        this.listItem.add(product);
    }
}
