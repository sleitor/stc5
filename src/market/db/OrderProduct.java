package market.db;

import java.util.Set;
import java.util.UUID;

/**
 * Created by Троицкий Дмитрий on 14.04.2017.
 */
public class OrderProduct {

    private UUID uuid;
    private Product product;
    private int count;
    private float cost;

    /** Конструктор, написанный вручную для продуктов к заказу */
    public OrderProduct(UUID uuid, Product product, int count, float cost) {
        this.uuid = uuid;
        this.product = product;
        this.count = count;
        this.cost = cost;
    }
}
