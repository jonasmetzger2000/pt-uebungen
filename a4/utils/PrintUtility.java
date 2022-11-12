package utils;

public class PrintUtility {

    /*
     * Die Methode druckt einen Separator mit einer fest vorgegeben Länge,
     * einem frei wählbaren Präfix (einen String) und einem Füllzeichen.
     *
     * Drucken mit der Methode sollte z.B. folgende Ausgaben erzeugen:
     * 7-1-9 ________________________________________________________________________________
     * "Bei allem Respekt . hören Sie damit auf ."
     * with no spaces before punctuation characters is:
     * "Bei allem Respekt. hören Sie damit auf."
     * 7-1-7 to 7-1-9 Es gibt noch was zu tun :-) ____________________________________________
     * original:       bei    allem   Respekt  .    hören Sie   damit   auf  .
     * normalized:Bei allem Respekt. hören Sie damit auf.
     *
     * Dabei sind 7-1-9 und 7-1-7 to 7-1-9 Präfixe und  „_“ das Füllzeichen.
     *
     * @param prefix Zeichenkette am Anfang des Separators
     * @param filler Füllzeichen für die freien Plätze
     * @param length Gesamtlänge des zu druckenden Separators
     */
    public static void printSeparator(String prefix,char filler, int length){
        System.out.printf("%s%s%n",prefix,
                String.valueOf(filler).repeat(Math.max(1,length-prefix.length())));
    }

    public static void printSeparator(String prefix){
        printSeparator(prefix,'-', 90);
    }
}