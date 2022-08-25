#GC
##垃圾标记
###1.引用计数
###2.根可达搜索
1.哪些是根对象<br>
* Java虚拟机栈
* 本地方法栈
* 运行时常量池
* 方法区的静态引用
* 类（clazz）
##垃圾收集算法
* 标记清除：适用于存活对象较多的情况。容易产生碎片，两遍扫描（标记，清除？）
* 复制算法：将内存分为多块，将存活对象复制到另一块。空间浪费，对象引用的改变
* 标记压缩：扫描两次+移动对象；不会产生碎片
##JVM的内存分代模型
1.epsilon，ZGC,Shenandoah不分代<br>
2.G1是逻辑分代，物理不分代<br>
3.其他的不仅逻辑分代，而且物理分代<br>
##进入老年代的时机
* 超过XX:MaxTenuringThreshold指定的次数
<br> PS 15
<br> CMS 6
<br> G1 15
* 动态年龄
<br>拷贝到survivor区超过50%，将年龄最大的放入old区
#CMS
并发垃圾回收是因为无法忍受STW
* 初始标记（STW）：找到根对象
* 并发标记（和工作线程一起工作）：根据根搜索标记
* 重新标记（STW）：重新2阶段产生的垃圾，或者不是再是垃圾的对象
* 并发清理（和工作线程一起工作）：会产生浮动垃圾，等待下一次CMS GC的触发
###CMS的问题
* 内存碎片化：因为使用的是Mark sweep，所以会有内存碎片化，所以当新代到老年代的时候
，找不到这么大的内存空间，会将serial old垃圾收集用来标记压缩，这时会处于长时间的STW
<br>-XX:+UseCMSCompactAtFullCollection
<br>-XX:CMSFullGCsBeforeCompaction:默认为0，指经过多少次FGC后才进行压缩
* 浮动垃圾
<br>Concurrent Mode Failure：解决方案，降低触发触发CMS的阈值，-XX:CMSInitiatingOccupancyFraction，默认是92%
<br>PromotionFailed：保持老年代有足够的空间
###并发标记使用到的算法
* CMS：三色标记+Incremental Update
* G1：三色标记+SATB
* ZGC:颜色指针+写屏障？
* Shenandoah：颜色指针+读屏障？