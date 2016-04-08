package pl.com.bottega.photostock.sales.model.products;

/**
 * Created by arkadiuszarak on 03/04/2016.
 */
public class Clip extends AbstractProduct {

    private String title;
    private double duration;
    private boolean isAvailable;

    public Clip(String number, String[] tags, double price, boolean isAvailable, String title, double duration) {
        super(number,tags,price,isAvailable);
        this.title = title;
        this.duration = duration;
    }

    public double getDuration() {
        return duration;
    }
}
