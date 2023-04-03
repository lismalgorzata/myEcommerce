package pl.mlis.productcatalog;

import java.math.BigDecimal;
import java.util.UUID;

public class Product {
    private final String uuid;
    private final String name;
    private final String desc;
    private String image;
    private Boolean isPublished;
    private BigDecimal price;
    private Boolean isOnline;
    private final String color;
    private final int x;
    private final int y;

    public Product(UUID uuid, String name, String desc, String image, Boolean isPublished, BigDecimal price, String color, int x, int y) {
        this.uuid = uuid.toString();
        this.name = name;
        this.desc = desc;
        this.image = image;
        this.isPublished = isPublished;
        this.price = price;
        this.color = color;
        this.x = x;
        this.y = y;
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

    public Boolean getIsPublished() {
        return isPublished;
    }
    public void setIsPublished(Boolean isPublished){
        if (this.image == null || this.price == null){
            throw new ProductCannotBePublishedException();
        }
        this.isPublished = isPublished;
    }

    public void setOnline(boolean online) {

        this.isOnline = online;
    }
    public boolean getOnline() {
        return isOnline;
    }
}