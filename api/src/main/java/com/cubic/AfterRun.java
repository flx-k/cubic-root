package com.cubic;

import com.cubic.api.TestApi;
import com.cubic.base.ClassUtil;
import com.cubic.base.JARChange;
import com.cubic.model.Account;
import com.cubic.service.AccountService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 初始化完成后的操作
 */
@Component
public final class AfterRun implements ApplicationRunner {
    Logger logger= LogManager.getLogger(AfterRun.class);
    @Autowired
    public ApplicationContext applicationContext;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("加载插件.........");
        JARChange.run("D:/11/plug/",applicationContext);
        logger.info("插件加载完成.........");
    }
}
