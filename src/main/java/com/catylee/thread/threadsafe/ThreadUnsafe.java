package com.catylee.thread.threadsafe;

import java.util.ArrayList;

/**
 * 成员变量
 *
 */
public class ThreadUnsafe {
    static final int THREAD_NUMBER = 2;
    static final int LOOP_NUMBER = 200;
    ArrayList<String> list = new ArrayList<>();
    public void method1(int loopNumber) {
        for (int i = 0; i < loopNumber; i++) {
// { 临界区, 会产生竞态条件
            method2();
            method3();

        }
    }
    private void method2() {
        list.add("1");
    }
    private void method3() {
        list.remove(0);
    }

    public static void main(String[] args) {
        ThreadUnsafe threadUnsafe=new ThreadUnsafe();
        //报错 IndexOutOfBoundsException 线程1
        //public boolean add(E e) {
        //        ensureCapacityInternal(size + 1);  // Increments modCount!!
        //        elementData【size++】 = e;
        //        return true;
        //    }
        //线程t1获取size为0，并把元素e赋值给element【0】,还没进行size=size+1时
        //t2线程来了,再次获取到size为0,并把元素e赋值给element【0】
        //此时element数组中只有一个元素e
        //我们错误以为element【0】,element【1】都是e,实际只有element【0】是e
        //随后进行2次remove出错
        for (int i = 0; i < THREAD_NUMBER; i++) {
            new Thread(() -> {
                threadUnsafe.method1(LOOP_NUMBER);
            }, "Thread" + i).start();
        }
    }


}
