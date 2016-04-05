package pl.com.bottega.photostock.sales.model.products;

import pl.com.bottega.photostock.sales.model.Client;
import pl.com.bottega.photostock.sales.model.Product;

import java.util.List;

/**
 * Created by arkadiuszarak on 12/03/2016.
 */
public class Picture implements Product{

    private String number;
    private String[] tags;
    private double price;
    private boolean isAvailable;

    public Picture(String number, String[] tags, double price, boolean isAvailable) {
        this.number = number;
        this.tags = tags;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public Picture(String number, String[] tags, double price) {
        this(number, tags, price, true);
    }

/*    public double calculatePrice(Client client){

        return 0; //ToDo dodac algo wyliczania
    }*/

    public boolean isAvailable(){

        return isAvailable;
    }

    @Override
    public double calculatePrice() {

        return price;
    }

    public void reservedPer(Client reservingClient){
        if (!isAvailable)
            throw new IllegalStateException("Dear " + reservingClient.getName() + " you can't reserve this product");
        else
        isAvailable = false;
        System.out.println("Dear " + reservingClient.getName() + " you reserved picture " + getNumber());
    }

    public void unreservedPer(Client unreservigClient){
        isAvailable = true;
        System.out.println("You unreserved picture " + getNumber());
    }

    public void soldPer(Client client){

    }

    public void cancel() {

        isAvailable = false;
    }

    public String getNumber() {

        return number;
    }

    public double getPrice() {

        return price;
    }


}
