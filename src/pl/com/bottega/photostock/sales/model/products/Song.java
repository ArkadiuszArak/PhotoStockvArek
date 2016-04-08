package pl.com.bottega.photostock.sales.model.products;

/**
 * Created by arkadiuszarak on 03/04/2016.
 */
public class Song extends AbstractProduct {

    public enum CHANNELS{
        STEREO("2.0"),
        FIVE_ONE("5.1"),
        SEVEN_ONE("7.1");

        private String channel;
        CHANNELS(String channel) {
            this.channel = channel;
        }

        public String getChannel() {
            return channel;
        }
    }

    private String number;
    private String title;
    private double duration;
    private double price;
    private CHANNELS channel;
    private String[] tags;
    private String album;
    private String artist;
    private boolean isAvailable;

    public Song(String number, String[] tags, double price, boolean isAvailable, String title, double duration, CHANNELS channel, String album, String artist) {
        super(number, tags, price, isAvailable);
        this.title = title;
        this.duration = duration;
        this.channel = channel;
        this.album = album;
        this.artist = artist;
    }
}
