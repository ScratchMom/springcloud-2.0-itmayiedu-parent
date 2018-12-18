package com.itmayiedu.api.service;

import com.itmayiedu.api.entity.UserEntity;
import com.itmayiedu.base.ResponseBase;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author laowang
 * @date 2018/12/12 7:39 PM
 * @Description:
 */
public interface IMemberService {

    @RequestMapping("/getMember")
    public UserEntity getMember(@RequestParam("name") String name) ;

    @RequestMapping("/getUserInfo")
    public ResponseBase getUserInfo();
}
