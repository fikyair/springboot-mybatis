package com.suixingpay.mybatis.core.orm.staff.po;

import com.suixingpay.mybatis.core.orm.AbstractPo;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by fisherman on 2017/11/7.
 */
public class StaffPo extends AbstractPo {

    private String staffId;

    private String staffName;

    private String sex;

    private String chineseName;

    private String basicRole;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private String email;

    private String  phone;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date hiredate;

    private String status;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modiDate;

    private String operator;

    private String userName;

    private String passWord;
}
