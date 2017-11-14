package com.suixingpay.mybatis.core.orm.staff.domain;

import com.suixingpay.common.core.orm.domain.Domain;
import com.suixingpay.mybatis.core.orm.staff.po.StaffPo;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by fisherman on 2017/11/8.
 */
@Data
public class Staff extends StaffPo implements Domain {

    private String staffId;

    private String staffName;

    private String sex;

    private String chineseName;

    private String basicRole;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date  birthday;

    private String email;

    private String  phone;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date hireDate;

    private String status;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modiDate;

    private String operator;

    private String userName;

    private String passWord;
}
