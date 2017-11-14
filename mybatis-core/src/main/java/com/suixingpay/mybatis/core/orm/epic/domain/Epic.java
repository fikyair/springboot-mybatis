package com.suixingpay.mybatis.core.orm.epic.domain;

import com.suixingpay.common.core.orm.domain.Domain;
import com.suixingpay.mybatis.core.orm.epic.po.EpicPo;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by fisherman on 2017/11/8.
 */
@Data
public class Epic extends EpicPo implements Domain {



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

    private String createEpicDate;

    private String modiEpicDate;

    private String reporter;

    private String managers;

    private String descript;

    private String status;
}
