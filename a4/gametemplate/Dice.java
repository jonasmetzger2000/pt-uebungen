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
    private static int defaultPoints = 6;

    /**
     * Initialisiert einen Würfel mit der Standard-Augenzahl.
     */
    public Dice() {
        this(defaultPoints);
        //this.maxPoints=6;
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
        Random rand = new Random();
        return rand.nextInt(maxPoints)+1;
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
