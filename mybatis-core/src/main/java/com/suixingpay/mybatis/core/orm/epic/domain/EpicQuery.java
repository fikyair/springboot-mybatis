package com.suixingpay.mybatis.core.orm.epic.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by fisherman on 2017/11/9.
 */
public class EpicQuery {

    private String epicId;

    private String proposer;

    private String topic;

    @DateTimeFormat(pattern = "yyyy-MM-dd " )
    private Date demandCollDateStart;

    @DateTimeFormat(pattern = "yyyy/MM/dd" )
    private Date demandCollDateEnd;

    @DateTimeFormat(pattern = "yyyy-MM-dd" )
    private Date demandAnalStartDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd" )
    private Date demandAnalEndDate;

    private String status;

    public String getEpicId() {
        return epicId;
    }

    public void setEpicId(String epicId) {
        this.epicId = epicId;
    }

    public String getProposer() {
        return proposer;
    }

    public void setProposer(String proposer) {
        this.proposer = proposer;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Date getDemandCollDateStart() {
        return demandCollDateStart;
    }

    public void setDemandCollDateStart(Date demandCollDateStart) {
        this.demandCollDateStart = demandCollDateStart;
    }

    public Date getDemandCollDateEnd() {
        return demandCollDateEnd;
    }

    public void setDemandCollDateEnd(Date demandCollDateEnd) {
        this.demandCollDateEnd = demandCollDateEnd;
    }

    public Date getDemandAnalStartDate() {
        return demandAnalStartDate;
    }

    public void setDemandAnalStartDate(Date demandAnalStartDate) {
        this.demandAnalStartDate = demandAnalStartDate;
    }

    public Date getDemandAnalEndDate() {
        return demandAnalEndDate;
    }

    public void setDemandAnalEndDate(Date demandAnalEndDate) {
        this.demandAnalEndDate = demandAnalEndDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
