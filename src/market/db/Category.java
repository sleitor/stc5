package market.db;

import java.util.Set;
import java.util.UUID;

/**
 * Created by Троицкий Дмитрий on 14.04.2017.
 */
public class Category {

    private UUID uuid;
    private String name;
    private Set<Product> products;

    public Category(String name, Set<Product> products) {
        this.name = name;
        this.products = products;
    }
}
