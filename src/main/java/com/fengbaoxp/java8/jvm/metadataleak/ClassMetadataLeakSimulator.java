package com.fengbaoxp.java8.jvm.metadataleak;

import java.lang.reflect.Proxy;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;

/**
 * Metaspace溢出示例（java.lang.OutOfMemoryError: Metaspace）。
 * 设置JVM参数： -XX:MaxMetaspaceSize=128m
 * @author Eugene Wang
 * @since 16/10/26
 */
public class ClassMetadataLeakSimulator {
    private static Map<String, ClassA> classLeakingMap = new HashMap<>();
    private static final int NB_ITERATIONS_DEFAULT = 50000;

    public static void main(String[] args) {
        System.out.println("Class metadata leak simulator");

        int nbIterations = (args != null && args.length == 1) ? Integer.parseInt(args[0]) : NB_ITERATIONS_DEFAULT;

        try {
            for (int i = 0; i < nbIterations; i++) {
                System.out.println("class metadata leak : " + i);
                String fictiousClassloaderJAR = "file:" + i + ".jar";
                URL[] fictiousClassloaderURL = new URL[] {new URL(fictiousClassloaderJAR)};
                URLClassLoader newClassLoader = new URLClassLoader(fictiousClassloaderURL);
                ClassA t = (ClassA) Proxy.newProxyInstance(newClassLoader, new Class<?>[]{ClassA.class},
                                                           new ClassAInvocationHandler(new ClassAImpl()));
                classLeakingMap.put(fictiousClassloaderJAR, t);
            }
        } catch (Throwable e) {
            System.out.println("ERROR:" + e);
        }
        System.out.println("Done!");
    }
}
