package gametemplate;

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

    public int getPosition() {
        return position;
    }

    public boolean isOnPosition(int position) {
        return this.position == position;
    }

    public void setBack() {
        position = 0;
    }
}
