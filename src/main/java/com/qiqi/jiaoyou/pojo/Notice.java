package com.qiqi.jiaoyou.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;
/**
 * <p>
 * 公告表
 * </p>
 *
 * @author GR123
 * @since 2020-07-09
 */
public class Notice extends Model<Notice> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    //id
    private Integer id;
    //昵称
    private String nickname;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getShenqingid() {
        return shenqingid;
    }

    public void setShenqingid(Integer shenqingid) {
        this.shenqingid = shenqingid;
    }

    public String getReadmembers() {
        return readmembers;
    }

    public void setReadmembers(String readmembers) {
        this.readmembers = readmembers;
    }

    public String getMemberIds() {
        return memberIds;
    }

    public void setMemberIds(String memberIds) {
        this.memberIds = memberIds;
    }

    //申请的ID
    private Integer shenqingid;
    //已读会员数组
    private String readmembers;
    //发送的会员数组
    private String memberIds;
    /**
     * 报名人员id
     */
    @TableField("member_id")
    private Integer memberId;
    /**
     * 头像
     */
    private String head;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 性别 1 :男  2：女
     */
    private Integer sex;
    /**
     * 申请时间
     */
    @TableField("shenqing_time")
    private Date shenqingTime;
    /**
     * 到场时间
     */
    @TableField("daochang_time")
    private Date daochangTime;
    /**
     * 聚会主题
     */
    private String title;
    /**
     * 限制人数
     */
    @TableField("per_size")
    private Integer perSize;
    /**
     * 开始时间
     */
    @TableField("start_time")
    private Date startTime;
    /**
     * 地址
     */
    private String address;
    /**
     * 发起聚会人员ID
     */
    @TableField("of_member")
    private Integer ofMember;
    private String context;
    /**
     * 1：普通公告  2：聚会
     */
    private Integer type;
    @TableField("add_time")
    private Date addTime;
    /**
     * 申请的ID
     */
    private Integer shenqingId;


    public Integer getId() {
        return id;
    }

    public Notice setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public Notice setMemberId(Integer memberId) {
        this.memberId = memberId;
        return this;
    }

    public String getHead() {
        return head;
    }

    public Notice setHead(String head) {
        this.head = head;
        return this;
    }

    public String getNickName() {
        return nickName;
    }

    public Notice setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public Integer getSex() {
        return sex;
    }

    public Notice setSex(Integer sex) {
        this.sex = sex;
        return this;
    }

    public Date getShenqingTime() {
        return shenqingTime;
    }

    public Notice setShenqingTime(Date shenqingTime) {
        this.shenqingTime = shenqingTime;
        return this;
    }

    public Date getDaochangTime() {
        return daochangTime;
    }

    public Notice setDaochangTime(Date daochangTime) {
        this.daochangTime = daochangTime;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Notice setTitle(String title) {
        this.title = title;
        return this;
    }

    public Integer getPerSize() {
        return perSize;
    }

    public Notice setPerSize(Integer perSize) {
        this.perSize = perSize;
        return this;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Notice setStartTime(Date startTime) {
        this.startTime = startTime;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Notice setAddress(String address) {
        this.address = address;
        return this;
    }

    public Integer getOfMember() {
        return ofMember;
    }

    public Notice setOfMember(Integer ofMember) {
        this.ofMember = ofMember;
        return this;
    }

    public String getContext() {
        return context;
    }

    public Notice setContext(String context) {
        this.context = context;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public Notice setType(Integer type) {
        this.type = type;
        return this;
    }

    public Date getAddTime() {
        return addTime;
    }

    public Notice setAddTime(Date addTime) {
        this.addTime = addTime;
        return this;
    }

    public Integer getShenqingId() {
        return shenqingId;
    }

    public Notice setShenqingId(Integer shenqingId) {
        this.shenqingId = shenqingId;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", shenqingid=" + shenqingid +
                ", readmembers='" + readmembers + '\'' +
                ", memberIds='" + memberIds + '\'' +
                ", memberId=" + memberId +
                ", head='" + head + '\'' +
                ", nickName='" + nickName + '\'' +
                ", sex=" + sex +
                ", shenqingTime=" + shenqingTime +
                ", daochangTime=" + daochangTime +
                ", title='" + title + '\'' +
                ", perSize=" + perSize +
                ", startTime=" + startTime +
                ", address='" + address + '\'' +
                ", ofMember=" + ofMember +
                ", context='" + context + '\'' +
                ", type=" + type +
                ", addTime=" + addTime +
                ", shenqingId=" + shenqingId +
                '}';
    }
}
