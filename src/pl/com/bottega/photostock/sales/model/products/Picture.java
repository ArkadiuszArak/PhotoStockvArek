package pl.com.bottega.photostock.sales.model.products;

import pl.com.bottega.photostock.sales.model.Client;

/**
 * Created by arkadiuszarak on 12/03/2016.
 */
public class Picture extends AbstractProduct{

    private String number;
    private String[] tags;
    private double price;
    private boolean isAvailable;

    public Picture(String number, String[] tags, double price, boolean isAvailable) {
        super(number, tags, price, isAvailable);
    }

    public void soldPer(Client client){

    }

    public String getNumber() {

        return number;
    }

    public double getPrice() {

        return price;
    }


}
