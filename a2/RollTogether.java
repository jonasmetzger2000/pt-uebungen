import java.util.Random;

/**
 * Es gibt 2 Spieler, rundenbasiert würfelt jeder Spieler eine Zahl von 1-6. Erreicht ein Spieler die 50 Punkte so
 * hat er gewonnen. Pro Runde wird der Punktestand ausgegeben. Das Programm beendet sich bis alle Spieler 50 Punkte
 * erreicht haben.
 * @author jonas,kerim
 * @version 0.1
 */
public class RollTogether {

    public static final int MAX_ROUNDS = 50;
    private final Random random = new Random();
    private boolean playerOneDicing = true;
    private int sumPlayerOne = 0;
    private int sumPlayerTwo = 0;

    public void rollTogether() {
        int iteration = 0;
        while (true) {
            if (playerOneDicing)
                if (sumPlayerOne >= MAX_ROUNDS)
                    continue;
                else
                    sumPlayerOne += dice();
            else
                if (sumPlayerTwo >= MAX_ROUNDS)
                    continue;
                else
                    sumPlayerTwo += dice();
            System.out.printf("%d:: player1:%d player2:%d%n", ++iteration, sumPlayerOne, sumPlayerTwo);
            if (sumPlayerOne >= MAX_ROUNDS && sumPlayerTwo >= MAX_ROUNDS)
                break;
        }
    }

    public int dice() {
        if (sumPlayerTwo >= MAX_ROUNDS)
            return random.nextInt(5)+1;
        else if (sumPlayerOne >= MAX_ROUNDS)
            return random.nextInt(5)+1;
        playerOneDicing = !playerOneDicing;
        return random.nextInt(5)+1;
    }

    public static void main(String[] args) {
        new RollTogether().rollTogether();
    }
}
