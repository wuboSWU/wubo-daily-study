#JVM 参数
##GC日志
* -XX:+PrintGC
* PrintGCDetails：打印更详细的GC内容
* PrintGCTimeStamps：打印GC的时间
* PrintGCCauses：打印GC产生的原因
* HeapDump?：日志后面的地址指的是，起始地址，使用空间的结束地址
，整体空间的结束地址

##GC调优
吞吐量优先：一般是PS+PO<br>
响应时间优先：CMS或者G1<br>
* 设置GC日志参数
-Xloggc:/opt/xxx/logs/xxx-xxx-%t.log：设置GC日志目录路径
-XX:+UseGCLogFileRotation：循环产生日志
-XX:NumberOfGCLogFiles=5：
-XX:GCLogFileSize=20M：每个GC文件的大小

#CPU资源利用率高的排查思路
1. 找出占用CPU高的进程：top 
2. 找出占用CPU高的线程:top -hp pid 
3. 导出该线程的堆栈：jstack 
4. 找出哪个方法消耗的时间长：jstack

#内存占用高的排查思路
导出堆内存：
1. jmap<br>
jmap -dump:format=b,file=c pid;这个命令对JVM性能影响很大，一般会禁用掉这个服务器才使用
2. HeapDumpOnOutOfMemoryError,JVM参数中加上，当发生OOM时自动dump