#运行时数据区
## 1.PC(程序计数器)
线程私有，每个线程都有自己的PC
## 2.JVM Stacks(虚拟机栈)
线程私有，每个线程都有自己的虚拟机栈<br>
里面存储的是栈帧<br>
## 3，Method Area(方法区)
1.jdk<1.8：Perm Space(永久代，FGC不会处理，可以理解为是一个严重的bug)<br>
2.字符串常量位于run-time constant pool(运行时常量池)<br>
3.jdk>=1.8 Meta Space(元空间，FGC会处理)<br>
4.字符串常量位于heap<br>
5.各个线程共享<br>
###栈帧
1.Local Variable Table：局部变量表<br>
2.Operand Stack<br>
3.Dynamic Linking<br>
指向class文件中的那些定义引用<br>
4.Return Address<br>
补充：Hotspot是基于栈的指令集，还有基于寄存器的指令集，Hotspot中的local variable table类似于寄存器
被调用方法返回值放在调用方法的什么地方
####字节码
1.bipush(byte)：将可以byte大小表示的int压栈<br>
2.sipush(short)：将可以short大小表示的int压栈<br>
3.对象方法中，局部变量表的第一个变量是this<br>
4.iadd：出栈2个元素进行相加<br>
5.dup：复制对象引用并且压栈<br>
6.astore_x：出栈值保存到局部变量表的第x个元素(还有istore,i是int,a是address)<br>
7.aload_x：将局部变量表中的第x个元素压栈(还有iload,i是int,a是address)<br>
8.iconst_1：把常量值1压栈（也可以是x）<br>
9.invokestatic：调用静态方法<br>
10.invokevirtual：调用对象的方法（自带多态，及压栈的是哪个对象，就调那个对象的方法）<br>
11.invokespecial：可以直接定位，不需要多态的方法，如private方法，构造方法<br>
12.invokeinterface：接口调用，多态<br>
13.invokedynamic：jdk1.7之前没有，lambda表达式或者反射或者其他动态语言，如Scala，动态产生的class需要用到的指令
## 4.Native Method Stacks(本地方法栈)
线程私有<br>
## 5.Direct Memory(直接内存)
JVM可以直接访问内核的空间
<br>NIO,提高效率，实现零拷贝
## 6.Heap(堆)
各个先传给你共享<br>