package com.qingiqng;

import com.qingqing.dao.TestDao;
import com.qingqing.service.Service;
import mockit.*;
import org.junit.Assert;
import org.junit.Test;

public class StatusMockTest {

    @Tested
    private Service service;

    @Injectable
    private TestDao dao;

    @Test
    public void test() {

        //1. 创建mock对象
        MockUp<TestDao> mockUp = new MockUp<TestDao>() {
            @Mock
            public int getStoreCount(String group) {
                return 2000;
            }
        };

        new NonStrictExpectations() {
            {
                dao.isUserExist(anyString);
                result = true;
            }
        };

        // 2. 获取实例
//        dao = mockUp.getMockInstance();

        // 3. 调用
        Assert.assertEquals(Status.SELLINGWELL, service.checkStatus("D"));
        Assert.assertEquals(true, service.isUserExist("nihao"));
    }

}
