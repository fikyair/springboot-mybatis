package com.suixingpay.mybatis.core.orm.staff.mapper;

import com.suixingpay.mybatis.core.orm.staff.domain.Staff;
import com.suixingpay.mybatis.core.orm.staff.domain.StaffQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by fisherman on 2017/11/8.
 */
public interface StaffMapper {

    void save(Staff staff);

    List<Staff> loginCheck(@Param(value = "userName") String userName
            , @Param(value = "passWord") String passWord);

    List<StaffQuery> dynquery(Staff staff);

    List<Staff> findAll();


    void updatePwd(String userName ,String passWord);
}
