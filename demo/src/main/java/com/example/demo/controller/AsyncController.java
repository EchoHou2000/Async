package com.example.demo.controller;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import com.example.demo.service.Impl.AsyncServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class AsyncController {

    @Autowired
    private AsyncServiceImpl asyncServiceImpl;

    @RequestMapping("/demo/asyncUpload")
    public CommonResult<?> asyncUpload() {
        asyncServiceImpl.asyncUpload();
        return CommonResult.success("ok");
    }

}
