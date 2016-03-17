package pl.com.bottega.photostock.sales.model;

/**
 * Created by arkadiuszarak on 12/03/2016.
 */
public class Reservation {

    private Client owerOfRes;
    private boolean items;

    private Picture item;

    public Reservation(Client owerOfRes) {

        this.owerOfRes = owerOfRes;
    }

    public void add(Picture picture){

    }

    public void remove(Picture picture){

    }

    public Offer generateOffer(){

        return null;
    }

    public int getItemsCount(){

        return 0; //TODO
    }
}
