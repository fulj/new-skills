package com.fulj.java8.stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.lang.annotation.Retention;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author fulj
 * @date 2019Äê11ÔÂ30ÈÕ 8:31 PM
 * A Collection is an in-memory data structure
 * A stream is a conceptually fixed data structure, in which elements are computed on demand
 * Stream are created on a source,e.g a java.until.Collection like lists or sets(map are not supported).
 * characteristics:
 * Not a data structure
 * Designed for lambdas
 * Do not support indeced access
 * Can easily be outputted as arrays or lists
 * Lazy access supported
 * Parallelizable
 */
public class CreateStreamTest {

    @Test
    void createStream(){
        //1. Stream.of(val1, val2, val3...)
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5, 6, 7);
        stream1.forEach(System.out::println);

        //2.  List.stream()
        List<Integer> list = new ArrayList<Integer>();

        for(int i = 1; i< 10; i++){
            list.add(i);
        }
        Stream<Integer> stream2 = list.stream();
        stream2.forEach(p -> System.out.println(p));
        //3. Stream.generate() or Stream.iterate()
//        Stream<Date> stream3 = Stream.generate(() -> {
//            return new Date();});
//        stream3.forEach(p -> System.out.println(p));

        //4.
        IntStream stream4 = "12345_abcdefg".chars();
        stream4.forEach(p -> System.out.println(p));

        //OR

        Stream<String> stream5 = Stream.of("A$B$C".split("\\$"));
        stream5.forEach(p -> System.out.println(p));
    }

    @Test
    void convertStreamToCollection(){
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 1; i< 10; i++){
            list.add(i);
        }
        Stream<Integer> stream = list.stream();
        List<Integer> evenNumbersList = stream.filter(i -> i % 2 == 0).collect(Collectors.toList());
        System.out.println(evenNumbersList);
    }

    @Test
    void convertStreamToArray() {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 1; i< 10; i++){
            list.add(i);
        }
        Stream<Integer> stream = list.stream();
        Integer[] evenNumbersArr = stream.filter(i -> i % 2 == 0).toArray(Integer[]::new);
        System.out.println(evenNumbersArr);
    }
}
