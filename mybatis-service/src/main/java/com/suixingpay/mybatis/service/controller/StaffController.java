package com.suixingpay.mybatis.service.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suixingpay.mybatis.core.orm.msg.Msg;
import com.suixingpay.mybatis.core.orm.staff.domain.Staff;
import com.suixingpay.mybatis.core.orm.staff.domain.StaffQuery;
import com.suixingpay.mybatis.core.service.staff.impl.StaffService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by fisherman on 2017/11/7.
 */
@RestController
@RequestMapping("staff")
@Slf4j
public class StaffController {

    @Autowired
    private StaffService staffService;

    /**
     * 新增一名员工
     *
     * @param staff
     * @param request
     * @return
     */
    @ApiOperation(value = "新增一名员工", notes = "根据Staff对象创建员工")
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String save(Staff staff, HttpServletRequest request) {
        log.info("this is v1 新增一名员工逻辑");
        log.info("this is v1" + request.getRequestURL());

        staffService.save(staff);

        return "success";
    }

    /**
     * 动态查询员工
     * @param pn
     * @param staff
     * @return
     */
    @ApiOperation(value = "动态查询员工", notes = "根据字段查询员工")
    @RequestMapping(value = "dynquery/{pn}", method = RequestMethod.POST)
    public Msg dynquery(@PathVariable(value = "pn") Integer pn,
                        Staff staff) {

        log.info("this is v1 动态查询员工逻辑");

        //传入页码，以及每页的大小
        PageHelper.startPage(pn, 5);

        List<StaffQuery> querylist = staffService.dynquery(staff);

        PageInfo page = new PageInfo(querylist, 5);

        return Msg.success().add("pageInfo", page);
    }

    /**
     * 测试时用来查询全部的员工信息
     * @param pn
     * @return
     */
    @ApiOperation(value = "初次进入显示第一页", notes = "根据pn查询")
    @RequestMapping(value = "staffInfoPage")
    public Msg getEpicWithJson(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {

        //传入页码，以及每页的大小
        PageHelper.startPage(pn, 5);

        List<Staff> epics = staffService.findAll();

        PageInfo page = new PageInfo(epics, 5);

        return Msg.success().add("pageInfo", page);
    }


}
