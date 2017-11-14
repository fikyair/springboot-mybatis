package com.suixingpay.mybatis.service.controller;

import com.suixingpay.mybatis.core.service.staff.impl.StaffService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by fisherman on 2017/11/10.
 */
@RestController
@RequestMapping("pwd")
@Slf4j
public class ForgetPwdController {

    @Autowired
    private StaffService staffService;

    /**
     * 修改密码
     * @param userName
     * @param newPwdOnce
     * @param newPwdDouble
     * @param request
     * @return
     */
    @ApiOperation(value = "修改密码", notes = "根据用户名、密码、新密码修改密码")
    @RequestMapping(value = "queryPwd/{userName}/{newPwdOnce}/{newPwdDouble}", method = RequestMethod.POST)
    public String updatePwd(@PathVariable("userName") String userName,
                            @PathVariable("newPwdOnce") String newPwdOnce,
                            @PathVariable("newPwdDouble") String newPwdDouble, HttpServletRequest request) {

        log.info("this is v1 修改密码逻辑");
        log.info("this is v1" + request.getRequestURL());


        String result = staffService.updatePwd(userName, newPwdOnce, newPwdDouble);

        if (result.equals("success")) {

            return "修改密码成功！";

        }
        else {

            return "两次密码不一致";
        }

    }

}
