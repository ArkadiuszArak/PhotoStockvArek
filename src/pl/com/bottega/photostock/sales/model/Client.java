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

    public boolean canAfford(double amount) {

        if (isVIP) {
            double amountWithCreditLimit = this.amount + this.creditLimit;
            this.debt = amountWithCreditLimit - amount;

            if (this.amount <= amount && debt <= creditLimit && debt >= 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return this.amount >= amount;
        }
    }

    public void charge(double amount, String couse) {
        if (canAfford(amount)) {
            this.amount -= amount;
        } else {
            System.out.println("Not afford !!");
            return;
        }
    }

    public void recharge(double amount) {
        this.amount += amount;

    }

    public double getSaldo() {
        if(isVIP){
            return creditLimit + this.amount;
    }
        else {
            return this.amount;
    }

    }

}
