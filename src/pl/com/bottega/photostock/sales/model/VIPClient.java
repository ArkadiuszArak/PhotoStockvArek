package pl.com.bottega.photostock.sales.model;

/**
 * Created by arkadiuszarak on 06/04/2016.
 */
public class VIPClient extends Client {
    private double dept; //ile kredytu zaciagnal klient
    private double creditLimit;
    private double amount;

    public VIPClient(String name, String address, double amount, double creditLimit) {
        super(name, address, ClientStatus.VIP, amount);
        this.creditLimit = creditLimit;
        this.dept = 0;
    }

    public boolean canAfford(double price) {
        double purchasePotential = amount + (creditLimit - dept);
        return purchasePotential >= price;
    }

    public void charge(double price, String couse) throws IllegalArgumentException {
        if (canAfford(price)) {
            amount -= price;
            if (amount < 0) {
                dept -= amount;
                amount = 0;
            }
        } else
            throw new IllegalArgumentException("You can not afford this!");
    }

    public void recharge(double price) {
        if (dept == 0)
            amount += price;
        else if (dept > 0) {
            dept -= price;
            if (dept < 0) {
                amount -= dept;
                dept = 0;
            }
        }
    }

    public double getSaldo() {
        if (amount == 0)
            return -dept;
        else
            return amount;
    }
}
