package market.db;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

/**
 * Created by Троицкий Дмитрий on 14.04.2017.
 */
public class Order {

    private UUID uuid;
    private User user;
    private Date date;
    private Set<OrderProduct> orderProductSet;
    private float cost;

    /** Pojo класс, написанный вручную для заказов продуктов */
    public Order(User user, Date date, Set<OrderProduct> orderProductSet, float cost) {
        this.user = user;
        this.date = date;
        this.orderProductSet = orderProductSet;
        this.cost = cost;
    }
}
