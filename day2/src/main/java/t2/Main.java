package t2;

import java.time.LocalDateTime;

/**
 * @author tzq0301
 * @version 1.0
 */
public class Main {
    static void showLongTime(CurrentTimePrinter timePrinter) {
        timePrinter.printCurrentTime();
    }

    public static void main(String[] args) {
        showLongTime(() -> System.out.println(LocalDateTime.now()));
    }
}
