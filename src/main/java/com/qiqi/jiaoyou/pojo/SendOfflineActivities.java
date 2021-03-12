package com.qiqi.jiaoyou.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName("send_offline_activities")
public class SendOfflineActivities extends Model<SendOfflineActivities> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 发起人id
     */
    private Integer sendMemberId;
    /**
     * 发起人用户头像
     */
    private String sendMemberHead;
    /**
     * 昵称
     */
    private String sendMemberNickName;
    /**
     * 发起人性别
     */
    private Integer sendMemberSex;
    /**
     * 发起人年龄
     */
    private Integer sendMemberAge;
    /**
     * 活动主题
     */
    private String activityTheme;
    /**
     * 地点
     */
    private String address;
    /**
     * 平均钻石数量
     */
    private Integer averageDiamondsSize;
    /**
     * 活动人数
     */
    private Integer perSize;
    /**
     * 发起时间
     */
    private Date addTime;
    /**
     * 开始时间
     */
    private Date startTime;
    /**
     * 状态 1  待报名 2 待对方确认3待自己确认4审核中5审核通过6审核未通过
     */
    private Integer state;
    /**
     * 原因
     */
    private String reason;
    /**
     * 标签
     */
    private String lable;

    @TableField("backgroundImages")
    private String backgroundImages;

    public String getBackgroundImages()
    {
	  return backgroundImages;
    }

    public void setBackgroundImages(String backgroundImages)
    {
	  this.backgroundImages = backgroundImages;
    }

    public Integer getId() {
        return id;
    }

    public SendOfflineActivities setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getSendMemberId() {
        return sendMemberId;
    }

    public SendOfflineActivities setSendMemberId(Integer sendMemberId) {
        this.sendMemberId = sendMemberId;
        return this;
    }

    public String getSendMemberHead() {
        return sendMemberHead;
    }

    public SendOfflineActivities setSendMemberHead(String sendMemberHead) {
        this.sendMemberHead = sendMemberHead;
        return this;
    }

    public String getSendMemberNickName() {
        return sendMemberNickName;
    }

    public SendOfflineActivities setSendMemberNickName(String sendMemberNickName) {
        this.sendMemberNickName = sendMemberNickName;
        return this;
    }

    public Integer getSendMemberSex() {
        return sendMemberSex;
    }

    public SendOfflineActivities setSendMemberSex(Integer sendMemberSex) {
        this.sendMemberSex = sendMemberSex;
        return this;
    }

    public Integer getSendMemberAge() {
        return sendMemberAge;
    }

    public SendOfflineActivities setSendMemberAge(Integer sendMemberAge) {
        this.sendMemberAge = sendMemberAge;
        return this;
    }

    public String getActivityTheme() {
        return activityTheme;
    }

    public SendOfflineActivities setActivityTheme(String activityTheme) {
        this.activityTheme = activityTheme;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public SendOfflineActivities setAddress(String address) {
        this.address = address;
        return this;
    }

    public Integer getAverageDiamondsSize() {
        return averageDiamondsSize;
    }

    public SendOfflineActivities setAverageDiamondsSize(Integer averageDiamondsSize) {
        this.averageDiamondsSize = averageDiamondsSize;
        return this;
    }

    public Integer getPerSize() {
        return perSize;
    }

    public SendOfflineActivities setPerSize(Integer perSize) {
        this.perSize = perSize;
        return this;
    }

    public Date getAddTime() {
        return addTime;
    }

    public SendOfflineActivities setAddTime(Date addTime) {
        this.addTime = addTime;
        return this;
    }

    public Date getStartTime() {
        return startTime;
    }

    public SendOfflineActivities setStartTime(Date startTime) {
        this.startTime = startTime;
        return this;
    }

    public Integer getState() {
        return state;
    }

    public SendOfflineActivities setState(Integer state) {
        this.state = state;
        return this;
    }

    public String getReason() {
        return reason;
    }

    public SendOfflineActivities setReason(String reason) {
        this.reason = reason;
        return this;
    }

    public String getLable() {
        return lable;
    }

    public SendOfflineActivities setLable(String lable) {
        this.lable = lable;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "SendOfflineActivities{" +
        "id=" + id +
        ", sendMemberId=" + sendMemberId +
        ", sendMemberHead=" + sendMemberHead +
        ", sendMemberNickName=" + sendMemberNickName +
        ", sendMemberSex=" + sendMemberSex +
        ", sendMemberAge=" + sendMemberAge +
        ", activityTheme=" + activityTheme +
        ", address=" + address +
        ", averageDiamondsSize=" + averageDiamondsSize +
        ", perSize=" + perSize +
        ", addTime=" + addTime +
        ", startTime=" + startTime +
        ", state=" + state +
        ", reason=" + reason +
        ", lable=" + lable +
        "}";
    }
}
