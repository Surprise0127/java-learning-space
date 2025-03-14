# Stream流

## 1. Stream流的概念
Stream流是Java8中处理集合的关键抽象概念，它可以对集合进行各种操作（过滤、映射、排序、归约等），并且提供了串行和并行两种模式进行汇聚操作。

## 2. Stream流的特点
- Stream流不是数据结构，不保存数据，它是有关算法和计算的。
- Stream流不会改变源对象，相反，他们会返回一个持有结果的新Stream。
- Stream流操作是延迟执行的。这意味着他们会等到需要结果的时候才执行。
- Stream流是可以操作任意数量次的。
- Stream流是支持函数式编程的。
- Stream流的操作是无状态的。
- Stream流的操作是可以组合的。
- Stream流的操作是可以并行执行的。
- Stream流的操作是惰性执行的。

## 3. Stream流的创建
Stream流的创建有两种方式：
- 通过集合创建Stream流
- 通过Stream的静态方法创建Stream流
- 通过Stream的of方法创建Stream流
- 通过Stream的iterate方法创建Stream流
- 通过Stream的generate方法创建Stream流
- 通过Arrays的stream方法创建Stream流
- 通过BufferedReader的lines方法创建Stream流
- 通过Files的lines方法创建Stream流
- 通过Pattern的splitAsStream方法创建Stream流
- 通过StreamSupport的stream方法创建Stream流
- 通过IntStream、LongStream、DoubleStream创建Stream流
- 通过Random的ints方法创建Stream流
- 通过BitSet的stream方法创建Stream流

## 4. Stream流的中间操作
Stream流的中间操作是对Stream流的数据进行处理，返回一个新的Stream流。Stream流的中间操作有很多种，如下：
- filter：过滤
- map：映射
- flatMap：扁平化映射
- distinct：去重
- sorted：排序
- peek：查看
- limit：截取
- skip：跳过
- parallel：并行
- sequential：串行
- unordered：无序
- onClose：关闭
- close：关闭
- mapToInt：映射为IntStream
- mapToLong：映射为LongStream
- mapToDouble：映射为DoubleStream
- boxed：装箱
- asLongStream：转为LongStream
- asDoubleStream：转为DoubleStream

## 5. Stream流的终结操作
Stream流的终结操作是对Stream流的数据进行处理，返回一个非Stream流的结果。Stream流的终结操作有很多种，如下：
- forEach：遍历
- forEachOrdered：有序遍历
- toArray：转为数组
- reduce：归约
- collect：收集
- min：最小值
- max：最大值
- count：计数
- anyMatch：是否匹配
- allMatch：是否全部匹配
- noneMatch：是否没有匹配
- findFirst：查找第一个
- findAny：查找任意一个
- iterator：迭代器
- spliterator：分割迭代器
- isParallel：是否并行
- sequential：串行
- parallel：并行
- unordered：无序
- onClose：关闭
- close：关闭
- summaryStatistics：统计
- minBy：最小值
- maxBy：最大值
- groupingBy：分组
- partitioningBy：分区
- joining：连接
- counting：计数
- summingInt：求和
- averagingInt：平均值
- summarizingInt：统计
- reducing：归约
- collectingAndThen：收集
- toList：转为List
- toSet：转为Set
- toMap：转为Map

## 6. Stream流的并行流
Stream流的并行流是通过parallel方法将串行流转为并行流，通过sequential方法将并行流转为串行流。并行流的操作是可以并行执行的，可以提高效率。

## 7. Stream流的收集器
Stream流的收集器是通过collect方法将Stream流的数据收集到一个集合中。Stream流的收集器有很多种，如下：
- toList：转为List
- toSet：转为Set
- toMap：转为Map
- toCollection：转为Collection
- counting：计数
- summingInt：求和
- averagingInt：平均值

## 8. Stream流的分组
Stream流的分组是通过groupingBy方法将Stream流的数据分组。Stream流的分组有很多种，如下：
- groupingBy：分组

## 9. Stream流的分区


## 10. Stream流的连接


## 11. Stream流的归约

