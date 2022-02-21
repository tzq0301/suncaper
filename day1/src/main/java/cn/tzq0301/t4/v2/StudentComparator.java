package cn.tzq0301.t4.v2;

import java.util.Comparator;

/**
 * @author tzq0301
 * @version 1.0
 */
public class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.score() != o2.score()) {
            return o1.score() < o2.score() ? 1 : -1;
        }

        if (o1.age() != o2.age()) {
            return o1.age() > o2.age() ? 1 : -1;
        }

        return 0;
    }
}
