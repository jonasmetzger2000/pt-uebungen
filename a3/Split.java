import java.io.FilterOutputStream;
import java.util.regex.Pattern;

/**
 * Akzeptiert einen gegebenen Dateinamen inklusive des Dateityp
 * Das Programm zerlegt den Dateinamen in Endung und Dateiname
 * udn gibt diesen getrennt aus
 * @author kerim, jonas
 */
public class Split {

    /**
     * Nimmt einen Dateinamen inklusive des Dateityps und spaltet
     * den Namen und die Endung und gibt diesen auf die Konsole
     * aus. Der Dateiname wird als Argument beim Start als
     * Argument gegeben.
     * @param args <br>
     *             <strong>args[0]:</strong> string, der Dateiname
     */
    public static void main(String[] args) {
        String[] fileName = args[0].split("\\.");

        String name = fileName[0];
        String type = fileName[1];

        System.out.printf("Die Datei heißt '%s' und die Dateiendung lautet '%s'", name, type);

    }
}
