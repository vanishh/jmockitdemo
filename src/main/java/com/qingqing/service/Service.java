package com.qingqing.service;

import com.qingiqng.Status;
import com.qingqing.dao.TestDao;

/**
 * Mock 测试主要用来测试service层逻辑
 */
public class Service {

    private TestDao dao;

    public void setDao(TestDao dao) {
        this.dao = dao;
    }

    /**
     * 根据库存量判断货物是否畅销
     */
    public Status checkStatus(String group) {
        int count = dao.getStoreCount(group);

        if (count <= 0) {
            return Status.UNKOWN;
        } else if (count <= 800) {
            return Status.UNSALABLE;
        } else if (count <= 1000) {
            return Status.NORMAL;
        } else {
            return Status.SELLINGWELL;
        }
    }

    public static void main(String[] args){
        Service service = new Service();
        TestDao dao = new TestDao();
        service.setDao(dao);

        System.out.println(service.checkStatus("A"));
        System.out.println(service.checkStatus("B"));
        System.out.println(service.checkStatus("D"));
    }
}
