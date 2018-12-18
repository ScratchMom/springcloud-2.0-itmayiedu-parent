package com.itmayiedu.api.service.impl;

import com.itmayiedu.api.entity.UserEntity;
import com.itmayiedu.api.service.IMemberService;
import com.itmayiedu.base.BaseApiService;
import com.itmayiedu.base.ResponseBase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author laowang
 * @date 2018/12/12 7:52 PM
 * @Description:
 */
@Slf4j
@RestController
public class MemberServiceImpl extends BaseApiService implements IMemberService {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/getMember")
    @Override
    public UserEntity getMember(@RequestParam("name") String name) {
        UserEntity userEntity = new UserEntity();
        userEntity.setAge(101);
        userEntity.setName("端口号：" + port + ","+ name);
        return userEntity;
    }
    @RequestMapping("/getUserInfo")
    @Override
    public ResponseBase getUserInfo() {
        // 产生1.5秒延迟
        try {
            log.info("产生1.5秒延迟");
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return setResultSuccess("订单服务接口调用会员服务接口成功......");
    }
}
