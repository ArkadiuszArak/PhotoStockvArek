package pl.com.bottega.photostock.sales.application;

import pl.com.bottega.photostock.sales.model.*;
import pl.com.bottega.photostock.sales.model.products.AbstractProduct;
import pl.com.bottega.photostock.sales.model.products.Clip;
import pl.com.bottega.photostock.sales.model.products.Picture;
import pl.com.bottega.photostock.sales.model.products.Song;

/**
 * Created by arkadiuszarak on 03/04/2016.
 */
public class ProductsTestApp {
    public static void main(String[] args) {

        Client clientOne = new Client("Henry Ford", "ul.Forda", ClientStatus.STANDARD);
        Client clientTwo = new Client("Test client", "Ziemia", ClientStatus.VIP);

        AbstractProduct mustang = new Picture("nr1", new String[]{"ford", "mustang"}, 2, true);
        AbstractProduct sMax = new Picture("nr2", new String[]{"ford", "S-max"}, 200, true);
        AbstractProduct theDoorsClip = new Clip("nr 14", new String[]{"rock"}, 230, true, "Riders on the Storm", 23);
        AbstractProduct lightMyFire = new Song("nr 124", new String[]{"rock band", "The Doors"}, 35, true, "Light My Fire", 320, Song.CHANNELS.SEVEN_ONE, "L.A. Woman", "The Doors");

        Reservation reservationOne = new Reservation(clientOne);
        Reservation reservationTwo = new Reservation(clientTwo);

        reservationOne.add(mustang);
        mustang.reservedPer(clientOne);

        reservationOne.add(sMax);
        sMax.reservedPer(clientOne);

        reservationOne.add(theDoorsClip);
        theDoorsClip.reservedPer(clientOne);

        reservationOne.add(lightMyFire);
        lightMyFire.reservedPer(clientOne);

        reservationOne.remove(lightMyFire);
        lightMyFire.unreservedPer(clientOne);

        Offer offerOne = reservationOne.generateOffer();

        System.out.println("Items: " + offerOne.getItemsCount());
        System.out.println("Total cost: " + offerOne.calculateTotalCost());


        reservationTwo.add(lightMyFire);
        lightMyFire.reservedPer(clientTwo);

        Offer offerTwo = reservationTwo.generateOffer();
        System.out.println("Items: " + offerTwo.getItemsCount());
        System.out.println("Total cost: " + offerTwo.calculateTotalCost());

    }
}
