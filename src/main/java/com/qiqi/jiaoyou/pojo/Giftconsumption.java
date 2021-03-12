package com.qiqi.jiaoyou.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 礼物记录表
 * </p>
 *
 * @author GR123
 * @since 2020-07-09
 */
public class Giftconsumption extends Model<Giftconsumption> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "REVISION", type = IdType.AUTO)
    private Integer revision;
    /**
     * 接收方ID
     */
    private Integer memberId;
    /**
     * 发送方id
     */
    private Integer sendMemberId;
    /**
     * 发送方头像
     */
    private String sendMemberHead;
    /**
     * 发送方昵称
     */
    private String sendMemberNickName;
    /**
     * 礼物ID
     */
    private Integer giftId;
    /**
     * 礼物图片
     */
    private String giftImages;
    /**
     * 礼物名称
     */
    private String giftName;
    /**
     * 礼物数量
     */
    private Integer giftSize;
    /**
     * 发送时间
     */
    private Date addTime;
    /**
     * 该礼物是否被接收方提现
     */
    private Integer drawInProportion;
    /**
     * 申请提现时间
     */
    private Date withdrawTime;


    public Integer getRevision() {
        return revision;
    }

    public Giftconsumption setRevision(Integer revision) {
        this.revision = revision;
        return this;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public Giftconsumption setMemberId(Integer memberId) {
        this.memberId = memberId;
        return this;
    }

    public Integer getSendMemberId() {
        return sendMemberId;
    }

    public Giftconsumption setSendMemberId(Integer sendMemberId) {
        this.sendMemberId = sendMemberId;
        return this;
    }

    public String getSendMemberHead() {
        return sendMemberHead;
    }

    public Giftconsumption setSendMemberHead(String sendMemberHead) {
        this.sendMemberHead = sendMemberHead;
        return this;
    }

    public String getSendMemberNickName() {
        return sendMemberNickName;
    }

    public Giftconsumption setSendMemberNickName(String sendMemberNickName) {
        this.sendMemberNickName = sendMemberNickName;
        return this;
    }

    public Integer getGiftId() {
        return giftId;
    }

    public Giftconsumption setGiftId(Integer giftId) {
        this.giftId = giftId;
        return this;
    }

    public String getGiftImages() {
        return giftImages;
    }

    public Giftconsumption setGiftImages(String giftImages) {
        this.giftImages = giftImages;
        return this;
    }

    public String getGiftName() {
        return giftName;
    }

    public Giftconsumption setGiftName(String giftName) {
        this.giftName = giftName;
        return this;
    }

    public Integer getGiftSize() {
        return giftSize;
    }

    public Giftconsumption setGiftSize(Integer giftSize) {
        this.giftSize = giftSize;
        return this;
    }

    public Date getAddTime() {
        return addTime;
    }

    public Giftconsumption setAddTime(Date addTime) {
        this.addTime = addTime;
        return this;
    }

    public Integer getDrawInProportion() {
        return drawInProportion;
    }

    public Giftconsumption setDrawInProportion(Integer drawInProportion) {
        this.drawInProportion = drawInProportion;
        return this;
    }

    public Date getWithdrawTime() {
        return withdrawTime;
    }

    public Giftconsumption setWithdrawTime(Date withdrawTime) {
        this.withdrawTime = withdrawTime;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.revision;
    }

    @Override
    public String toString() {
        return "Giftconsumption{" +
        "revision=" + revision +
        ", memberId=" + memberId +
        ", sendMemberId=" + sendMemberId +
        ", sendMemberHead=" + sendMemberHead +
        ", sendMemberNickName=" + sendMemberNickName +
        ", giftId=" + giftId +
        ", giftImages=" + giftImages +
        ", giftName=" + giftName +
        ", giftSize=" + giftSize +
        ", addTime=" + addTime +
        ", drawInProportion=" + drawInProportion +
        ", withdrawTime=" + withdrawTime +
        "}";
    }
}
