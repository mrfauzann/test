package main.controller;

import main.model.Item;
import main.model.SoldItem;

import java.time.LocalDate;
import java.util.ArrayList;

public class PurchaseController {

    public static void buyItem(Item items, int qty, ArrayList<SoldItem> soldItems){
        int currentQty = items.getStock();
        if(validateStock(currentQty, qty)){
            items.setStock(currentQty - qty);
            soldItems.add(new SoldItem(items, qty, LocalDate.now()));
        } else{
            System.out.println("Insufficient stock");
        }

    }

    private static boolean validateStock(int currentQty, int qty){
        return (currentQty > qty) ? true : false;
    }

    public static void printHistory(ArrayList<SoldItem> items){
        for (SoldItem item : items) {
            System.out.println(item.toString());
        }
    }
}
