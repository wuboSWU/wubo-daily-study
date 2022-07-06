#运行时数据区
## 1.PC(程序计数器)
线程私有，每个线程都有自己的PC
## 2.JVM Stacks(虚拟机栈)
线程私有，每个线程都有自己的虚拟机栈
## 3，Method Area(方法区)
jdk<1.8：Perm Space(永久代，FGC不会处理)
<br>字符串常量位于run-time constant pool(运行时常量池)
<br>jdk>=1.8 Meta Space(元空间，FGC会处理)
<br>字符串常量位于heap
## 4.Native Method Stacks(本地方法栈)
线程私有？
## 5.Direct Memory(直接内存)
JVM可以直接访问内核的空间
<br>NIO,提高效率，实现零拷贝
## 6.Heap(堆)