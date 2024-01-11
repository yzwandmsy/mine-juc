package com.it;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;

/**
 * @author ：图灵-杨过
 * @date：2019/7/11
 * @version: V1.0
 * @slogan: 天下风云出我辈，一入代码岁月催
 * @description :可用于流量控制，限制最大的并发访问数
 */
public class SemaphoreSample {

    public static void main(String[] args)  {

        Semaphore semaphore = new Semaphore(4);
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }, "我的线程").start();
        for (int i=0;i<100;i++){
            new Thread(new Task(semaphore,"yangguo+"+i)).start();
        }
    }

    static class Task extends Thread{
        Semaphore semaphore;

        public Task(Semaphore semaphore,String tname){
            this.semaphore = semaphore;
            this.setName(tname);
        }

        public void run() {
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName()+":aquire() at time:"+System.currentTimeMillis());

                Thread.sleep(1000);

                semaphore.release();
                System.out.println(Thread.currentThread().getName()+":release() at time:"+System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


}
