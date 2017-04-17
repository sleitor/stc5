package market.db;

import java.util.UUID;

/**
 * Created by Троицкий Дмитрий on 14.04.2017.
 */
public class Product {

    private UUID uuid;
    private String name;
    private String description;
    private int quantity;
    private int cost;

    public int getCost() {
        return cost;
    }


    public UUID getId() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product(UUID uuid, String name, String description, int quantity, int cost) {
        this.uuid = uuid;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.cost = cost;
    }

    //    public Product(String name, String description, int quantity) {
//        this.id = id;
//        this.name = name;
//        this.description = description;
//        this.quantity = quantity;
//    }

}
