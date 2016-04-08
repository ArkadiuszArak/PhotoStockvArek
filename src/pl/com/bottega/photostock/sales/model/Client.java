package pl.com.bottega.photostock.sales.model;



/**
 * Created by arkadiuszarak on 12/03/2016.
 */
public class Client {


    private String name;
    private String address;
    private ClientStatus status;
    private double amount; // ile ma kredytow w naszym systemie

    private  boolean active = true;

    public Client(String name, String address, ClientStatus status, double amount) {
        this.name = name;
        this.address = address;
        this.status = status;
        this.amount = amount;
    }

    public Client(String name, String address, ClientStatus status) {
        this.name = name;
        this.address = address;
        this.status = status;
    }

    public Client(String name, String address) {
        this(name, address, ClientStatus.STANDARD);
    }

    public boolean canAfford(double price) {
        return amount >= price;
    }

    public void charge(double price, String couse) throws IllegalArgumentException {
        if (canAfford(price)) {
            amount -= price;
        } else
            throw new IllegalArgumentException("You can not afford this!");
    }

    public void recharge(double quantity) {
        amount += quantity;
    }

    public double getSaldo() {
            return this.amount;
    }

    public boolean isActive() {
        return active;
    }

    public String getName() {
        return name;
    }

    public String introduce(){
        return name + " - " + status.getPolishString();
    }
}
