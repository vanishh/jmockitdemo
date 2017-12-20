package com.qingqing.dao;

import java.util.HashMap;
import java.util.Map;

public class TestDao {

    // 假设DAO实现的方式是从数据库中取出数据
    private static Map<String, Integer> groupsCounts = new HashMap<String, Integer>();

    static {
        groupsCounts.put("A", 500);
        groupsCounts.put("B", 1000);
        groupsCounts.put("C", 1200);
    }

    public int getStoreCount(String group){
        Integer result = groupsCounts.get(group);
        return result == null ? -1 : result.intValue();
    }

}
