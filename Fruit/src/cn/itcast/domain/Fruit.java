package cn.itcast.domain;/*
 *
 *2019/12/15 0015
 *
 */

public class Fruit {
    private String id;
    private String name;
    private String price;
    private String weight;
    private String address;

    public Fruit(String id, String name, String price, String weight, String address) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.address = address;
    }

    public Fruit() {
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", weight='" + weight + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
