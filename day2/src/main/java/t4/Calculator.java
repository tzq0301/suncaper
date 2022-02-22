package t4;

/**
 * @author tzq0301
 * @version 1.0
 */
public interface Calculator<T, R> {
    R apply(T value1, T value2);
}
