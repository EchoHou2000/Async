package com.example.demo.service.Impl;

import cn.iocoder.yudao.framework.quartz.config.YudaoAsyncAutoConfiguration;
import com.example.demo.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class AsyncServiceImpl implements AsyncService {

    @Autowired
    private YudaoAsyncAutoConfiguration yudaoAsyncAutoConfiguration;

    private BeanPostProcessor threadPoolTaskExecutorBeanPostProcessor;

    @PostConstruct
    public void init() {
        threadPoolTaskExecutorBeanPostProcessor = yudaoAsyncAutoConfiguration.threadPoolTaskExecutorBeanPostProcessor();
    }

    public void asyncUpload() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 执行 BeanPostProcessor 的后置处理
        threadPoolTaskExecutorBeanPostProcessor.postProcessBeforeInitialization(executor, "executor");
        // 执行异步处理逻辑
        executor.execute(() -> {
            // 异步处理逻辑
        });
        // ...
    }
}
