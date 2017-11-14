package com.suixingpay.mybatis.core.orm.epic.po;

import com.suixingpay.mybatis.core.orm.AbstractPo;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by fisherman on 2017/11/8.
 */
public class EpicPo extends AbstractPo {

    private String epicId;

    private String projectName;

    private String questionType;

    private String epicName;

    private String topic;

    private String operationDept;

    private String proposer;

    private String priority;

    @DateTimeFormat(pattern = "yyyy-MM-dd" )
    private Date demandCollDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd" )
    private Date demandAnalStartDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd" )
    private Date demandAnalEndDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createEpicDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modiEpicDate;

    private String reporter;

    private String managers;

    private String descript;

    private String status;
}
