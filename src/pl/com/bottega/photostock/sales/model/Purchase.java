package pl.com.bottega.photostock.sales.model;

import pl.com.bottega.photostock.sales.model.products.Picture;

import java.util.Date;
import java.util.List;

/**
 * Created by arkadiuszarak on 12/03/2016.
 */
public class Purchase {
    private Date purchaseData;
    private Client owner;
    private List<Product> itmes;

    public Purchase(Client owner, List<Product> items) {
        this.owner = owner;
        this.itmes = items;
    }

}
