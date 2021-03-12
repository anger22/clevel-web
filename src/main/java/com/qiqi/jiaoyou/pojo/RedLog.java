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
 * 
 * </p>
 *
 * @author GR123
 * @since 2020-07-09
 */
@TableName("red_log")
public class RedLog extends Model<RedLog> {

    private static final long serialVersionUID = 1L;

    /**
     * 红包ID
     */
    @TableId(value = "red_log_id", type = IdType.AUTO)
    private Integer redLogId;
    /**
     * 发送人ID
     */
    @TableField("red_log_member_id")
    private Integer redLogMemberId;
    /**
     * 发送人昵称
     */
    @TableField("red_log_member_nick_name")
    private String redLogMemberNickName;
    /**
     * 发送人头像
     */
    @TableField("red_log_member_head")
    private String redLogMemberHead;
    /**
     * 钻石数量
     */
    @TableField("red_log_gold_size")
    private Integer redLogGoldSize;
    /**
     * 红包个数
     */
    @TableField("red_log_red_size")
    private Integer redLogRedSize;
    /**
     * 领取个数
     */
    @TableField("red_log_number_receipts")
    private Integer redLogNumberReceipts;
    /**
     * 剩余个数
     */
    @TableField("red_log_number_remaining")
    private Integer redLogNumberRemaining;
    @TableField("red_log_send_time")
    private Date redLogSendTime;
    @TableField("red_log_end_time")
    private Date redLogEndTime;
    /**
     * 1:只限男 2：只限女 2：不限
     */
    @TableField("red_log_sex")
    private Integer redLogSex;
    /**
     * 备注
     */
    @TableField("red_log_remarks")
    private String redLogRemarks;
    /**
     * 1:一对一  2：一对多
     */
    private Integer type;


    public Integer getRedLogId() {
        return redLogId;
    }

    public RedLog setRedLogId(Integer redLogId) {
        this.redLogId = redLogId;
        return this;
    }

    public Integer getRedLogMemberId() {
        return redLogMemberId;
    }

    public RedLog setRedLogMemberId(Integer redLogMemberId) {
        this.redLogMemberId = redLogMemberId;
        return this;
    }

    public String getRedLogMemberNickName() {
        return redLogMemberNickName;
    }

    public RedLog setRedLogMemberNickName(String redLogMemberNickName) {
        this.redLogMemberNickName = redLogMemberNickName;
        return this;
    }

    public String getRedLogMemberHead() {
        return redLogMemberHead;
    }

    public RedLog setRedLogMemberHead(String redLogMemberHead) {
        this.redLogMemberHead = redLogMemberHead;
        return this;
    }

    public Integer getRedLogGoldSize() {
        return redLogGoldSize;
    }

    public RedLog setRedLogGoldSize(Integer redLogGoldSize) {
        this.redLogGoldSize = redLogGoldSize;
        return this;
    }

    public Integer getRedLogRedSize() {
        return redLogRedSize;
    }

    public RedLog setRedLogRedSize(Integer redLogRedSize) {
        this.redLogRedSize = redLogRedSize;
        return this;
    }

    public Integer getRedLogNumberReceipts() {
        return redLogNumberReceipts;
    }

    public RedLog setRedLogNumberReceipts(Integer redLogNumberReceipts) {
        this.redLogNumberReceipts = redLogNumberReceipts;
        return this;
    }

    public Integer getRedLogNumberRemaining() {
        return redLogNumberRemaining;
    }

    public RedLog setRedLogNumberRemaining(Integer redLogNumberRemaining) {
        this.redLogNumberRemaining = redLogNumberRemaining;
        return this;
    }

    public Date getRedLogSendTime() {
        return redLogSendTime;
    }

    public RedLog setRedLogSendTime(Date redLogSendTime) {
        this.redLogSendTime = redLogSendTime;
        return this;
    }

    public Date getRedLogEndTime() {
        return redLogEndTime;
    }

    public RedLog setRedLogEndTime(Date redLogEndTime) {
        this.redLogEndTime = redLogEndTime;
        return this;
    }

    public Integer getRedLogSex() {
        return redLogSex;
    }

    public RedLog setRedLogSex(Integer redLogSex) {
        this.redLogSex = redLogSex;
        return this;
    }

    public String getRedLogRemarks() {
        return redLogRemarks;
    }

    public RedLog setRedLogRemarks(String redLogRemarks) {
        this.redLogRemarks = redLogRemarks;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public RedLog setType(Integer type) {
        this.type = type;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.redLogId;
    }

    @Override
    public String toString() {
        return "RedLog{" +
        "redLogId=" + redLogId +
        ", redLogMemberId=" + redLogMemberId +
        ", redLogMemberNickName=" + redLogMemberNickName +
        ", redLogMemberHead=" + redLogMemberHead +
        ", redLogGoldSize=" + redLogGoldSize +
        ", redLogRedSize=" + redLogRedSize +
        ", redLogNumberReceipts=" + redLogNumberReceipts +
        ", redLogNumberRemaining=" + redLogNumberRemaining +
        ", redLogSendTime=" + redLogSendTime +
        ", redLogEndTime=" + redLogEndTime +
        ", redLogSex=" + redLogSex +
        ", redLogRemarks=" + redLogRemarks +
        ", type=" + type +
        "}";
    }
}
