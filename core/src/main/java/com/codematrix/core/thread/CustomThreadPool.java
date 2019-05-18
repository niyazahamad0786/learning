package com.codematrix.core.thread;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CustomThreadPool {
    private volatile Boolean shutdown = Boolean.FALSE;
    private List<Thread> taskExecutors = new LinkedList<>();
    private BlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<>();

    public CustomThreadPool(int threadCount) {
        for (int i = 0; i < threadCount; i++) {
            Thread nThread = new Thread(new TaskExecutor(taskQueue), String.format("CustomThread-%s", i));
            nThread.start();
            taskExecutors.add(nThread);
        }
    }

    public void submit(Runnable task) throws InterruptedException {
        if (Objects.isNull(task)) throw new IllegalArgumentException("Task can't be null");
        taskQueue.put(task);
    }

    public void shutDown() {
        System.out.println("Shutting down thread pool");
        shutdown = Boolean.TRUE;
    }

    private class TaskExecutor implements Runnable {

        private BlockingQueue<Runnable> taskQueue;

        public TaskExecutor(BlockingQueue<Runnable> taskQueue) {
            this.taskQueue = taskQueue;
        }

        @Override
        public void run() {
            while (!shutdown) {
                try {
                    Runnable task = taskQueue.take();
                    task.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
