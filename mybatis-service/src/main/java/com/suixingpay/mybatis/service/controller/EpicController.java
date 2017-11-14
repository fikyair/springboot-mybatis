package com.suixingpay.mybatis.service.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suixingpay.mybatis.core.orm.epic.domain.Epic;
import com.suixingpay.mybatis.core.orm.epic.domain.EpicQuery;
import com.suixingpay.mybatis.core.orm.msg.Msg;
import com.suixingpay.mybatis.core.service.epic.impl.EpicService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by fisherman on 2017/11/8.
 */
@Controller
@RequestMapping("epic")
@Slf4j
public class EpicController {

    @Autowired
    private EpicService epicService;

    /**
     * 创建一个史诗
     *
     * @param epic
     * @return
     */
    @ApiOperation(value = "创建一个史诗", notes = "根据Epic对象创建一个史诗")
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Epic epic) {

        epicService.save(epic);

        return "success";
    }

    /**
     * 动态查询接口
     *
     * @param pn
     * @param epicQuery
     * @return
     */

    @ApiOperation(value = "查询史诗页面", notes = "根据史诗对象查询史诗")
    @RequestMapping(value = "epicQuery/{pn}", method = RequestMethod.POST)
    @ResponseBody
    public Msg epicQuery(@PathVariable(value = "pn") Integer pn, EpicQuery epicQuery) {

        log.info("this is v1 动态查询史诗页面逻辑");
        //传入页码，以及每页的大小
        PageHelper.startPage(pn, 5);

        List<EpicQuery> list = epicService.epicQuery(epicQuery);

        PageInfo page = new PageInfo(list, 5);

        return Msg.success().add("pageInfo", page);
    }

/*    *//**
     * 查询结果分页显示
     * @param pn
     * @return
     *//*
    @ApiOperation(value = "查询结果分页显示", notes = "根据页号查询")
    @RequestMapping(value = "epicInfo")
    public PageInfo getEpicWithJson(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {

        //传入页码，以及每页的大小
        PageHelper.startPage(pn, 5);

        List<Epic> epics = epicService.findAllEpic();

        PageInfo page = new PageInfo(epics, 5);

        return page;
    }*/

    /**
     * 史诗详情页面
     *
     * @param epicId
     * @return
     */
    @ApiOperation(value = "史诗详情页面", notes = "根据史诗")
    @RequestMapping(value = "findOneEpic/{epicId}", method = RequestMethod.GET)
    public ModelAndView findOneEpic(@PathVariable(value = "epicId") String epicId, HttpServletRequest request) throws IOException {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("epicInfo");
        List<Epic> listOneEpic = epicService.findOneEpic(epicId);
        request.getSession().setAttribute("epicInfo", listOneEpic.get(0));
        return mv;
    }

    @ApiOperation(value = "更新一条数据", notes = "根据对象来更新")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String updateOne(Epic epic) {

        epicService.update(epic);

        return "success";
    }


}
