package com.qingiqng;

import com.qingqing.dao.TestDao;
import com.qingqing.service.Service;
import mockit.Injectable;
import mockit.Mock;
import mockit.MockUp;
import mockit.Tested;
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

        // 3. 调用
        Assert.assertEquals(Status.SELLINGWELL, service.checkStatus("A"));
//        Assert.assertEquals(true, service.isUserExist("nihao"));
    }

    @Test
    public void testAddUser(){
        new MockUp<TestDao>() {
            @Mock
            public void insertUser(User user){
                user.setName("geyang");
            }
        };
        User user = new User();
        user.setName("qingqing");
        service.addUser(user);
    }

}
