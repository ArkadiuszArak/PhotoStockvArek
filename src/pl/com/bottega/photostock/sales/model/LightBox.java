package pl.com.bottega.photostock.sales.model;

/**
 * Created by arkadiuszarak on 12/03/2016.
 */
public class LightBox {

    private String name;
    private Client owner;
    private Picture[] items = new Picture[1000];
    private boolean closed = false;

    public LightBox(Client owner) {
        this.owner = owner;
    }

    public void close(){
        this.closed = true;
    }

    public void changeName(String newName){
        if (!closed)
        this.name = newName;

    }

    public void add(Picture picture){

    }

    public void remove(Picture picture){

    }

    public String getName() {
        return name;
    }
}
