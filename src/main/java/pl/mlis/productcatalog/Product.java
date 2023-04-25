package pl.mlis.productcatalog;

import java.math.BigDecimal;
import java.util.UUID;

public class Product {
    private final String uuid;
    private final String name;
    private final String desc;
    private String image;
    private BigDecimal price;
    private boolean online;

    public Product(UUID uuid, String name, String desc) {
        this.uuid = uuid.toString();
        this.name = name;
        this.desc = desc;
    }

    public String getId() {
        return this.uuid;
    }

    public UUID getUUID() {
        return UUID.fromString(this.uuid);
    }

    public String getName() {
        return name;
    }

    public String getDesc() { return desc; }

    //ERP
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price){
        this.price = price;
    }
    public void changePrice(BigDecimal newPrice) {
        price = newPrice;
    }

    //ERP
    public String getImage() {
        return image;
    }
    public void setImage(String image){
        this.image = image;
    }


    public void setOnline(boolean online) {
        this.online = online;
    }

    public boolean getOnline() {
        return online;
    }


}