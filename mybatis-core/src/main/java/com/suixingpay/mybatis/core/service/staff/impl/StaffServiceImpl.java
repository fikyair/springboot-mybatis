package com.suixingpay.mybatis.core.service.staff.impl;

import com.suixingpay.mybatis.core.orm.staff.domain.Staff;
import com.suixingpay.mybatis.core.orm.staff.domain.StaffQuery;
import com.suixingpay.mybatis.core.orm.staff.mapper.StaffMapper;
import com.suixingpay.mybatis.core.util.UUIDUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fisherman on 2017/11/7.
 */
@Service
@Slf4j
public class StaffService {

    @Autowired
    private StaffMapper staffMapper;

    /**
     * 新增一条数据
     * @param staff
     */
    public void save(Staff staff) {

        staff.setBasicRole(staff.getBasicRole());
        staff.setBirthday(staff.getBirthday());
        staff.setChineseName(staff.getChineseName());
        staff.setCreateDate(staff.getCreateDate());
        staff.setEmail(staff.getEmail());
        staff.setHireDate(staff.getHireDate());
        staff.setModiDate(staff.getModiDate());
        staff.setOperator(staff.getOperator());
        staff.setPhone(staff.getPhone());
        staff.setSex(staff.getSex());
        staff.setStaffId(staff.getStaffId());
        staff.setStaffName(staff.getStaffName());
        staff.setStatus(staff.getStatus());
        staff.setUserName(UUIDUtils.getUUID().substring(1, 4));
        staff.setPassWord(staff.getPassWord());
        staffMapper.save(staff);

    }

    /**
     * 动态查询员工信息
     * @param staff
     * @return
     */
    public List<StaffQuery> dynquery(Staff staff) {

        List<StaffQuery> list = staffMapper.dynquery(staff);

        return list;
    }

    /**
     * 查找全部员工
     * @return
     */
    public List<Staff> findAll() {

        return staffMapper.findAll();
    }

    /**
     * 更新密码逻辑
     * @param userName
     * @param newPwdOnce
     * @param newPwdDouble
     * @return
     */
    public String updatePwd(String userName, String newPwdOnce, String newPwdDouble) {


        //判断两个密码是否相同

        if (newPwdOnce.equals(newPwdDouble)) {

            staffMapper.updatePwd(userName, newPwdOnce);

            return "success";
        }
        else {

            return "fail";
        }
    }
}
