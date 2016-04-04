package pl.com.bottega.photostock.sales.model.products;

import pl.com.bottega.photostock.sales.model.Client;
import pl.com.bottega.photostock.sales.model.Product;

import java.util.List;

/**
 * Created by arkadiuszarak on 03/04/2016.
 */
public class Clip implements Product{

    private String title;
    private double price;
    private double lenghtOfClip;
    private String number;
    private String[] tags;
    private boolean isAvailable;

    public Clip(String title, double price, double lenghtOfClip, String number, String[] tags, boolean isAvailable) {
        this.title = title;
        this.price = price;
        this.lenghtOfClip = lenghtOfClip;
        this.number = number;
        this.tags = tags;
        this.isAvailable = isAvailable;
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
    public void reservedPer(Client client) {

    }

    @Override
    public void unreservedPer(Client client) {

    }
}
