package market.db;

import java.util.Set;
import java.util.UUID;

/**
 * Created by Троицкий Дмитрий on 14.04.2017.
 */
public class OrderProduct {

    private UUID id;
    private Set<Product> productSet;
    private int count;
    private float cost;

    public OrderProduct(Set<Product> productSet, int count, float cost) {
        this.productSet = productSet;
        this.count = count;
        this.cost = cost;
    }
}
