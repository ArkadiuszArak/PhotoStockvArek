package pl.com.bottega.photostock.sales.model;

/**
 * Created by arkadiuszarak on 03/04/2016.
 */
public enum ClientStatus {
    STANDARD, VIP, GOLD, SILVER, PLATINIUM;

    private static final String[] POLISHDICTIONARY = {"STANDARD", "VIP", "ZLOTY", "SREBRNY", "PLATYNOWY"};

    public String getPolishString() {
        int nr = this.ordinal();
        return POLISHDICTIONARY[nr];
    }
}
