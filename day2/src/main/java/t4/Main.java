package t4;

/**
 * @author tzq0301
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(value(Long::sum, 1L, 2L));
        System.out.println(value((Long value1, Long value2) -> value1 * value2, 1L, 2L));
    }

    public static <T, R> R value(Calculator<T, R> calculator, T value1, T value2) {
        return calculator.apply(value1, value2);
    }
}
