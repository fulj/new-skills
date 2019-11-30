package com.fulj.java8.forEach;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @author fulj
 * @date 2019Äê11ÔÂ30ÈÕ 4:10 PM
 */

public class ForEachTest {

    @Test
    @DisplayName("java8 foreach over stream elements")
    void overStream(){
        ArrayList<Integer> numberList = new ArrayList<>(Arrays.asList(1,2,3,4,5));

        Consumer<Integer> action = System.out::println;

        numberList.stream().filter(n -> n%2  == 0).forEach( action );
    }

    @Test
    @DisplayName("Java 8 forEach list elements")
    void overList(){
        ArrayList<Integer> numberList = new ArrayList<>(Arrays.asList(1,2,3,4,5));

        Consumer<Integer> action = System.out::println;

        numberList.forEach(action);
    }

    @Test
    @DisplayName("Java 8 forEach map entries")
    void overMap(){
        HashMap<String, Integer> map = new HashMap<>();

        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        //1. Map entries
        Consumer<Map.Entry<String, Integer>> action = System.out::println;

        map.entrySet().forEach(action);

        //2. Map keys
        Consumer<String> actionOnKeys = System.out::println;

        map.keySet().forEach(actionOnKeys);

        //3. Map values
        Consumer<Integer> actionOnValues = System.out::println;

        map.values().forEach(actionOnValues);
    }

    @Test
    @DisplayName("custom action")
    void customAction() {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        Consumer<Map.Entry<String, Integer>> action = entry ->
        {
            System.out.println("Key is : " + entry.getKey());
            System.out.println("Value is : " + entry.getValue());
        };

        map.entrySet().forEach(action);
    }


}
