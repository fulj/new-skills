package com.fulj;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JustTest {

    public static void main(String[] args) {
        Map<String, Object> readinsDelayMap = new HashMap<>();
        readinsDelayMap.put("ReadonlyInstanceDelay", new ArrayList<>());
        List<Map<String, String>> readDelayValueList = (List<Map<String, String>>) readinsDelayMap.get("ReadonlyInstanceDelay");
        Map<String, String> readDelayValues = new HashMap<>();
        readDelayValues.put("ReadDBInstanceName", "0");
        readDelayValues.put("SendLatency", "1");
        readDelayValues.put("WriteLatency", "2");
        readDelayValues.put("FlushLatency", "3");
        readDelayValues.put("ReplayLatency", "4");
        readDelayValues.put("WriteLag", "5");
        readDelayValues.put("FlushLag", "6");
        readDelayValues.put("ReplayLag", "7");
        readDelayValueList.add(readDelayValues);
        System.out.println("================");
        readDelayValues.remove("ooo");
        System.out.println("================");
        System.out.println("..."+JSON.toJSONString(readinsDelayMap));
    }
    @Test
    void test(){
        Map<String, Object> readinsDelayMap = new HashMap<>();
        readinsDelayMap.put("ReadonlyInstanceDelay", new ArrayList<>());
        List<Map<String, String>> readDelayValueList = (List<Map<String, String>>) readinsDelayMap.get("ReadonlyInstanceDelay");
        Map<String, String> readDelayValues = new HashMap<>();
        readDelayValues.put("ReadDBInstanceName", "0");
        readDelayValues.put("SendLatency", "1");
        readDelayValues.put("WriteLatency", "2");
        readDelayValues.put("FlushLatency", "3");
        readDelayValues.put("ReplayLatency", "4");
        readDelayValues.put("WriteLag", "5");
        readDelayValues.put("FlushLag", "6");
        readDelayValues.put("ReplayLag", "7");
        readDelayValueList.add(readDelayValues);
        System.out.println("..."+JSON.toJSONString(readinsDelayMap));
    }
}
