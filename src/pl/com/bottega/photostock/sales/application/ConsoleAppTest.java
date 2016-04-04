package pl.com.bottega.photostock.sales.application;

import pl.com.bottega.photostock.sales.model.Client;

/**
 * Created by arkadiuszarak on 15/03/2016.
 */
public class ConsoleAppTest {
    public static void main(String[] args) {
       // Client misiekZdzisiek = new Client("Zdzisiek", "Las", 0); //nie jest VIP
        Client panKozica = new Client("Kozica" ,"Gory", Client.Status.VIP, 0 ,100); // VIP

/*        misiekZdzisiek.recharge(23);
        misiekZdzisiek.charge(10, "cos");
        System.out.println("Saldo dla Zdziska: " + misiekZdzisiek.getSaldo());*/

        panKozica.recharge(10);
        //panKozica.charge(100, "cos");
        //System.out.println("Saldo dla Kozicy z limitem: " + panKozica.getSaldo());


    }

}
