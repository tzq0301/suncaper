package cn.tzq0301.t4.v1;

/**
 * @author tzq0301
 * @version 1.0
 */
public record Student(String name, int age, float score) implements Comparable<Student> {

    @Override
    public int compareTo(Student that) {
        if (this.score != that.score) {
            return this.score < that.score ? 1 : -1;
        }

        if (this.age != that.age) {
            return this.age > that.age ? 1 : -1;
        }

        return 0;
    }
}
