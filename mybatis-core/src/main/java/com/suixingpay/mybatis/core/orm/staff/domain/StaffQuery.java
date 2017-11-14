package com.suixingpay.mybatis.core.orm.staff.domain;

/**
 * Created by fisherman on 2017/11/9.
 */
public class StaffQuery {

    private String userName;

    private String staffId;

    private String staffName;

    private String basicRole;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getBasicRole() {
        return basicRole;
    }

    public void setBasicRole(String basicRole) {
        this.basicRole = basicRole;
    }
}
