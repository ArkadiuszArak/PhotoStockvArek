package pl.com.bottega.photostock.sales.model.products;

import pl.com.bottega.photostock.sales.model.Client;
import pl.com.bottega.photostock.sales.model.Product;

/**
 * Created by arkadiuszarak on 03/04/2016.
 */
public class Song implements Product {

    public enum channels{
        STEREO(2.0),
        FIVE_ONE(5.1),
        SEVEN_ONE(7.1);

        private double channel;
        channels(double channel) {
            this.channel = channel;
        }

        public double getChannel() {
            return channel;
        }
    }

    private String number;
    private String title;
    private double lenghtOfSong;
    private double price;
    private channels channel;
    private String[] tags;
    private String album;
    private String artist;
    private boolean isAvailable;

    public Song(String number, String title, double lenghtOfSong, double price, channels channel, String[] tags, String album, String artist, boolean isAvailable) {
        this.number = number;
        this.title = title;
        this.lenghtOfSong = lenghtOfSong;
        this.price = price;
        this.channel = channel;
        this.tags = tags;
        this.album = album;
        this.artist = artist;
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
