package com.cubic.base;

import com.cubic.imp.TestImp;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class ClassUtil {

    public static void loadJarsFromAppFolder(String path) throws Exception {
        File f = new File(path);
        if (f.isDirectory()) {
            for (File _f : f.listFiles()) {
                if (_f.isFile()) {
                    loadJarFile(_f);
                }
            }
        } else {
            loadJarFile(f);
        }
    }

    private static void loadJarFile(File path) throws MalformedURLException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        URL url=path.toURI().toURL();
        URLClassLoader classLoader= (URLClassLoader) ClassLoader.getSystemClassLoader();
        Method method=URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
        method.setAccessible(true);
        method.invoke(classLoader,url);
    }

    public static Object getPlugClass(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return Class.forName(className).newInstance();
    }

    public static void main(String[] args) throws Exception {

        loadJarsFromAppFolder("D:/11/plug");
//        TestImp testImp  = (TestImp) getPlugClass("com.myplug.TestPlug");
        TestImp instance = (TestImp) getPlugClass("com.myplug.TestPlug");
        instance.test();
        System.out.println(instance.retuStr());
    }

}
