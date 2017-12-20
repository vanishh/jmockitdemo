package com.qingiqng;

import com.qingqing.dao.TestDao;
import com.qingqing.service.Service;
import mockit.Injectable;
import mockit.NonStrictExpectations;
import mockit.Tested;
import org.junit.Assert;
import org.junit.Test;

public class BehaviorMockTest {
    /**
     * 基于行为的Mock分为三个阶段：record、replay、verfiy
     * record: 自己设置数据，对于那些希望在测试中被模拟的模块
     * replay: 执行单元测试
     * verfiy:
     * */

//    @Mocked
//    TestDao dao = new TestDao();

    @Tested
    private Service service;

    @Injectable
    private TestDao dao;

    @Test
    public void test() {
        // 1. record 录制数据
        new NonStrictExpectations() {

            {
                dao.getStoreCount(anyString);
                result = 900;
                times = 1;
            }
        };
//        service.setDao(dao);

        Assert.assertEquals(Status.NORMAL, service.checkStatus("D"));
    }
}
