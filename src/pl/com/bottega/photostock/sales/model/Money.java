package pl.com.bottega.photostock.sales.model;

import java.util.Currency;

/**
 * Created by arkadiuszarak on 12/03/2016.
 */
public class Money {
    private double value;
    private String currency;

    public Money(double value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    public Money(double value) {
        this(value, "PLN");
    }

    public Money(){
        this(0);
    }
}
