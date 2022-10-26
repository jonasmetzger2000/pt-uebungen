import java.util.*;

/**
 * Es gibt 2 Spieler, rundenbasiert würfelt jeder Spieler eine Zahl von 1-6. Erreicht der Spieler die 50 Punkte so
 * hat er gewonnen. Pro Runde wird der Punktestand ausgegeben. Das Programm beendet sich bis alle Spieler 50 Punkte
 * erreicht haben.
 * @author jonas
 * @version 0.1
 */
public class RollTogetherV2 {

    public static void main(String[] args) {
        new Game(2).start();
    }
}

/**
 * Das Würfelspiel.
 */
class Game {
    private Queue<Player> players = new LinkedList<>();
    private int roundNumber = 1;

    /**
     * Erzeugt ein neues Spiel
     * @param playerCount Integer, anzahl der zu erstellenden Spieler
     */
    public Game(int playerCount) {
        Random random = new Random();
        for (int i = 0; i < playerCount; i++) {
            Player player = new Player(50, i+1, random);
            players.add(player);
        }
    }

    /**
     * Startet ein neues Spiel
     */
    public void start() {
        while (true) {
            if (isGameFinished()) break;
            Player nextPlayer = players.poll();
            if (!nextPlayer.isPlayerFinished()) nextPlayer.dice();
            players.add(nextPlayer);
            printScores();
            roundNumber++;
        }
    }

    /**
     * Überprüft ob alle Bedigungen erfüllt sind, sprich ob das Spiel beendet werden kann oder nicht
     * @return boolean, true wenn das Spiel alle Bedingungen erfüllt hat
     */
    private boolean isGameFinished() {
        return players.stream().allMatch(Player::isPlayerFinished);
    }

    /**
     * Zeichnet den Punktestand aller Spieler auf die Konsole
     */
    private void printScores() {
        System.out.printf("%03d:: %s%n", roundNumber, players.stream().sorted(Player::compare).map(Player::getScoringText).reduce(String::concat).get());
    }
}

/**
 * Das Spielerobjekt. Ein {@link Game} kann mehrere Spieler haben.
 */
class Player {
    private int id;
    private int points;
    private int maxPoints;
    private Random random;

    /**
     * Erzeugt ein Spieler
     * @param maxPoints, Integer, maximale Anzahl von Punkten die vom Spieler erreicht werden müssen
     * @param id, Integer, fortlaufende Nummerierung des Spielers. Zu Identifikationzwecken
     * @param random, Random Instanz zum Würfeln
     */
    public Player(int maxPoints, int id,  Random random) {
        this.id = id;
        this.random = random;
        this.maxPoints = maxPoints;
        points = 0;
    }

    /**
     * Überprüft ob der Spieler {@link Player#maxPoints} erreicht hat
     * @return true:  {@link Player#points} >={@link Player#maxPoints}
     */
    public boolean isPlayerFinished() {
        return points >= maxPoints;
    }

    /**
     * Würfelt für den gegebenen Spieler und inkrementiert dessen Punktestand
     */
    public void dice() {
        points += random.nextInt(5)+1;
    }

    /**
     * Erzeugt einen Punktestand Status Text für den Spieler
     * @return String e.g: player<strong>n</strong>:<strong>punktestand</strong>
     */
    public String getScoringText() {
        return String.format("player%02d:%03d ", id, points);
    }

    /**
     * Vergleicht die {@link Player} nach dessen Id und gibt sortiert die Spieler aufsteigend {@link Player#id}
     * @param player1 Spieler 1
     * @param player2 Spieler 2
     * @return 1 wenn Spieler 1 eine größere Id hat.
     */
    public static int compare(Player player1, Player player2) {
        return player1.id > player2.id ? 1 : -1;
    }
}
