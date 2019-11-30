package com.fulj.java8.stream;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author fulj
 * @date 2019Äê11ÔÂ30ÈÕ 9:04 PM
 */
public class CoreOperations {
    private static List<String> memberNames = new ArrayList<>();
    static {
        memberNames.add("Amitabh");
        memberNames.add("Shekhar");
        memberNames.add("Aman");
        memberNames.add("Rahul");
        memberNames.add("Shahrukh");
        memberNames.add("Salman");
        memberNames.add("Yana");
        memberNames.add("Lokesh");
    }

    @Test
    void filterTest() {
        memberNames.stream().filter(s -> s.startsWith("A"))
                .forEach(System.out::println);

    }

    @Test
    void mapTest() {
        memberNames.stream().filter(s -> s.startsWith("A")).
                map(String::toUpperCase).
                forEach(System.out::println);

    }

    @Test
    void sortTest() {
        memberNames.stream().sorted()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    //terminal operations


    /**
     * forEach
     */
    @Test
    void terminalOperationsTest() {
        //Stream.forEach()
        memberNames.forEach(System.out::println);

        //Stream.collect()
        List<String> memberNamesInUppercase = memberNames.stream().sorted()
                .map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(memberNamesInUppercase);

        //Stream.match()
        boolean matchedResult = memberNames.stream()
                .anyMatch((s) -> s.startsWith("A"));

        System.out.println(matchedResult);

        matchedResult = memberNames.stream()
                .allMatch((s) -> s.startsWith("A"));

        System.out.println(matchedResult);

        matchedResult = memberNames.stream()
                .noneMatch((s) -> s.startsWith("A"));

        System.out.println(matchedResult);

        //Stream.count()
        long totalMatched = memberNames.stream().filter(s -> s.startsWith("A"))
                .count();
        System.out.println(totalMatched);

        Optional<String> reduced = memberNames.stream().reduce((s1, s2) -> s1 + "#" +s2);
        reduced.ifPresent(System.out::println);

    }

}
