package pl.com.bottega.photostock.sales.application;

import pl.com.bottega.photostock.sales.model.*;

/**
 * Created by arkadiuszarak on 12/03/2016.
 */
public class ConsoleApplication {
    public static void main(String[] args){


        Client client = new Client("Zenobiusz", "ul.x", 0);

        LightBox ldb = new LightBox(client);
        ldb.changeName("pily");
        System.out.println(ldb.getName());
        ldb.close();

        ldb.changeName("pilki");
        System.out.println(ldb.getName());

        if(true)

            return;

        //symulacja dostepu do bazy danych
        Picture picture1 = new Picture("pic-1", new String[]{"pila","drewno"}, 2, false);
        Picture picture2 = new Picture("pic-2", new String[]{"pila","drewno","dom"}, 7, false);
        Picture picture3 = new Picture("pic-3", new String[]{"drewno"}, 2, false);


        Reservation reservation = new Reservation(client);

        reservation.add(picture1);
        reservation.add(picture2);
        reservation.add(picture3);

        int count = reservation.getItemsCount();
        System.out.println(count);

        Offer offer = reservation.generateOffer();

        double offerTotalCost = offer.getTotalCost(); //zmienne pomocnicze
        boolean canAfford = client.canAfford(offerTotalCost);

        if (canAfford){
            client.charge(offerTotalCost, "Za zdjecia");
            Picture[] items = offer.getItems();
            Purchase purchase = new Purchase(client, items); //TODO przeladowac z oferty zakupu
        }
        else {
            System.out.println("Can't not afford ! You need " + offerTotalCost);
            return;
        }



    }
}
