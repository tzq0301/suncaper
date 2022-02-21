package cn.tzq0301.t5;

import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @author tzq0301
 * @version 1.0
 */
public class CharacterCounter {
    public static void countAndPrint(String str) {
        TreeMap<Character, Integer> treeMap = new TreeMap<>();

        for (char ch : str.toCharArray()) {
            treeMap.put(ch, treeMap.getOrDefault(ch, 0) + 1);
        }

        System.out.println(treeMap.entrySet().stream()
                .map(entry -> entry.getKey() + ":" + entry.getValue())
                .collect(Collectors.joining(", ")));
    }
}
