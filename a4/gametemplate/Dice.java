package gametemplate;

import java.util.Random;

/**
 * Diese Klasse repräsentiert einen Spielwürfel.
 * Ein Spielwürfel liefert bei jedem Wurf ({@link Dice#roll}) eine
 * zufällige Zahl im Intervall <code>[1,maxPoints]</code>. <code>maxPoints</code>
 * kann dem Würfel beim Erzeugen übergeben werden.
 * Ansonsten wird ein Default verwendet.
 * <p>
 * Der Würfel ist <b>nicht deterministisch</b>.
 */
public class Dice {

    /**
     * Der Default für die Augen des Würfels
     */
    private int maxPoints;
    private Random random;

    private static int defaultPoints = 6;

    /**
     * Initialisiert einen Würfel mit der Standard-Augenzahl.
     */
    public Dice() {
        this(defaultPoints);
        //this.maxPoints=6;
        random = new Random();
    }

    /**
     * Initialisiert einen Würfel mit der Augenzahl <code>maxPoints</code>
     *
     * @param maxPoints die maximale Augenzahl des Würfels
     */
    public Dice(int maxPoints) {
        this.maxPoints = maxPoints;
    }


    /**
     * Würfelt eine Zahl im Intervall <code>[1,maxPoints]</code>.
     *
     * @return eine Zahl des Intervalls.
     */
    public int roll() {
        return random.nextInt(maxPoints)+1;
    }

    /**
     * Würfelt einen zufälligen GamePiece, 50% GamePiece "one" oder 50% GamePiece "two".
     * @param one GamePiece nummer eins, 50% Wahrscheinlichkeit das dieser zurückgegeben wird
     * @param two GamePiece nummer zwei, 50% Wahrscheinlichkeit das dieser zurückgegeben wird
     * @return Gibt entweder Gamepiece one oder Gamepiece two zurück
     */
    public GamePiece choose(GamePiece one, GamePiece two) {
        if (random.nextInt(2) == 0) return one;
        else return two;
    }


    /**
     * Liefert die maximale Augenzahl des Würfels
     *
     * @return die maximale Augenzahl des Würfels
     */
    public int getMaxPoints() {
        return maxPoints;
    }

}
