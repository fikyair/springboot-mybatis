package com.example.demo;

import com.suixingpay.mybatis.core.orm.staff.mapper.StaffMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by fisherman on 2017/11/16.
 */
public class StaffImpl implements StaffIn {
    @Autowired
    StaffMapper staffMapper;

    @Override
    public List findAll() {
        return staffMapper.findAll();
    }
}
