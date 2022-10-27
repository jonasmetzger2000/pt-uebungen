package conditionals;

/**
 * Berechnet den lexikalischen Tag mit einen numerischen Tag
 * @author jonas,kerim
 * @version 0.1
 */
public class JourDeLaSemaine {

    /**
     * Berechnet den Tag mittels eines Parameters
     * @param args <strong>[0]:</strong> Integer, numerische Zahl aus der der lexikalische Tag berechnet wird<br>
     * Montag -> Понедельник<br>
     * Dienstag -> Вторник<br>
     * Mittwoch -> Среда<br>
     * Donnerstag -> Четверг<br>
     * Freitag -> Пятница<br>
     * Samstag -> Суббота<br>
     * Sonntag -> Воскресенье<br>
     * falsche Eingabe -> Неправильный ввод<br>
     */
    public static void main(String... args) {
        int numericDay = Integer.parseInt(args[0]);
        if (numericDay <= 0) { System.err.println("Неправильный ввод"); System.exit(1); }

        int dayOfWeek = numericDay % 7;

        System.out.println(switch (dayOfWeek) {
            case 0 -> "Sonntag (Понедельник)";
            case 1 -> "Montag (Вторник)";
            case 2 -> "Dienstag (Среда)";
            case 3 -> "Mittwoch (Четверг)";
            case 4 -> "Donnerstag (Пятница)";
            case 5 -> "Freitag (Суббота)";
            case 6 -> "Samstag (Воскресенье)";
            default -> "Invalid (Неправильный ввод)";
        });
    }
}
