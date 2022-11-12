package gametemplate;

/**
 * Die Klasse steuert das Spiel "Roll-Race-Setback", in der zwei Player um die Wette würfeln.
 * <p>
 * Die Regeln lauten wie folgt:
 * <ol>
 * <li> Würfelt eine Person die maximale Augenzahl des verwendeten Würfels, dann muss sie zurück zur Startposition.</li>
 * <li> Wenn eine Person mit einem Wurf eine Position erreicht, die bereits belegt ist,
 *      dann muss die Person, die die Position belegt, zurück zur Startposition. </li>
 * <li> Die erste Person, die auf Position <em> targetPosition </em> landet, hat gewonnen.</li>
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
     * Die {@link Game}-Loop: Erzeugt zwei Player-Objekte sowie den Spielwürfel. Immer ein Spieler ist am Zug
     * ({@link Player#move(Dice)}). Der andere, der Opponent, wird zurückgesetzt, wenn nach einem Zug sich
     * beide Player auf dem gleichen Spielfeld befinden.
     * <p>
     * Wenn einer der Player gewonnen hat, wird das Spiel beendet.
     * <p>
     * Vor jedem Spielzug und am Ende des Spiels wird das Spielfeld mit den Positionen der {@link Player} gedruckt.
     */
    public void loop() {
        Player actual = new Player("me", Player.BLUE_SPADE);
        Player opponent = new Player( "you", Player.RED_CLUB);
        Dice dice = new Dice();

        while(!actual.hasWon() && !opponent.hasWon()) {

            int newPosition = actual.move(dice);
            if (opponent.isOnPosition(newPosition)) {
                opponent.setBack();
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
        String format = "%2s";
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
