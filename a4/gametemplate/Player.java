package gametemplate;

import java.util.Random;

/**
 *
 * Die Klasse Player repräsentiert die Mitspieler im Spiel.
 * Jeder Spieler hat zwei {@link GamePiece}s
 *
 * Jede Runde wird zufällig ein {@link GamePiece} ausgelost und
 * dieser 1-6 Schritte nach vorne bewegt
 *
 * Die Klasse <code>Player</code> bietet eine Reihe öffentlicher
 * Konstanten für die symbolische Darstellung an.
 */
public class Player {
    /**
     * Symbol für ein rotes Kreuz
     */
    public static final String RED_CLUB = "\u001B[31m\u2663\u001B[m";
    /**
     * Symbol für ein blaues Pik
     */
    public static final String BLUE_SPADE = "\u001B[34m\u2660\u001B[m";

    private String name;
    private String symbol;
    private GamePiece one;
    private GamePiece two;
    private int targetPosition;
    /**
     * Der Konstruktor von ({@link Player}).
     * Initializisiert den Namen des Spielers, das benutzte Symbol, die zu erreichende Position und
     * 2 Spielsteine ({@link GamePiece}). Zur
     *
     * @param name Name von Player als String
     * @param symbol symbolische Repräsentation des Player als <code>String</code>
     */
    public Player(String name, String symbol){
        this.name = name;
        this.symbol = symbol;
        this.targetPosition = Game.getInstance().getTargetPosition();
        one = new GamePiece();
        two = new GamePiece();
    }

     /**
     * Mit dieser Methode bewegt sich ein Spielsteins des Player (50% Chance) über das Spielfeld, indem
     * die Anzahl der Felder, die weiter vorgerückt werden dürfen, gewürfelt werden.
     * Dazu wird ein Würfel ({@link Dice}) benutzt, der der Methode übergeben wird
     *
     * Wurde die maximale Punktzahl des Würfels gewürfelt, dann
     * muss Player zurück auf die Startposition ({@link Player#setBack()}). Sonst
     * wird die <code>position</code> um die gewürfelte Anzahl erhöht.
      *
     * @param dice der Spielwürfel, um die Anzahl der vorzurückenden Positionen zu bestimmen
     * @return new position of player
      */
    public GamePiece move(Dice dice){
        GamePiece chosen;
        if (one.getPosition() >= targetPosition) chosen = two;
        else if (two.getPosition() >= targetPosition) chosen = one;
        else chosen = dice.choose(one, two);
        chosen.move(dice.roll());
        return chosen;
    }
    /**
     * Prüft, ob einer der beiden Spielsteine des Spielers auf einer bestimmten Position befindet
     *
     * @param position die Position, die geprüft werden soll.
     * @return <code>true</code>, wenn sich ein GamePiece des Player's auf der Position <code>position</code> befindet, sonst <code>false</code>.
     */
    public boolean isOnPosition(int position) {
        return one.isOnPosition(position) || two.isOnPosition(position);
    }

    /**
     * Setzt die Position von Player auf <code>0</code>
     */
    public void setBack(int newPos){
        if (one.isOnPosition(newPos)) one.setBack();
        if (two.isOnPosition(newPos)) two.setBack();
    }

    /**
     * Die Methode liefert eine symbolische Darstellung des Spielsteins.
     * @return ein <code>String</code>
     */
    public String asSymbol() {
        return symbol;
    }


    /**
     * Gibt Auskunft darüber, ob Player das Spiel gewonnen hat.
     * Das Spiel ist gewonnen, wenn beide Spielsteine >= {@link Player#targetPosition} liegt.
     * @return <code>true</code>, wenn die Position >= der Zielposition des Spiels ist,
     * sonst <code>false</code>.
     */
    public boolean hasWon() {
        return one.getPosition() >= targetPosition && two.getPosition() >= targetPosition;
    }

    /**
     * Bereitet den Zustand/die Eigenschaftswerte von den 2 Spielsteinen des Players als Zeichenkette auf.
     * Dazu gehören der Name, das Symbol sowie die aktuelle Position.
     *
     * @return ein <code>String</code>
     */
    @Override
    public String toString() {
        return String.format("%s [(%s,%d), (%s, %d)]", name,symbol, one.getPosition(), symbol, two.getPosition());
    }

}
