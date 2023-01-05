package orders;

import orders.domain.Article;
import orders.domain.Order;
import orders.domain.Position;
import orders.domain.PositiveInteger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class OrderReader {

    public static final String ORDER_DETAILS_MARKER = "&";

    private final Scanner orderScanner;
    private final List<Order> orderList;

    public OrderReader(File orderFile) {
        try {
            orderScanner = new Scanner(orderFile);
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("File not found", e);
        }
        orderList = new ArrayList<>();
    }

    public List<Order> fetchOrders() {
        int lineCounter = 0;
        while (orderScanner.hasNextLine()) {
            parseOrderLine(orderScanner.nextLine(), ++lineCounter);
        }
        return orderList;
    }

    private void parseOrderLine(String line, int lineCounter) {
        try {
            orderList.add(parseOrderDetails(line, lineCounter));
        } catch (IncompleteOrderException | NotAPositiveNumberException | NumberFormatException e) {
            System.err.printf("line %d: '%s' threw %s%n", lineCounter, line, e);
        }
    }

    private Order parseOrderDetails(String line, int lineCounter) throws IncompleteOrderException, NotAPositiveNumberException {
        final String[] orderDetails = line.split(ORDER_DETAILS_MARKER);
        if (orderDetails.length < 3) throw new IncompleteOrderException(orderDetails);
        String orderId = orderDetails[0].strip();
        String customerName = orderDetails[1].strip();
        final Order order = new Order(orderId, customerName);

        final String[] positions = Arrays.copyOfRange(orderDetails, 2, orderDetails.length);
        for (String position : positions) {
            order.addPosition(parsePositionDetails(position));
        }
        return order;
    }

    private Position parsePositionDetails(String position) throws IncompleteOrderException, NotAPositiveNumberException {
        final String[] positionDetails = position.split("::");
        if (positionDetails.length < 3) throw new IncompleteOrderException(positionDetails);
        final String articleDescription = positionDetails[0].strip();
        final PositiveInteger price = new PositiveInteger(Integer.parseInt(positionDetails[1].strip()));
        final PositiveInteger amount = new PositiveInteger(Integer.parseInt(positionDetails[2].strip()));
        return new Position(new Article(articleDescription, price), amount);
    }
}
