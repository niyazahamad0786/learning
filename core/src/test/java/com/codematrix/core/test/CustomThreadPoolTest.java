package com.codematrix.core.test;

import com.codematrix.core.thread.CustomThreadPool;
import org.junit.Test;

public class CustomThreadPoolTest {

    @Test
    public void testThreadPool() {
        CustomThreadPool threadPool = new CustomThreadPool(10);
        try {
            for (int i = 0; i < 10; i++) {
                threadPool.submit(() -> {
                    System.out.printf("Executed by thread %s\n", Thread.currentThread().getName());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
            threadPool.shutDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
