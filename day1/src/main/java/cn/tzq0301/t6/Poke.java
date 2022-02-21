package cn.tzq0301.t6;

import cn.tzq0301.t5.CharacterCounter;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author tzq0301
 * @version 1.0
 */
public class Poke {
    private static final int POKES_PER_PLAYER = 17;

    public static List<String> getAllPokes() {
        List<String> suits = List.of("♠", "♣", "♥", "♦");
        List<String> numbers = List.of("3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2");

        return Stream.concat(
                suits.stream().flatMap(str1 -> numbers.stream().map(str2 -> str1 + "" + str2)),
                Stream.of("红\uD83C\uDCCF", "黑\uD83C\uDCCF")
        ).collect(Collectors.toList());
    }

    public static void shufflePokes(List<String> pokes) {
        Collections.shuffle(pokes);
    }

    public static List<List<String>> dispatchPokes(List<String> pokes) {
        return List.of(
                pokes.stream().limit(POKES_PER_PLAYER).collect(Collectors.toList()),
                pokes.stream().skip(POKES_PER_PLAYER).limit(POKES_PER_PLAYER).collect(Collectors.toList()),
                pokes.stream().skip(POKES_PER_PLAYER * 2).limit(POKES_PER_PLAYER).collect(Collectors.toList()),
                pokes.stream().skip(POKES_PER_PLAYER * 3).collect(Collectors.toList())
        );
    }

    public static List<String> sortPokes(List<String> pokes) {
        return pokes.stream()
                .sorted((poke1, poke2) -> {
                    if (poke1.endsWith("\uD83C\uDCCF")) {
                        return 1;
                    } else if (poke2.endsWith("\uD83C\uDCCF")) {
                        return -1;
                    }

                    if (poke1.charAt(1) == '2') {
                        return 1;
                    } else if (poke2.charAt(1) == '2') {
                        return -1;
                    }

                    if (Character.isAlphabetic(poke1.charAt(1)) && Character.isAlphabetic(poke2.charAt(1))) {
                        if (poke1.charAt(1) == 'A') {
                            return 1;
                        } else if (poke2.charAt(1) == 'A') {
                            return -1;
                        } else if (poke1.charAt(1) == 'K') {
                            return 1;
                        } else if (poke2.charAt(1) == 'K') {
                            return -1;
                        } else {
                            return poke1.charAt(1) - poke2.charAt(1);
                        }
                    } else if (Character.isAlphabetic(poke1.charAt(1))) {
                        return 1;
                    } else if (Character.isAlphabetic(poke2.charAt(1))) {
                        return -1;
                    }

                    return Integer.parseInt(poke1.substring(1)) - Integer.parseInt(poke2.substring(1));
                })
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> pokes = getAllPokes();
        System.out.println(String.join(", ", pokes));

        System.out.println();

        shufflePokes(pokes);
        System.out.println(String.join(", ", pokes));

        System.out.println();

        List<List<String>> pokesList = dispatchPokes(pokes);
        pokesList.forEach(list -> System.out.println(String.join(", ", list)));

        System.out.println();

        pokesList.stream()
                .map(Poke::sortPokes)
                .forEach(list -> System.out.println(String.join(", ", list)));
    }
}
