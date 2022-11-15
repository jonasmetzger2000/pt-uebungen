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
    private Random random = new Random();
    /**
     * Der Konstruktor von ({@link Player}). Initialisiert den Namen, das
     * Symbol (für die Spielfelddarstellung) und die initiale Position.
     *
     * @param name Name von Player als String
     * @param symbol symbolische Repräsentation des Player als <code>String</code>
     */
    public Player(String name,String symbol){
        this.name = name;
        this.symbol =symbol;
        one = new GamePiece();
        two = new GamePiece();
    }

     /**
     * Mit dieser Methode bewegt sich ein Player über das Spielfeld, indem
     * die Anzahl der Felder, die weiter vorgerückt werden dürfen, gewürfelt werden.
     * Dazu wird ein Würfel ({@link Dice}) benutzt, der der Methode übergeben wird,
     *
     * Wurde die maximale Punktzahl des Würfels gewürfelt, dann
     * muss Player zurück auf die Startposition ({@link Player#setBack()}). Sonst
     * wird die <code>position</code> um die gewürfelte Anzahl erhöht.
      *
     * @param dice der Spielwürfel, um die Anzahl der vorzurückenden Positionen zu bestimmen
     * @return new position of player
      */
    public GamePiece move(Dice dice){
        int targetPosition = Game.getInstance().getTargetPosition();
        GamePiece chosen;
        if (one.getPosition() >= Game.getInstance().getTargetPosition()) chosen = two;
        else if (one.getPosition() >= Game.getInstance().getTargetPosition()) chosen = one;
        else chosen = dice.choose(one, two);
        chosen.move(dice.roll());
        return chosen;
    }
    /**
     * Prüft, ob sich Spielsteine auf einen Gamepieces des Spielers befinden
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
     * Die Methode liefert eine symbolische Darstellung von Player.
     * @return ein <code>String</code>
     */
    public String asSymbol() {
        return symbol;
    }


    /**
     * Gibt Auskunft darüber, ob Player das Spiel gewonnen hat.
     * Das Spiel ist gewonnen, wenn die eigene Position >=
     * der Zielposition des Spiels ist ({@link Game#getTargetPosition()}).
     * @return <code>true</code>, wenn die Position >= der Zielposition des Spiels ist,
     * sonst <code>false</code>.
     */
    public boolean hasWon() {
       return bothPiecesAreInTheGoal();
    }

    private boolean bothPiecesAreInTheGoal(){
        int goal = Game.getInstance().getTargetPosition();
        return one.getPosition() >= goal && two.getPosition() >= goal;
    }


    /**
     * Bereitet den Zustand/die Eigenschaftswerte von Player als Zeichenkette auf.
     * Dazu gehören der Name, das Symbol sowie die aktuelle Position.
     *
     * @return ein <code>String</code>
     */
    @Override
    public String toString() {
        return String.format("%s [(%s,%d), (%s, %d)]", name,symbol, one.getPosition(), symbol, two.getPosition());
    }

}
