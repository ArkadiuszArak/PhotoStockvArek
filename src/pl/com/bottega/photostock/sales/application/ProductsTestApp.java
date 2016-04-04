package pl.com.bottega.photostock.sales.application;

import pl.com.bottega.photostock.sales.model.Client;
import pl.com.bottega.photostock.sales.model.Offer;
import pl.com.bottega.photostock.sales.model.Reservation;
import pl.com.bottega.photostock.sales.model.products.Clip;
import pl.com.bottega.photostock.sales.model.products.Picture;
import pl.com.bottega.photostock.sales.model.products.Song;

/**
 * Created by arkadiuszarak on 03/04/2016.
 */
public class ProductsTestApp {
    public static void main(String[] args) {
        Client client = new Client("Henry Ford", "ul.Forda", 0);

        Picture mustang = new Picture("nr1", new String[]{"ford", "mustang"}, 2, true);
        Picture sMax = new Picture("nr2", new String[]{"ford", "S-max"}, 200, true);

        Clip theDoorsClip = new Clip("Riders on the Storm", 100, 20, "nr 20", new String[]{"Art Rock","short"},true);

        Song ridersOnTheStorm = new Song("nr 12", "Riders on the storm", 310, 3, Song.channels.STEREO, new String[]{"rock band", "The Doors"},"L.A. Woman", "The Doors", true);

        Reservation reservation = new Reservation(client);

        reservation.add(mustang);
        reservation.add(theDoorsClip);
        reservation.add(sMax);
        reservation.add(ridersOnTheStorm);

        Offer oferta = reservation.generateOffer();

        int count = oferta.getItemsCount();
        System.out.println("Ilosc pozycji: " + count);

        double totalPrice = oferta.calculateTotalCost();
        System.out.println("Cena za zamowienie: " + totalPrice);

    }
}
