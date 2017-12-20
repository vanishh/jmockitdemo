package com.qingqing.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestDao {

    // 假设DAO实现的方式是从数据库中取出数据
    private static Map<String, Integer> groupsCounts = new HashMap<String, Integer>();
    private static List<String> username = new ArrayList<String>();
    static {
        groupsCounts.put("A", 500);
        groupsCounts.put("B", 1000);
        groupsCounts.put("C", 1200);

        username.add("geyang");
        username.add("qingqing");
    }

    public int getStoreCount(String group){
        Integer result = groupsCounts.get(group);
        return result == null ? -1 : result.intValue();
    }

    public boolean isUserExist(String username) {
        boolean result = false;
        if (username != null){
            result = username.contains(username);
        }
        return result;
//        return username != null ? username.contains(username) : false;
    }
}
