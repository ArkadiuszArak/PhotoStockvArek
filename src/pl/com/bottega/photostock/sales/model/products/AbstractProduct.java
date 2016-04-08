package pl.com.bottega.photostock.sales.model.products;

import pl.com.bottega.photostock.sales.model.Client;
import pl.com.bottega.photostock.sales.model.Product;

/**
 * Created by arkadiuszarak on 06/04/2016.
 */
public abstract class AbstractProduct implements Product {

    private String number;
    private String[] tags;
    private double price;
    private boolean isAvailable;

    public AbstractProduct(String number, String[] tags, double price, boolean isAvailable) {
        this.number = number;
        this.tags = tags;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public void reservedPer(Client reservingClient){
        if (!isAvailable)
            throw new IllegalStateException("Dear " + reservingClient.getName() + " you can't reserve this product");
        else
            isAvailable = false;
        System.out.println("Dear " + reservingClient.getName() + " you reserved product: " + number);
    }

    @Override
    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public double calculatePrice() {
        return price;
    }

    @Override
    public void cancel() {
        isAvailable = false;
    }

    @Override
    public void unreservedPer(Client client) {
        isAvailable = true;
    }
}
