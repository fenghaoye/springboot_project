package com.fh.project.basic.methodHandle;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;

/**
 * @Description
 * @Author fenghao
 * @Email 849260688@qq.com
 * @Date 2020/4/7 10:50 下午
 */
class Test {

    class GrandFather {
        void thinking() {
            System.out.println(" i am grandfather");
        }
    }

    class Father extends GrandFather {
        void thinking() {
            System.out.println(" i am father");
        }
    }

    class Son extends Father {
        void thinking() {
            MethodType methodType = MethodType.methodType(void.class);
            try {
                Field implLookup = MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP");
                implLookup.setAccessible(true);
                MethodHandle handle = ((MethodHandles.Lookup) implLookup.get(null))
                        .findSpecial(GrandFather.class, "thinking", methodType, GrandFather.class);
                handle.invoke(this);
            } catch (Throwable e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        (new Test().new Son()).thinking();
    }
}
