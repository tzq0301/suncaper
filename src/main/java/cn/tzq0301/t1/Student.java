package cn.tzq0301.t1;

/**
 * @author tzq0301
 * @version 1.0
 */
public record Student(String name, String code) {
    @Override
    public String toString() {
        return "学生" + name + "学号为" + code;
    }
}
