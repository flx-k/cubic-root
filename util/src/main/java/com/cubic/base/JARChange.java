package com.cubic.base;

import com.cubic.exception.NoPlugException;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JARChange {
    static Logger logger= LogManager.getLogger(JARChange.class);
    public static Map<String,String> classMap=new HashMap<>();
    public static Map<String, Set> fileClassMap=new HashMap<>();
    public static String getClassName(String key) throws NoPlugException {
        if(!classMap.containsKey(key.toUpperCase()))
            throw new NoPlugException(key);
        return classMap.get(key.toUpperCase());
    }
//    public static void init(String path){
//        File file=new File(path);
//        logger.info("onFileCreate::"+file.getAbsolutePath());
//        try {
//            ClassUtil.loadJarsFromAppFolder(file.getAbsolutePath());
//        } catch (Exception e) {
//            logger.error(e.getMessage(),e);
//            return;
//        }
//        Map<String,String> cMap=new HashMap();
//        try {
//            cMap=ClassUtil.getJarMap(file.getAbsolutePath());
//        } catch (IOException e) {
//            logger.error(e.getMessage(),e);
//            return;
//        }
//        if(cMap.size()>0){
//            fileClassMap.put(file.getAbsolutePath(),cMap.keySet());
//            classMap.putAll(cMap);
//        }
//    }
    public static void run(String path, ApplicationContext applicationContext) throws Exception {



        FileFilter fileFilter= FileFilterUtils.and(new IOFileFilter() {
            @Override
            public boolean accept(File file) {
                String extension=FilenameUtils.getExtension(file.getAbsolutePath());
                return "jar".equalsIgnoreCase(extension);
            }
            @Override
            public boolean accept(File file, String s) {
                return false;
            }
        });
        FileAlterationObserver fileAlterationObserver=new FileAlterationObserver(path,fileFilter);
        fileAlterationObserver.addListener(new FileAlterationListenerAdaptor(){
            @Override
            public void onDirectoryChange(File directory) {
                logger.info("onDirectoryChange::"+directory.getAbsolutePath());
                super.onDirectoryChange(directory);
            }



            @Override
            public void onFileChange(File file) {
                logger.info("onFileChange::"+file.getAbsolutePath());
                try {
                    ClassUtil.loadJarsFromAppFolder(file.getAbsolutePath());
                } catch (Exception e) {
                    logger.error(e.getMessage(),e);
                    return;
                }
                Map<String,String> cMap;
                try {
                    cMap=ClassUtil.getJarMap(file.getAbsolutePath(),applicationContext);
                } catch (IOException e) {
                    logger.error(e.getMessage(),e);
                    return;
                }
                if(cMap.size()>0){
                    fileClassMap.put(file.getAbsolutePath(),cMap.keySet());
                    classMap.putAll(cMap);
                }
                super.onFileChange(file);
            }
            @Override
            public void onFileCreate(File file) {
                logger.info("onFileCreate::"+file.getAbsolutePath());
                try {
                    ClassUtil.loadJarsFromAppFolder(file.getAbsolutePath());
                } catch (Exception e) {
                    logger.error(e.getMessage(),e);
                    return;
                }
                Map<String,String> cMap=new HashMap();
                try {
                    cMap=ClassUtil.getJarMap(file.getAbsolutePath(),applicationContext);
                } catch (IOException e) {
                    logger.error(e.getMessage(),e);
                    return;
                }
                if(cMap.size()>0){
                    fileClassMap.put(file.getAbsolutePath(),cMap.keySet());
                    classMap.putAll(cMap);
                }
                super.onFileCreate(file);
            }
            @Override
            public void onFileDelete(File file) {
                logger.info("onFileDelete::"+file.getAbsolutePath());
                super.onFileDelete(file);
            }
        });
        FileAlterationMonitor filealterationMonitor=new FileAlterationMonitor(1000);
        filealterationMonitor.addObserver(fileAlterationObserver);
        filealterationMonitor.start();
    }
}
