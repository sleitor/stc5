package market.db;

import java.util.UUID;

/**
 * Created by Троицкий Дмитрий on 14.04.2017.
 */
public class Product {

    private UUID id;
    private String name;
    private String description;
    private int quantity;

    public UUID getId() {
        return id;
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

    public Product(String name, String description, int quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
    }

}
