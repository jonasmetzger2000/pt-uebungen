/**
 * Nimmt einen gegebenen Text und gibt diesen in
 * umgekehrter Reihenfolge aus.
 * @author kerim, jonas
 */
public class StringReverse {

    /**
     * Nimmt den ersten String von den Programm Argumenten und invertiert diesen.
     * Nachfolgend wird dieser im Terminal ausgegeben.
     * @param args <br>
     *             <strong>args[0]:</strong> string, der invertiert werden soll
     */
    public static void main(String[] args) {
        String textToReverse = args[0];
//        String textToReverse = "Alles ist OK";

        StringBuilder invertedString = new StringBuilder();
        for (int i = textToReverse.length()-1; i >= 0; i--) {
            invertedString.append(textToReverse.charAt(i));
        }
        System.out.println(invertedString);
    }
}
