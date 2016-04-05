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

        Client secondTestClient = new Client("Test client", "Ziemia", 12);

        Picture mustang = new Picture("nr1", new String[]{"ford", "mustang"}, 2, true);
        Picture sMax = new Picture("nr2", new String[]{"ford", "S-max"}, 200, true);

        Clip theDoorsClip = new Clip("Riders on the Storm", 100, 20, "nr 20", new String[]{"Art Rock","short"},true);

        Song lightMyFire = new Song("nr 12", "Ligh My Fire", 310, 360, Song.CHANNELS.SEVEN_ONE, new String[]{"rock band", "The Doors"},"L.A. Woman", "The Doors", true);

        Reservation reservation = new Reservation(client);

        Reservation secondTestReservation = new Reservation(secondTestClient);

        reservation.add(mustang);
        mustang.reservedPer(client);

        reservation.add(sMax);
        sMax.reservedPer(client);

        reservation.add(theDoorsClip);
        theDoorsClip.reservedPer(client);

        reservation.add(lightMyFire);
        lightMyFire.reservedPer(client);

        reservation.remove(lightMyFire);
        lightMyFire.unreservedPer(client);

        Offer oferta = reservation.generateOffer();

        int count = oferta.getItemsCount();
        System.out.println("Items: " + count);

        double totalPrice = oferta.calculateTotalCost();
        System.out.println("Total cost: " + totalPrice);

        secondTestReservation.add(lightMyFire);
        lightMyFire.reservedPer(secondTestClient);

        Offer secondTestOffer = secondTestReservation.generateOffer();
        System.out.println("Items: " + secondTestOffer.getItemsCount());
        System.out.println("Total cost: " + secondTestOffer.calculateTotalCost());

    }
}
