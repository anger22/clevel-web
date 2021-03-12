package com.qiqi.jiaoyou.common.status_code;

public enum Status {
    /*已申请赴约*/
    APPLY(1, "已申请赴约"),
    /*发起方通过*/
    NOTIFIED(2, "发起方通过"),
    /*已到达*/
    ARRIVE(3, "已到达"),
    /*待审核*/
    TOAUDIT(4, "取消赴约待审核"),
    /*已取消*/
    CANCELED(5, "已取消"),
    /*已拒绝*/
    REFUSE(6, "拒绝取消");


    public int status;
    public String name;
    Status(int status, String name) {
        this.status = status;
        this.name = name;
    }
}
