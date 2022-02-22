package t1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author tzq0301
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        List<String> one = new ArrayList<>();
        one.add("迪丽热巴");
        one.add("宋远桥");
        one.add("苏星河");
        one.add("老子");
        one.add("庄子");
        one.add("孙子");
        one.add("洪七公");
        List<String> two = new ArrayList<>();
        two.add("古力娜扎");
        two.add("张无忌");
        two.add("张三丰");
        two.add("赵丽颖");
        two.add("张二狗");
        two.add("张天爱");
        two.add("张三");

        Stream.concat(
                one.stream()
                        .filter(name -> name.length() == 3)
                        .limit(3),
                two.stream()
                        .filter(name -> name.startsWith("张"))
                        .skip(2))
                .map(Person::new)
                .forEach(System.out::println);
    }
}
