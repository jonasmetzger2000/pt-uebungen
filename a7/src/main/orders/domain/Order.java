package orders.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Die Klasse für eine Bestellung, die eine Tabelle der bestellten Artikel mit der Bestellmenge verwaltet.
 */
public class Order
{
    private final List<Position> positions;
    private final String orderNumber;
    private final String customer;

    /**
     * Initialisiert eine "leere" Bestellung mit einer Nummer für eine Kunden.
     * @param customer der Besteller
     * @param orderNumber die Bestellnummer
     */
    public Order(String orderNumber, String customer) {
        this.orderNumber=orderNumber;
        this.customer=customer;
        this.positions = new ArrayList<>();
    }

    /**
     * Fügt eine Position in die Bestellung ein, ein Produkt mit der Bestellanzahl.
     * @param position zu hinzufügende Position
     */
    public void addPosition(Position position) {
        positions.add(position);
    }

    /**
     * Bereitet den Inhalt der Bestellung als Zeichenkette auf.
     * @return die Zeichenkette für die Bestellung
     */
    @Override
    public String toString() {
        return String.format("Order:%s from:%s positions:%s%n", orderNumber, customer, positions);
    }

    /**
     * Druckt die Bestellung formatiert aus.
     */
    public void pp() {
        System.out.printf("Order:%s from:%s%n", orderNumber, customer);
        for (Position position : positions) {
            System.out.printf("\t%s=>%s%n", position.getArticle(), position.getAmount());
        }
    }
}
