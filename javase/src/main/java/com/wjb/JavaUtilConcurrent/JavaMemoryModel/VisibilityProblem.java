package com.wjb.JavaUtilConcurrent.JavaMemoryModel;

/**
 * 并发编程的可见性问题
 * <p>
 * 如果主线程将主存中的flag（在JVM物理内存模型中对应的是堆）被赋值为false，则会输出"Thread stopped"。
 */
public class VisibilityProblem {
//    private static volatile boolean flag = true;
    private static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (flag) {
                Thread.onSpinWait();
            } // 可能永远循环
            System.out.println("Thread stopped");
        });

        thread.start();
        Thread.sleep(1000);
        flag = false;
    }
}
