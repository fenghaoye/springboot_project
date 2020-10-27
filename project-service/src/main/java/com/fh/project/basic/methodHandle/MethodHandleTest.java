package com.fh.project.basic.methodHandle;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class MethodHandleTest {

    static class ClassA {
        public void println(String s) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) throws Throwable {
        Object obj = System.currentTimeMillis() % 2 == 0 ? System.out : new ClassA();
        // 无论obj是哪种类型，下面这句都会正确调用到println方法
        getPrintlnMH(obj).invokeExact("icyfenix");
    }

    private static MethodHandle getPrintlnMH(Object reveiver) throws Throwable {
        // MethodType 代表方法类型，包含了方法的返回值（第一个参数）和方法的参数（第二个及以后的参数）
        MethodType mt = MethodType.methodType(void.class, String.class);

        // 这句话的作用是在指定类中查找符合给定的方法名称，方法类型，并且符合权限调用的方法句柄
        // 因为这里调用的是一个虚方法，方法的第一个参数是隐式的，代表该方法的接收者，也就是this对象，
        // 这个参数以前是放在方法参数中进行传递，现在通过bindTo方法来完成这件事
        return MethodHandles.lookup().findVirtual(reveiver.getClass(), "println", mt).bindTo(reveiver);

    }
}
