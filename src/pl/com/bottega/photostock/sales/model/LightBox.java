package pl.com.bottega.photostock.sales.model;

import pl.com.bottega.photostock.sales.model.products.Picture;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arkadiuszarak on 12/03/2016.
 */
public class LightBox {

    private String name;
    private Client owner;
    private List<Picture> items = new ArrayList<>();
    private boolean closed = false;
    private List<LightBox> lightboxes = new ArrayList<>();
    private Picture[] listOfPic;

    public LightBox(Client owner) {
        this.owner = owner;
    }


    public void close() {

        this.closed = true;
    }

    public void changeName(String newName) {
        validate();
        this.name = newName;

    }

    public void add(Picture pictureToAdd) {
      validate();
        if (items.contains(pictureToAdd))
            throw new IllegalArgumentException("alredy contains");
        items.add(pictureToAdd);
    }

    //   public void add(Picture pictureToAdd) throws IllegalStateException, IllegalArgumentException{


////        //for (int cursor = 0; cursor < items.length; cursor ++){
////        for (Picture pic : items){
////           // Picture pic = items[cursor];
////            if (pic != null){
////                String nr1 = pic.getNumber();
////                String nr2 = pictureToAdd.getNumber();
////
////                if(nr1.equals(nr2)){
////                    throw new IllegalArgumentException("light box already contains picture" + pictureToAdd.getNumber());
////                }
////        }
////        }
////        boolean added = false;
////        for (int cursor = 0; cursor < items.length; cursor ++){
////            Picture reference = items[cursor];
////            if (reference == null){
////                items[cursor] = pictureToAdd;
////                added = true;
////                break;
////            }
////        }
////        if(!added)
////        throw  new IllegalStateException("Lightbox przepelniony");
    //}

    public void remove(Picture pictureToRemove) {
       validate();
        boolean remove = items.remove(pictureToRemove);
        if (!remove)
            throw new IllegalArgumentException("does not contain");
    }

    public String getName() {

        return name;
    }

    public String setName(String name){
        return this.name = name;
    }

    public int getItemsCount() {

        return items.size();
    }


    private void validate() {
        if (closed)
            throw new IllegalStateException("closed");
        if (!owner.isActive())
            throw new IllegalStateException("owner is not active");
    }

    public List<Picture> getPictures() {
        return items;
    }

    public Client getOwnerName() {

        return owner;
    }

    public List<Picture> getItems() {
        return items;
    }
}
