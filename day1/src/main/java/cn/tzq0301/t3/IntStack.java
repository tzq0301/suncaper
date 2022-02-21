package cn.tzq0301.t3;

/**
 * @author tzq0301
 * @version 1.0
 */
public class IntStack {
    private int[] array;

    private int currentIndex;

    private int size;

    private int capacity;

    private boolean isEmpty;

    private static final int DEFAULT_CAPACITY = 16;

    private static final int MAX_CAPACITY = Integer.MAX_VALUE;

    private static final double INCREASE_FACTORY = 2.0D;

    public IntStack() {
        this.array = new int[DEFAULT_CAPACITY];
        this.size = 0;
        this.capacity = DEFAULT_CAPACITY;
        this.isEmpty = true;
        this.currentIndex = -1;
    }

    public IntStack(int capacity) {
        if (capacity == 0) {
            this.array = new int[DEFAULT_CAPACITY];
            this.capacity = DEFAULT_CAPACITY;
        } else {
            this.array = new int[capacity];
            this.capacity = capacity;
        }
        this.size = 0;
        this.isEmpty = true;
        this.currentIndex = -1;
    }

    public boolean push(int element) {
        if (currentIndex + 1 == capacity) {
            if (capacity == MAX_CAPACITY) {
//                throw new RuntimeException("Reach MAX capacity");
                return false;
            }

            capacity = capacity * INCREASE_FACTORY > MAX_CAPACITY ? MAX_CAPACITY : (int) (capacity * INCREASE_FACTORY);
            int[] newArray = new int[capacity];
            System.arraycopy(array, 0, newArray, 0, size);
            this.array = newArray;
        }

        size++;
        isEmpty = false;
        currentIndex++;
        array[currentIndex] = element;

        return true;
    }

    public int pop() {
        int value = top();

        size--;
        if (size == 0) {
            isEmpty = true;
        }
        currentIndex--;

        return value;
    }

    public int top() {
        if (currentIndex < 0) {
            throw new RuntimeException("Empty Stack");
        }

        return array[currentIndex];
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }
}
