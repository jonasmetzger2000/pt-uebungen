# Aufgaben
1. Berechnen Sie das UTF-8 Encoding für das Zeichen '௩' mit Codepoint 0xbe9 hexadezimal /
   3049 dezimal.
    * 1110 0000 1010 1111 1010 1001
2. Welche Methode wird in dem Ausdruck "1" + 5; verwendet, um die Zahl 5 mit der
   Zeichenkette zu konkatenieren?
   * Es wird ein neuer String "15" erzeugt. die 5 als Integer wird mit der Method String.valueOf()
     konvertiert.
3. Zeigen Sie an einem Beispiel, dass Zeichenketten immutable sind. Erläutern Sie das Beispiel.
   * ```
     String string = "abcde";
     string.concat("fghij")
     System.out.println(string)
     ```
4. Zeigen Sie an einem Beispiel, dass Zeichenketten nicht unique sind. Erläutern Sie das
   Beispiel.
   * ```
     new String("test") == new String("test")
     ```
5. Geben Sie drei Beispiele für den Vergleich von Zeichenketten, die die Logik des
   Zeichenketten-Vergleichs veranschaulichen.
   * `"a".compareTo("b");`
   * `"a" == "b";`
   * `"a".equals("b");`
6. Warum ist der lexikografische Vergleich in Java für den Aufbau eines Wörterbuches nicht
   geeignet?
   1. compareTo funktioniert nicht auf allen Objekte, sondern nur auf Objekte die das Comparable Interface implementieren
   2. compareTo gibt einen lexikografischen Unterschied aus. Lange Strings verglichen mit kurzen sind problematisch da
      equals() in diesen Fall direkt false returnt, während 
7. Schreiben sie eine Methode, die eine Zeichenkette normalisiert.
   * ```java
     class Normalize {
        public static String normalize(String string) {
            return string.trim().toLowerCase();
        }
     }
     ```
