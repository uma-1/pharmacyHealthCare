package model;

public class Items {

    private String id, name, imageName, description;
    private double price;

    public Items(String itemName, String name, double price, String description) {


        this.name = name;
        this.price = price;
        this.imageName = imageName;
        this.description = description;

    }






    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getprice() {
        return price;
    }

    public void setModule(String module) {
        this.price = price;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getDesc() {
        return description;
    }

    public void setDescription(String bcamera) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

