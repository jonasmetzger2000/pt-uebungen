package gametemplate;

/**
 *
 * Die Klasse Player repräsentiert die Beteiligten im Spiel.
 * Player merkt sich Position, Name sowie ein Symbol
 * für die Kurzdarstellung ({@link Player#asSymbol(int position)}).
 *
 * Player kann sich auf dem Spielfeld fortbewegen ({@link Player#move(Dice)}),
 * darüber entscheiden, wann Player das Spiel gewonnen hat
 * und sich als <code>String</code> darstellen {@link Player#toString()}.
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
    private int position;
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
        this.position = 0;
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
    public int move(Dice dice){
        int forward = dice.roll();
        if (forward== dice.getMaxPoints()) setBack();
        position+=forward;
        return position;
    }
    /**
     * Prüft, ob sich Player auf der angefragten Position befindet.
     *
     * @param position die Position, die geprüft werden soll.
     * @return <code>true</code>, wenn sich Player auf der Position <code>position</code> befindet, sonst <code>false</code>.
     */
    public boolean isOnPosition(int position) {
        return  this.position == position;
    }

    /**
     * Setzt die Position von Player auf <code>0</code>
     */
    public void setBack(){
        this.position=0;
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
       return isOnTargetPosition();
    }

    private boolean isOnTargetPosition(){
        return this.position >= Game.getInstance().getTargetPosition();
    }


    /**
     * Bereitet den Zustand/die Eigenschaftswerte von Player als Zeichenkette auf.
     * Dazu gehören der Name, das Symbol sowie die aktuelle Position.
     *
     * @return ein <code>String</code>
     */


    @Override
    public String toString() {
        return String.format("%s [%s,%d] ", name,symbol,position);
    }

}
