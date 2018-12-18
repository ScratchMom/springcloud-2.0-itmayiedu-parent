package com.itmayiedu.api.feign;

import com.itmayiedu.api.service.IMemberService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author laowang
 * @date 2018/12/14 11:13 AM
 * @Description:
 */
@FeignClient("app-itmayiedu-member")
public interface MemberServiceFeign extends IMemberService {

}
