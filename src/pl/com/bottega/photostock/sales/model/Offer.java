package pl.com.bottega.photostock.sales.model;

/**
 * Created by arkadiuszarak on 12/03/2016.
 */
public class Offer {

    private Picture[] items;

    public Offer(Picture[] items) {

        this.items = items;
    }

    public boolean sameAs(Offer offer, double isThesame){

        return true;
    }

    public int getItemsCount(){

        return 0;
    }

    public double getTotalCost(){

        return 0;
    }

    public Picture[] getItems() {

        return items;
    }
}
