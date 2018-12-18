package com.itmayiedu.api.service;

import com.itmayiedu.base.ResponseBase;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author laowang
 * @date 2018/12/14 10:25 AM
 * @Description:
 */
public interface IOrderService {

    /**
     * 订单服务调用会员服务接口信息feign
     *
     * @param name
     * @return
     */
    @RequestMapping("orderToMember")
    public String orderToMember(String name);


    /**
     * 订单服务调用会员服务接口信息feign
     * @return
     */
    @RequestMapping("orderToMemberGetUserInfo")
    public ResponseBase orderToMemberGetUserInfo();


    /**
     * 订单服务接口
     * @return
     */
    @RequestMapping("orderInfo")
    public ResponseBase orderInfo();
}
