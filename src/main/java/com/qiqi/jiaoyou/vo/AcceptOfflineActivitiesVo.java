package com.qiqi.jiaoyou.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qiqi.jiaoyou.common.status_code.Status;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class AcceptOfflineActivitiesVo implements Serializable {
    private static final long serialVersionUID = 8699987045217860167L;
    /*申请取消ID*/
    private Integer id;
    /*用户头像*/
    private String head;
    /*用户昵称*/
    private String nickName;
    /*用户手机号*/
    private String phone;
    /*活动主题*/
    private String activityTheme;
    /*开始时间*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    /*聚会地点*/
    private String address;
    /*邀请人数*/
    private Integer perSize;
    /*活动奖励*/
    private String averageDiamondsSize;
    /*申请时间*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date keepAnAppointmentTime;
    /*审核状态码*/
    private Integer keepAnAppointmentState;
    /*审核状态*/
    private String statusName;

    public void setKeepAnAppointmentState(Integer keepAnAppointmentState) {
        this.keepAnAppointmentState = keepAnAppointmentState;
        if(keepAnAppointmentState == Status.APPLY.status){
            /*已申请赴约*/
            statusName = Status.APPLY.name;
        }else if(keepAnAppointmentState == Status.NOTIFIED.status){
            /*已通过*/
            statusName = Status.NOTIFIED.name;
        }else if(keepAnAppointmentState == Status.ARRIVE.status){
            /*已到达*/
            statusName = Status.ARRIVE.name;
        }else if(keepAnAppointmentState == Status.TOAUDIT.status){
            /*待审核*/
            statusName = Status.TOAUDIT.name;
        }else if(keepAnAppointmentState == Status.CANCELED.status){
            /*已取消*/
            statusName = Status.CANCELED.name;
        }else if(keepAnAppointmentState == Status.REFUSE.status){
            /*已拒绝*/
            statusName = Status.REFUSE.name;
        }
    }
}
