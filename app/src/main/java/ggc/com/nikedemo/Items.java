package ggc.com.nikedemo;

/**
 * Created by SOURAV on 7/8/2017.
 */

public class Items {
    String name;
    int price;

    String image_name;

    public String getImage_name() {
        return image_name;
    }

    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }

    public Items(String name, int price, String image_name) {
        this.name = name;
        this.price = price;
        this.image_name = image_name;
    }

    public Items(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
