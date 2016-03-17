package pl.com.bottega.photostock.sales.model;

import java.util.Date;

/**
 * Created by arkadiuszarak on 12/03/2016.
 */
public class Purchase {
    private Date purchaseData;
    private Client owner;
    private Picture[] itmes;

    public Purchase(Client owner, Picture[] itmes) {
        this.owner = owner;
        this.itmes = itmes;
    }

}
