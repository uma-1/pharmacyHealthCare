package model;

public class Items {

    private String id, name, module, imageName, size, ram, rom, os, fcamera, bcamera;
    private double price;

    public Items(String name, String module, String imageName, String size, String ram, String rom, String os, String fcamera, String bcamera, double price) {


        this.name = name;
        this.module = module;
        this.imageName = imageName;
        this.size = size;
        this.ram = ram;
        this.rom = rom;
        this.os = os;
        this.fcamera = fcamera;
        this.bcamera = bcamera;
        this.price = price;
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

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getRom() {
        return rom;
    }

    public void setRom(String rom) {
        this.rom = rom;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getFcamera() {
        return fcamera;
    }

    public void setFcamera(String fcamera) {
        this.fcamera = fcamera;
    }

    public String getBcamera() {
        return bcamera;
    }

    public void setBcamera(String bcamera) {
        this.bcamera = bcamera;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

