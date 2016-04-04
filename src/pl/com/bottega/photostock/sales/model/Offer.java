package pl.com.bottega.photostock.sales.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by arkadiuszarak on 12/03/2016.
 */
public class Offer {

    private final Client owner;
    private List<Product> items = new LinkedList<>();
    double totalCost;

    public Offer(Client owner, List<Product> items) {
        this.owner = owner;
        this.items = items;
        this.totalCost = calculateTotalCost();
    }

    public double calculateTotalCost() {

        double costForAllItems = 0;
        for (Product prod: items){
           costForAllItems += prod.calculatePrice();
        }
        return costForAllItems;
    }

    public boolean sameAs(Offer offer, double isThesame){

        return true;
    }

    public int getItemsCount(){

        return items.size();
    }

    public double getTotalCost(){

        return 0;
    }

    public List<Product> getItems() {

        return items;
    }
}
