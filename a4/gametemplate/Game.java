package gametemplate;

/**
 * Die Klasse steuert das Spiel "Roll-Race-Setback", in der zwei Player um die Wette würfeln.
 * <p>
 * Die Regeln lauten wie folgt:
 * <ol>
 * <li>Jeder Spieler bekommt zwei Spielsteine. Ein Spielstein wird durch die Klasse({@link GamePiece}) representiert</li>
 * <li>Es wird ein beliebiger Stein gezogen (50% Chance der Auswahl)</li>
 * <li>Ist der gewählte Stein bereits im Ziel, dann wird mit dem anderen gezogen.</li>
 * <li>Steine des Player können sich nicht gegenseitig herauswerfen.</li>
 * <li>Kein Zurücksetzen beim Würfeln der maximalen Augenzahl.</li>
 * <li>Das Ergebnis der Methode ist die neue Position des gezogenen Steins.</li>
 * <li>Wenn einer der Steine des Gegners sich auf der Position des letzten gezogenen Steins befindet, dann muss dieser
 * Stein zurückgesetzt werden.</li>
 * <li>Wenn einer der Steine auf dem aktuellen Feld steht, dann wird das Symbol des Steins gedruckt.</li>
 * </ol>
 * <p>
 * Die <em> targetPosition </em> kann dem Spiel bei der Erzeugung übergeben werden.
 * <p>
 * Das Spiel existiert nur mit einer einzigen Instanz.
 */

public class Game {

    public static final String EMPTY_FIELD = "_";
    /**
     * Die Referenz auf die einzige Instanz des Spiels.
     */
       private static Game instance;
    /**
     * Der Default für die Zielposition des Spiels.
     */
    private static final int defaultTargetPosition = 50;

      private final int targetPosition;

      private Game(int targetPosition){
          this.targetPosition=targetPosition;
      }

    /**
     * Die statische Methode erzeugt die einzige Instanz des Spiels mit dem Default für
     * die Spielposition ({@link Game#defaultTargetPosition}).
     *
     * @return die einzige {@link Game}-Instanz
     */
    public static Game getInstance() {
        return getInstance(defaultTargetPosition);
    }

    /**
     * Die statische Methode erzeugt die einzige Instanz des Spiels mit einem Wert von <code>targetPosition</code> für
     * die Spielposition.
     *
     * @param targetPosition die Zielposition
     * @return die einzige {@link Game}-Instanz
     */
    public static Game getInstance(int targetPosition) {
        if (instance == null) {
            instance = new Game(targetPosition);
        }
        return instance;
    }


    /**
     * Die {@link Game}-Loop: Erzeugt zwei Player-Objekte sowie den Spielwürfel. Ein Spieler besitzt 2
     * Spielsteine. Immer ein Spieler ist am Zug ({@link Player#move(Dice)}).
     * Spielsteine des Gegner's werden zurückgesetz sofern sich der aktuelle Spieler
     * auf den Feld des Gegner's befindet.
     * <p>
     * Wenn einer der Player gewonnen hat, wird das Spiel beendet.
     * <p>
     * Vor jedem Spielzug und am Ende des Spiels wird das Spielfeld mit den Positionen der Spielsteine der Spieler
     * ausgegeben. Befinden sich zwei Spielsteine des gleichen Spielers auf einen Feld, so werden diese "hintereinander"
     * stehen und daher wird nur ein Spielstein ausgegeben.
     */
    public void loop() {
        Player actual = new Player("me", Player.BLUE_SPADE);
        Player opponent = new Player( "you", Player.RED_CLUB);
        Dice dice = new Dice();

        while(!actual.hasWon() && !opponent.hasWon()) {

            GamePiece gamePiece = actual.move(dice);
            if (opponent.isOnPosition(gamePiece.getPosition())) {
                opponent.setBack(gamePiece.getPosition());
            }
            printGameState(actual,opponent);
            // Rollentausch actual -> opponent opponent -> actual
            Player temp = actual;
            actual = opponent;
            opponent = temp;
        }
    }

    /**
     * Druckt das Spielfeld in einer Zeile. Für jedes freie Feld wird ein "_", für jedes besetzte das
     * Symbol eines Players gedruckt. Mittels der Methode Player#isOnPosition(int) wird geprüft,
     * ob ein Player die Position besetzt. Mittels der Methode {@link Player#asSymbol(int position)} wird die symbolische
     * Darstellung eines Players abgefragt.
     * <p>
     * An das Ende jeder Zeile wird der Status beider Player gedruckt, sodass sich die belegten Positionen direkt
     * ablesen lassen.
     *
     * @param player1 einer der beiden Player
     * @param player2 der zweite der beiden Player
     */
    private void printGameState(Player player1, Player player2) {
        String format = " [ %s ] ";
        for (int pos =0; pos < targetPosition; pos++) {
            if (player1.isOnPosition(pos)) {
                System.out.printf(format,player1.asSymbol());
            } else if (player2.isOnPosition(pos)) {
                System.out.printf(format,player2.asSymbol());
            } else {
                System.out.printf(format,"_");
            }
        }
        System.out.printf("%s || %s%n", player1 , player2);
    }

    public int getTargetPosition() {
        return targetPosition;
    }
}
