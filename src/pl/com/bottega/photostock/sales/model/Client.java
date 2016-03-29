package pl.com.bottega.photostock.sales.model;

/**
 * Created by arkadiuszarak on 12/03/2016.
 */
public class Client {

    private String name;
    private String address;
    private boolean isVIP;
    private double amount; // ile ma kredytow w naszym systemie
    private double debt; //ile kredytu zaciagnal klient
    private double creditLimit;
    private  boolean active = true;

    public Client(String name, String address, boolean isVIP, double amount, double crditLimit) {
        this.name = name;
        this.address = address;
        this.isVIP = isVIP;
        this.debt = 0;
        this.amount = amount;
        this.creditLimit = crditLimit;
    }

    public Client(String name, String address, double crditLimit) {
        this(name, address, false, 0, crditLimit);
    }

    public boolean canAfford(double price) {
        if (isVIP) {
            double potencialOutOfLimit = amount + (creditLimit - debt);
                return potencialOutOfLimit >= price;
        }
        else {
            return amount >= price;
        }
    }

    public void charge(double finalePrice, String couse) throws IllegalStateException {
        if (canAfford(finalePrice)) {
            amount -= finalePrice;
            if (amount < 0){
                    debt -= finalePrice;
                    amount = 0;
            }
            else {
                throw new IllegalStateException("Can't afford");
            }
        }
    }

    public void recharge(double quantity) {
        if(debt != 0 && quantity > debt){
            this.amount = quantity - (Math.abs(debt) + this.amount);
            this.debt = 0;
        }
        else if(debt != 0 && quantity < debt){
            debt = Math.abs(debt) - quantity;
        }
        else{
            this.amount += quantity;
        }
    }

    public double getSaldo() {
        if(isVIP){
            return this.amount - Math.abs(debt);
        }
        else {
            return this.amount;
        }
    }

    public boolean isActive() {
        return active;
    }
}
