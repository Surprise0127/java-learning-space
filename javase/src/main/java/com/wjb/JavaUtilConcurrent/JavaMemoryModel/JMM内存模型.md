# Java内存模型

## 1. Java内存模型概述
Java内存模型（Java Memory Model，JMM）是定义多线程程序中共享变量访问规则的抽象模型，规定了线程如何与主内存及工作内存进行交互。JMM解决了多线程环境下的可见性、原子性、有序性问题，是Java并发编程的核心基础。

## 2. 内存区域划分
### 2.1 主内存（Main Memory）
- 存储所有共享变量（实例字段、静态字段等）
- 所有线程共享的存储区域
- 通过内存屏障保证可见性

### 2.2 工作内存（Working Memory）
- 每个线程私有的内存空间
- 存储该线程使用的共享变量副本
- 与主内存通过8种原子操作交互

## 3. 并发编程的三大特性
并发编程的三大核心特性是 ***原子性（Atomicity）、可见性（Visibility）***和*** 有序性（Ordering）***

### 3.1 可见性-volatile
```java
package com.wjb.jmm;

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
```

### 3.2 原子性-synchronized

```java
package com.wjb.jmm;

/**
 * 并发编程的原子性问题
 * <p>
 * 演示多线程环境下非原子操作导致的数据不一致
 */
public class AtomicProblem {

    private int count = 0; // 共享计数器

    public static void main(String[] args) throws InterruptedException {

        final com.wjb.JavaUtilConcurrent.JavaMemoryModel.AtomicProblem atomicProblem = new com.wjb.JavaUtilConcurrent.JavaMemoryModel.AtomicProblem();

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
```

### 3.3 有序性-指令重排
```java

```
