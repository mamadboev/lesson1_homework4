package models;

public class Product {
    private String maker;
    private int model;
    private String type;

    public Product(String maker, int model, String type) {
        this.maker = maker;
        this.model = model;
        this.type = type;
    }

    public Product() {
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Product{" +
                "maker='" + maker + '\'' +
                ", model='" + model + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
