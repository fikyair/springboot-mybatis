package com.suixingpay.mybatis.core.service.login.impl;

import com.suixingpay.mybatis.core.orm.staff.domain.Staff;
import com.suixingpay.mybatis.core.orm.staff.mapper.StaffMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fisherman on 2017/11/8.
 */
@Service
@Slf4j
public class LoginService {

    @Autowired
    private StaffMapper staffMapper;

    /**
     * 登录校验
     *
     * @param userName
     * @return
     */
    public List<Staff> loginCheck(String userName, String passWord) {

        List<Staff> reslutList = staffMapper.loginCheck(userName, passWord);


        return reslutList;

    }


}
