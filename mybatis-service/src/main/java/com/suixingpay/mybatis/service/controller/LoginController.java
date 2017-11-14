package com.suixingpay.mybatis.service.controller;

import com.suixingpay.mybatis.core.orm.staff.domain.Staff;
import com.suixingpay.mybatis.core.service.login.impl.LoginService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Random;

/**
 * Created by fisherman on 2017/11/8.
 */
@RestController
@RequestMapping("login")
@Slf4j
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 根据用户名和密码进行登录校验
     *
     * @param userName
     * @param passWord
     * @return
     */
    @ApiOperation(value = "登录校验", notes = "根据用户名、密码校验")
    @RequestMapping(value = "logincheck/{userName}/{passWord}", method = RequestMethod.POST)
    public String loginCheck(@PathVariable(value = "userName") String userName,
                             @PathVariable(value = "passWord") String passWord) {

        List<Staff> result = loginService.loginCheck(userName, passWord);


        if (result.size() > 0) {

            if (result.get(0).getPassWord().equals(passWord)) {

                return "登录成功!";
            } else {

                return "用户名密码错误!";
            }
        } else {
            return "用户名不存在！";
        }
    }


}
