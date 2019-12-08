package com.fulj.java8.compute;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fulj
 */
public class Compute {
    final Logger logger = LoggerFactory.getLogger(Compute.class);

    public static Map<String, Integer> getElementCounts(List<String> list) {
        Map<String, Integer> countsMap = new HashMap<>();
        list.forEach(str -> countsMap.compute(str, (k, v) -> v == null ? 1 : v + 1));
        return countsMap;
    }
    @Test
    void computeCount() {
        List<String> list = Arrays.asList("a", "b", "b", "c", "c", "c", "d", "d", "d", "f", "f", "g");
        Map<String, Integer> counts = getElementCounts(list);
        logger.info("compute element count in map...");
        logger.info(JSON.toJSONString(counts));
//        System.out.println(counts);

    }
}
