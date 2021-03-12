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
 * 意见表
 * </p>
 *
 * @author GR123
 * @since 2020-07-09
 */
public class Opinion extends Model<Opinion> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 会员id
     */
    private Integer memberId;
    /**
     * 会员昵称
     */
    private String memberName;
    /**
     * 会员头像
     */
    private String memberHead;
    /**
     * 会员手机号
     */
    private String memberPhone;
    /**
     * 反馈内容
     */
    private String context;
    /**
     * 反馈图片
     */
    private String images;
    /**
     * 反馈时间
     */
    private Date addTime;
    /**
     * 处理状态 1:已处理2:未处理
     */
    private Integer state;
    /**
     * 处理意见
     */
    private String reason;
    /**
     * 处理时间
     */
    private Date handleTime;


    public Integer getId() {
        return id;
    }

    public Opinion setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public Opinion setMemberId(Integer memberId) {
        this.memberId = memberId;
        return this;
    }

    public String getMemberName() {
        return memberName;
    }

    public Opinion setMemberName(String memberName) {
        this.memberName = memberName;
        return this;
    }

    public String getMemberHead() {
        return memberHead;
    }

    public Opinion setMemberHead(String memberHead) {
        this.memberHead = memberHead;
        return this;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public Opinion setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
        return this;
    }

    public String getContext() {
        return context;
    }

    public Opinion setContext(String context) {
        this.context = context;
        return this;
    }

    public String getImages() {
        return images;
    }

    public Opinion setImages(String images) {
        this.images = images;
        return this;
    }

    public Date getAddTime() {
        return addTime;
    }

    public Opinion setAddTime(Date addTime) {
        this.addTime = addTime;
        return this;
    }

    public Integer getState() {
        return state;
    }

    public Opinion setState(Integer state) {
        this.state = state;
        return this;
    }

    public String getReason() {
        return reason;
    }

    public Opinion setReason(String reason) {
        this.reason = reason;
        return this;
    }

    public Date getHandleTime() {
        return handleTime;
    }

    public Opinion setHandleTime(Date handleTime) {
        this.handleTime = handleTime;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Opinion{" +
        "id=" + id +
        ", memberId=" + memberId +
        ", memberName=" + memberName +
        ", memberHead=" + memberHead +
        ", memberPhone=" + memberPhone +
        ", context=" + context +
        ", images=" + images +
        ", addTime=" + addTime +
        ", state=" + state +
        ", reason=" + reason +
        ", handleTime=" + handleTime +
        "}";
    }
}
