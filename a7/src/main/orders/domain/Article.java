package orders.domain;

/**
 * Die Klasse für die Produkte.
 */
public class Article {

    private String productName;
    private PositiveInteger price;

    /**
     * Initialisiert ein Produkt mit Name und Preis.
     * @param productName der Name
     * @param price der Preis
     */
    public Article(String productName, PositiveInteger price) {
        this.productName = productName;
        this.price = price;
    }

    /**
     * Bereitet den Inhalt des Produktes als Zeichenkette auf.
     * @return die Zeichenkette für das Produkt
     */
    @Override
    public String toString() {
        return String.format("%s(%s€)", productName,price);
    }
}
