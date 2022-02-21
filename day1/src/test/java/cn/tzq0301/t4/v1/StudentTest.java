package cn.tzq0301.t4.v1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author tzq0301
 * @version 1.0
 */
class StudentTest {

    @Test
    void test() {
        List<Student> students = List.of(
                new Student("liusan", 20, 90.0F),
                new Student("lisi", 22, 90.0F),
                new Student("wangwu", 20, 99.0F),
                new Student("sunliu", 22, 100.0F));

        List<String> studentNames = students.stream().sorted().map(Student::name).toList();

        assertAll(
                () -> assertEquals("sunliu", studentNames.get(0)),
                () -> assertEquals("wangwu", studentNames.get(1)),
                () -> assertEquals("liusan", studentNames.get(2)),
                () -> assertEquals("lisi", studentNames.get(3)));
    }

}