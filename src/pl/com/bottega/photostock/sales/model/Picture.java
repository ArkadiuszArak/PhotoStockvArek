package pl.com.bottega.photostock.sales.model;

/**
 * Created by arkadiuszarak on 12/03/2016.
 */
public class Picture {

    private String number;
    private String[] tags;
    private double price;
    private boolean isAvailable;

    public Picture(String number, String[] tags, double price, boolean active) {
        this.number = number;
        this.tags = tags;
        this.price = price;
        this.isAvailable = active;
    }

    public Picture(String number, String[] tags, double price) {
        this(number, tags, price, true);
    }

    public double calculatePrice(Client client){

        return 0; //ToDo dodac algo wyliczania
    }

    public boolean isAvailable(){
        return true;
    }

    public void reservedPer(Client client){

    }

    public void unreservedPer(Client client){

    }

    public void soldPer(Client client){

    }
}
