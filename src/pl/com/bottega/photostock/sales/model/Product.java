package pl.com.bottega.photostock.sales.model;

import java.util.List;

/**
 * Created by arkadiuszarak on 03/04/2016.
 */
public interface Product {
    public boolean isAvailable();
    public double calculatePrice();
    public void cancel();
    public void reservedPer(Client client);
    public void unreservedPer(Client client);
}
