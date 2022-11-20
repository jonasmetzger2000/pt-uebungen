package gametemplate;

/**
 * Repräsentiert ein Spielstein eines ({@link Player}). Der Spielstein kann sich nach vorne bewegen.
 * und gibt daraufhin seine Position preis. Die Position eines Spielstein kann auch zurückgesetzt werden
 */
public class GamePiece {

    private int position = 0;

    /**
     * Mit dieser Methode bewegt sich ein Gamepieces eines Spielers über das Spielfeld, indem
     * die Anzahl der Felder, die weiter vorgerückt werden dürfen, gewürfelt werden.
     * Dazu wird ein Würfel ({@link Dice}) benutzt, der der Methode übergeben wird.
     * Die Position wird um der gewürfelten Zahl erhöht.
     *
     * @param step Anzahl an Schritten die gewürfelt werden und um die das Gamepiece nach "vorne" geht.
     * @return new position of gamepiece
     */
    public int move(int step){
        position+=step;
        return position;
    }

    /**
     * Gibt die aktuelle Position des Spielsteins zurück
     * @return die aktuelle Position des Spielsteins
     */
    public int getPosition() {
        return position;
    }

    /**
     * Überprüft ob der Spielstein auf einer gegebenen Position liegt.
     * @param position abzufragende Position des Spielsteins
     * @return return <i>true</i> wenn Spielstein auf Position, ansonsten <i>false</i>
     */
    public boolean isOnPosition(int position) {
        return this.position == position;
    }

    /**
     * Setzt die Position des Spielsteins wieder zurück auf 0
     */
    public void setBack() {
        position = 0;
    }
}
