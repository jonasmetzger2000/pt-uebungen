package orders.domain;

/**
 * Die Klasse welche die Information einer Position innerhalb einer Bestellung repräsentiert. Speichert dem Artikel
 * und die bestellte Anzahl.
 */
public class Position {

    private final Article article;
    private final PositiveInteger amount;

    /**
     * Erzeugt eine neue Instanz einer Position
     * @param article hinzufügender Artikel
     * @param amount Anzahl des bestellten Artikel
     */
    public Position(Article article, PositiveInteger amount) {
        this.article = article;
        this.amount = amount;
    }

    public Article getArticle() {
        return article;
    }

    public PositiveInteger getAmount() {
        return amount;
    }
}
