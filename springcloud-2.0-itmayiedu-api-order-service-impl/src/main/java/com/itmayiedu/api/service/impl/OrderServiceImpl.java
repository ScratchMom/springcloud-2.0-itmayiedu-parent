package com.itmayiedu.api.service.impl;

import com.itmayiedu.api.entity.UserEntity;
import com.itmayiedu.api.feign.MemberServiceFeign;
import com.itmayiedu.api.service.IOrderService;
import com.itmayiedu.base.BaseApiService;
import com.itmayiedu.base.ResponseBase;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author laowang
 * @date 2018/12/14 11:07 AM
 * @Description:
 */
@Slf4j
@RestController
public class OrderServiceImpl extends BaseApiService implements IOrderService {

    Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
    @Autowired
    MemberServiceFeign memberServiceFeign;

    @RequestMapping("/orderToMember")
    @Override
    public String orderToMember(String name) {
        UserEntity userEntity = memberServiceFeign.getMember(name);
        logger.info("当前线程名称：{}",Thread.currentThread().getName());
        return userEntity == null ? "没有找到用户信息" : userEntity.toString();
    }

    /**
     * 没有解决服务雪崩效应
     * @return
     */
    @RequestMapping("/orderToMemberGetUserInfo")
    @Override
    public ResponseBase orderToMemberGetUserInfo() {
        log.info("orderToMemberGetUserInfo beginning!!");
        return memberServiceFeign.getUserInfo();
    }


    /**
     * 解决服务雪崩效应
     *  Hystrix 有两种方式配置保护服务 通过注解和接口形式<br/>
     *  fallbackMethod 方法的作用 ：服务降级执行<br/>
     *  Hystrix默认开启线程池隔离方式，服务降级，服务熔断<br/>
     * @return
     */
    @HystrixCommand(fallbackMethod = "orderToMemberGetUserInfoHystrixFallback")
    @RequestMapping("/orderToMemberGetUserInfoHystrix")
    public ResponseBase orderToMemberGetUserInfoHystrix() {
        log.info("orderToMemberGetUserInfo beginning!!");
        System.out.println("orderToMemberGetUserInfoHystrix 线程池名称 ： " + Thread.currentThread().getName());
        return memberServiceFeign.getUserInfo();
    }


    public ResponseBase orderToMemberGetUserInfoHystrixFallback() {
        return setResultSuccess("返回一个友好的提示。。。。服务降级，服务器忙请稍后重试");
    }

    /**
     * 订单服务接口
     * @return
     */
    @RequestMapping("/orderInfo")
    @Override
    public ResponseBase orderInfo() {
        System.out.println("orderInfo 线程池名称 ： " + Thread.currentThread().getName());
        return setResultSuccess();
    }
}
