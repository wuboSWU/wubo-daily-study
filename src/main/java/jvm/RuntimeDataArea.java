package jvm;

public class RuntimeDataArea {
    public static void main(String[] args) {
        //看它的bytecode
        int i = 8;
        i = i++;
        System.out.println(i);
        i = ++i;
        System.out.println(i);
        i++;
        System.out.println(i);
    }
}
