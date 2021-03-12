package com.qiqi.jiaoyou.pojo;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 提现申请表
 * </p>
 *
 * @author GR123
 * @since 2020-07-09
 */
public class Withdraw extends Model<Withdraw> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 会员ID
     */
    private Integer memberId;
    /**
     * 昵称
     */
    private String memberNickName;
    /**
     * 头像
     */
    private String memberHead;
    /**
     * 手机号
     */
    private String memberPhone;
    /**
     * 提现金额
     */
    private BigDecimal price;
    /**
     * 开户行
     */
    private String bankName;
    /**
     * 姓名
     */
    private String bankMemberName;
    /**
     * 卡号
     */
    private String bankNumber;
    /**
     * 申请时间
     */
    private Date applyTime;
    /**
     * 原因
     */
    private String reason;
    /**
     * 审核时间
     */
    private Date examineTime;
    /**
     * 审核状态 1:通过2:不通过3:待审核
     */
    private Integer examineState;
    /**
     * 余额
     */
    private BigDecimal balance;
    /**
     * 1：提现记录  2：失败后返现记录
     */
    private Integer oldOrNew;
    /**
     * 1:审核过  2：待审核
     */
    private Integer isExamine;


    private BigDecimal proportion;

    public BigDecimal getProportion() {
        return proportion;
    }

    public void setProportion(BigDecimal proportion) {
        this.proportion = proportion;
    }

    public Integer getId() {
        return id;
    }

    public Withdraw setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public Withdraw setMemberId(Integer memberId) {
        this.memberId = memberId;
        return this;
    }

    public String getMemberNickName() {
        return memberNickName;
    }

    public Withdraw setMemberNickName(String memberNickName) {
        this.memberNickName = memberNickName;
        return this;
    }

    public String getMemberHead() {
        return memberHead;
    }

    public Withdraw setMemberHead(String memberHead) {
        this.memberHead = memberHead;
        return this;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public Withdraw setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Withdraw setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getBankName() {
        return bankName;
    }

    public Withdraw setBankName(String bankName) {
        this.bankName = bankName;
        return this;
    }

    public String getBankMemberName() {
        return bankMemberName;
    }

    public Withdraw setBankMemberName(String bankMemberName) {
        this.bankMemberName = bankMemberName;
        return this;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public Withdraw setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
        return this;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public Withdraw setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
        return this;
    }

    public String getReason() {
        return reason;
    }

    public Withdraw setReason(String reason) {
        this.reason = reason;
        return this;
    }

    public Date getExamineTime() {
        return examineTime;
    }

    public Withdraw setExamineTime(Date examineTime) {
        this.examineTime = examineTime;
        return this;
    }

    public Integer getExamineState() {
        return examineState;
    }

    public Withdraw setExamineState(Integer examineState) {
        this.examineState = examineState;
        return this;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Withdraw setBalance(BigDecimal balance) {
        this.balance = balance;
        return this;
    }

    public Integer getOldOrNew() {
        return oldOrNew;
    }

    public Withdraw setOldOrNew(Integer oldOrNew) {
        this.oldOrNew = oldOrNew;
        return this;
    }

    public Integer getIsExamine() {
        return isExamine;
    }

    public Withdraw setIsExamine(Integer isExamine) {
        this.isExamine = isExamine;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Withdraw{" +
        "id=" + id +
        ", memberId=" + memberId +
        ", memberNickName=" + memberNickName +
        ", memberHead=" + memberHead +
        ", memberPhone=" + memberPhone +
        ", price=" + price +
        ", bankName=" + bankName +
        ", bankMemberName=" + bankMemberName +
        ", bankNumber=" + bankNumber +
        ", applyTime=" + applyTime +
        ", reason=" + reason +
        ", examineTime=" + examineTime +
        ", examineState=" + examineState +
        ", balance=" + balance +
        ", oldOrNew=" + oldOrNew +
        ", isExamine=" + isExamine +
        "}";
    }
}
