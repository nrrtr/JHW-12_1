package ru.netology.products;

public class Smartphone extends Product {
    private String manufacturer;

    public Smartphone() {
        super();
    }

    public Smartphone(int id, String name, int cost, String manufacturer) {
        super(id, name, cost);
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean matches(String search) {
        if (!super.matches(search)) {
            return this.getManufacturer().contains(search);
        } else {
            return true;
        }
    }
}
