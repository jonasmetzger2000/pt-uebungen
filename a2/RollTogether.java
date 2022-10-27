import java.util.Random;

/**
 * Es gibt 2 Spieler, rundenbasiert würfelt jeder Spieler eine Zahl von 1-6. Erreicht ein Spieler die 50 Punkte so
 * hat er gewonnen. Pro Runde wird der Punktestand ausgegeben. Das Programm beendet sich bis alle Spieler 50 Punkte
 * erreicht haben.
 * @author jonas,kerim
 * @version 0.1
 */
public class RollTogether {

    public static int MAX_POINTS = 50;
    private final Random random = new Random();
    private boolean playerOneDicing = true;
    private int sumPlayerOne = 0;
    private int sumPlayerTwo = 0;

    /**
     * Würfelt für den Spieler und gibt deren Status
     */
    public void rollTogether() {
        int iteration = 0;
        while (sumPlayerOne < MAX_POINTS || sumPlayerTwo < MAX_POINTS) {
            if (sumPlayerOne < MAX_POINTS) {
                sumPlayerOne += dice();
                System.out.printf("%d:: player1:%d player2:%d%n", ++iteration, sumPlayerOne, sumPlayerTwo);
            }
            if (sumPlayerTwo < MAX_POINTS) {
                sumPlayerTwo += dice();
                System.out.printf("%d:: player1:%d player2:%d%n", ++iteration, sumPlayerOne, sumPlayerTwo);
            }

        }
        /*
        	int iteration = 0;
        while (sumPlayerOne < MAX_POINTS || sumPlayerTwo < MAX_POINTS) {
            if (playerOneDicing) {
                if (sumPlayerOne < MAX_POINTS)
                    sumPlayerOne += dice();
            } else {
                if (sumPlayerTwo < MAX_POINTS)
                    sumPlayerTwo += dice();
            }
            System.out.printf("%d:: player1:%d player2:%d%n", ++iteration, sumPlayerOne, sumPlayerTwo);
        }
         */
    }

    /**
     * Würfelt für den Spieler
     * @return gibt eine zufällige Zahl für einen Spieler aus
     */
    public int dice() {
        if (sumPlayerOne >= MAX_POINTS || sumPlayerTwo >= MAX_POINTS)
            return random.nextInt(5)+1;

        playerOneDicing = !playerOneDicing;
        return random.nextInt(5)+1;
    }

    public static void main(String[] args) {
        new RollTogether().rollTogether();
    }
}
