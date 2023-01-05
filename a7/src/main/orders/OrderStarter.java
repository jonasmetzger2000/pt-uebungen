package orders;

import orders.domain.Order;

import java.io.File;

public class OrderStarter {

    public static void main(String[] args) throws IncompleteOrderException {
        final OrderReader orderReader = new OrderReader(new File(OrderReader.class.getResource("december_orders").getPath()));
        for (Order order : orderReader.fetchOrders()){
            order.pp();
        }
    }
}
