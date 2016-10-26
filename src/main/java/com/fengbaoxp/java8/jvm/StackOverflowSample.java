package com.fengbaoxp.java8.jvm;

/**
 * 栈溢出示例。
 * 设置JVM参数： -Xss3m 可以消除StackOverflowError.
 * @author Eugene Wang
 * @since 16/10/26
 */
public class StackOverflowSample {
    public static void main(String[] args) {
        try {
            System.out.println(fact(1 << 15));
        } catch (Error e) {
            System.err.println("true recursion level was " + level);
            System.err.println("reported recursion level was " + e.getStackTrace().length);
            e.printStackTrace();
        }
    }

    private static int level = 0;

    /**
     * 递归函数。
     * @param n
     * @return
     */
    public static long fact(int n) {
        level++;
        return n < 2 ? n : n * fact(n - 1);
    }
}
