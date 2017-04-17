package market.db;

import java.util.Set;
import java.util.UUID;

/**
 * Created by Троицкий Дмитрий on 14.04.2017.
 */
public class OrderProduct {

    private UUID id;
    private Product product;
    private int count;
    private float cost;

    public OrderProduct(Product product, int count, float cost) {
        this.product = product;
        this.count = count;
        this.cost = cost;
    }
}
