package com.qingiqng;

import mockit.Mocked;
import mockit.NonStrictExpectations;
import org.junit.Assert;
import org.junit.Test;

public class MyObjectTest {

    // 全局模拟时，使用@Mocked注解进行标注模拟对象
    @Mocked
    MyObject obj;

    // 测试public方法
    @Test
    public void testHello(){

        // 准备数据
        new NonStrictExpectations(){
            {
                obj.hello(anyString);
                result = "hello geyang";
            }
        };

        // 调用测试方法
        Assert.assertEquals("hello geyang", obj.hello("nihao"));

        // 验证预期Mock行为被调用
//        new Verifications() {
//            {
//                obj.hello("geyang");
//                times = 1;
//            }
//        };

    }

    /**
     *  测试静态方法
     * */

    @Test
    public void testSayHello(){

        new NonStrictExpectations(MyObject.class){
            {
                MyObject.sayHello(anyString);
                result = "nihao geyang!";
            }
        };

        Assert.assertEquals("nihao geyang!", MyObject.sayHello("nihao"));
    }
}
