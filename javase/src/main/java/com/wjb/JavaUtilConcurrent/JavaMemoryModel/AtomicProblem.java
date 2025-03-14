package com.wjb.JavaUtilConcurrent.JavaMemoryModel;

/**
 * 并发编程的原子性问题
 * <p>
 * 演示多线程环境下非原子操作导致的数据不一致
 */
public class AtomicProblem {

    private int count = 0; // 共享计数器

    public static void main(String[] args) throws InterruptedException {

        final AtomicProblem atomicProblem = new AtomicProblem();

        // 创建两个线程各执行10000次自增
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                atomicProblem.count++;
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                atomicProblem.count++;
            }
        });

        t1.start();
        t2.start();
        t1.join();  // 等待线程结束
        t2.join();

        // 预期结果应该是20000，但实际会小于等于这个值
        System.out.println("最终计数：" + atomicProblem.count);
    }
}