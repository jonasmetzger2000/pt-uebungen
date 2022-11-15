package gametemplate;

/**
 * Das Programm, das das Spiel erzeugt und startet.
 */
public class GameStarter {

    /**
     * Die Methode erzeugt ein {@link Game}-Objekt und startet die Game-Loop ({@link Game#loop()}).
     *
     * @param args wird nicht verwendet
     */
    public static void main(String[] args) {
        Game game = Game.getInstance(25);
        for (int i = 0; i < 25; i++) {
            System.out.printf(" [%3d] ", i+1);
        }
        System.out.printf("%n");
        game.loop();
    }
}
