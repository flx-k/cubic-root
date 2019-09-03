package com.cubic.base;

import com.cubic.imp.TestImp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.thymeleaf.spring5.context.SpringContextUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ClassUtil {
    static Logger logger= LogManager.getLogger(ClassUtil.class);
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
//        ClassLoader classLoader=applicationContext.getClassLoader();
        URLClassLoader classLoader= (URLClassLoader) ClassLoader.getSystemClassLoader();
//        classLoader
//        classLoader.loadClass()
        Method method=URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
        method.setAccessible(true);
        logger.info("url::"+url);
        method.invoke(classLoader,url);
    }
    public static Map<String, String> getJarMap(String path,ApplicationContext applicationContext) throws IOException {
        Map<String,String> map=new HashMap<>();
        JarFile jarFile=new JarFile(path);
        Enumeration<JarEntry> entrys=jarFile.entries();
        JarEntry jarEntry;
        String name,classname;
        String[] names;
        while (entrys.hasMoreElements()){
            jarEntry=entrys.nextElement();
            name=jarEntry.getName();
            if(!jarEntry.isDirectory()&&name.endsWith(".class")){
                classname=name.substring(0,name.length()-6).replace("/",".");
                names=classname.split("\\.");
                map.put(names[names.length-1].toUpperCase(),classname);
                Class cla= null;
                try {
                    cla = Class.forName(classname);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(cla);
//                BeanDefinition beanDefinition = beanDefinitionBuilder.getRawBeanDefinition();
                DefaultListableBeanFactory defaultListableBeanFactory= (DefaultListableBeanFactory) applicationContext.getAutowireCapableBeanFactory();
//                genericBeanDefinition.setScope("singleton");/**/
                beanDefinitionBuilder.setScope("singleton");
//                if(defaultListableBeanFactory)
                if(applicationContext.containsBean(classname))
                    defaultListableBeanFactory.removeBeanDefinition(classname);
                defaultListableBeanFactory.registerBeanDefinition(classname,beanDefinitionBuilder.getBeanDefinition());
            }
        }
        return map;
    }

    public static Object getPlugClass(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return Class.forName(className).newInstance();
    }

    public static void main(String[] args) throws Exception {
        String a="asdasd";
        System.out.println(a.split("\\.").length);
        return;
//        loadJarsFromAppFolder("D:/11/plug");
//        TestImp testImp  = (TestImp) getPlugClass("com.myplug.TestPlug");
//        TestImp instance = (TestImp) getPlugClass("com.myplug.TestPlug");
//        instance.test();
//        System.out.println(instance.retuStr());
    }

}
