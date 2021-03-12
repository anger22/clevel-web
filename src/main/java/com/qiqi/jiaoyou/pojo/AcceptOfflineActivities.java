package com.qiqi.jiaoyou.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 线下活动列表
 * </p>
 *
 * @author GR123
 * @since 2020-07-09
 */
@TableName("accept_offline_activities")
public class AcceptOfflineActivities extends Model<AcceptOfflineActivities> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 聚会ID
     */
    private Integer sendOfflineActivities;
    /**
     * 接收人id
     */
    private Integer acceptMemberId;
    /**
     * 接收人用户头像
     */
    private String acceptMemberHead;
    /**
     * 接收人昵称
     */
    private String acceptMemberNickName;
    /**
     * 接收人性别
     */
    private Integer acceptMemberSex;
    /**
     * 接收人年龄
     */
    private Integer acceptMemberAge;
    /**
     * 赴约时间
     */
    private Date keepAnAppointmentTime;
    /**
     * 状态  1：已申请赴约 待发起方审核
        2：发起方通过 赴约申请
        3：已到达赴约地点
     */
    private Integer keepAnAppointmentState;

    private Integer closeType;

    @Override
    public String toString() {
        return "AcceptOfflineActivities{" +
                "id=" + id +
                ", sendOfflineActivities=" + sendOfflineActivities +
                ", acceptMemberId=" + acceptMemberId +
                ", acceptMemberHead='" + acceptMemberHead + '\'' +
                ", acceptMemberNickName='" + acceptMemberNickName + '\'' +
                ", acceptMemberSex=" + acceptMemberSex +
                ", acceptMemberAge=" + acceptMemberAge +
                ", keepAnAppointmentTime=" + keepAnAppointmentTime +
                ", keepAnAppointmentState=" + keepAnAppointmentState +
                ", closeType=" + closeType +
                '}';
    }

    public Integer getCloseType() {
        return closeType;
    }

    public void setCloseType(Integer closeType) {
        this.closeType = closeType;
    }

    public Integer getId() {
        return id;
    }

    public AcceptOfflineActivities setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getSendOfflineActivities() {
        return sendOfflineActivities;
    }

    public AcceptOfflineActivities setSendOfflineActivities(Integer sendOfflineActivities) {
        this.sendOfflineActivities = sendOfflineActivities;
        return this;
    }

    public Integer getAcceptMemberId() {
        return acceptMemberId;
    }

    public AcceptOfflineActivities setAcceptMemberId(Integer acceptMemberId) {
        this.acceptMemberId = acceptMemberId;
        return this;
    }

    public String getAcceptMemberHead() {
        return acceptMemberHead;
    }

    public AcceptOfflineActivities setAcceptMemberHead(String acceptMemberHead) {
        this.acceptMemberHead = acceptMemberHead;
        return this;
    }

    public String getAcceptMemberNickName() {
        return acceptMemberNickName;
    }

    public AcceptOfflineActivities setAcceptMemberNickName(String acceptMemberNickName) {
        this.acceptMemberNickName = acceptMemberNickName;
        return this;
    }

    public Integer getAcceptMemberSex() {
        return acceptMemberSex;
    }

    public AcceptOfflineActivities setAcceptMemberSex(Integer acceptMemberSex) {
        this.acceptMemberSex = acceptMemberSex;
        return this;
    }

    public Integer getAcceptMemberAge() {
        return acceptMemberAge;
    }

    public AcceptOfflineActivities setAcceptMemberAge(Integer acceptMemberAge) {
        this.acceptMemberAge = acceptMemberAge;
        return this;
    }

    public Date getKeepAnAppointmentTime() {
        return keepAnAppointmentTime;
    }

    public AcceptOfflineActivities setKeepAnAppointmentTime(Date keepAnAppointmentTime) {
        this.keepAnAppointmentTime = keepAnAppointmentTime;
        return this;
    }

    public Integer getKeepAnAppointmentState() {
        return keepAnAppointmentState;
    }

    public AcceptOfflineActivities setKeepAnAppointmentState(Integer keepAnAppointmentState) {
        this.keepAnAppointmentState = keepAnAppointmentState;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
