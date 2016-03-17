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

    public boolean canAfford(double amount){

        if(isVIP){
            double purchasePotential = this.creditLimit + this.amount;
            this.debt = purchasePotential - amount;
            if(debt <= 0){
                return false;
            }
            else {
                return true;
            }
        }
        else {
           return this.amount >= amount;
        }
    }
    public void charge(double amount, String couse) {
        if (canAfford(amount)) {
            this.amount -= amount;
        }
        else{
            System.out.println("not afford");
        }
    }

    public void recharge(double amount){
        this.amount += amount;

    }

    public double getSaldo() {
        if(isVIP && debt <= creditLimit){
            return this.debt;
    }
        else {
            return this.amount;
    }
    }

}
