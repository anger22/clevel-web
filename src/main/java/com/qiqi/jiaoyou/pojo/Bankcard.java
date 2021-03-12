package com.qiqi.jiaoyou.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.util.Date;


/**
 * <p>
 * 银行卡表
 * </p>
 *
 * @author GR123
 * @since 2020-07-09
 */
public class Bankcard extends Model<Bankcard> {

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
     * 开户行
     */
    private String openingBank;
    /**
     * 姓名
     */
    private String bankMemberName;
    /**
     * 银行卡号
     */
    private String bankNumber;
    /**
     * 权重
     */
    private Integer weight;
    /**
     * 添加时间
     */
    private Date addTime;
    /**
     * 修改时间
     */
    private Date editTime;


    public Integer getId() {
        return id;
    }

    public Bankcard setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public Bankcard setMemberId(Integer memberId) {
        this.memberId = memberId;
        return this;
    }

    public String getOpeningBank() {
        return openingBank;
    }

    public Bankcard setOpeningBank(String openingBank) {
        this.openingBank = openingBank;
        return this;
    }

    public String getBankMemberName() {
        return bankMemberName;
    }

    public Bankcard setBankMemberName(String bankMemberName) {
        this.bankMemberName = bankMemberName;
        return this;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public Bankcard setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
        return this;
    }

    public Integer getWeight() {
        return weight;
    }

    public Bankcard setWeight(Integer weight) {
        this.weight = weight;
        return this;
    }

    public Date getAddTime() {
        return addTime;
    }

    public Bankcard setAddTime(Date addTime) {
        this.addTime = addTime;
        return this;
    }

    public Date getEditTime() {
        return editTime;
    }

    public Bankcard setEditTime(Date editTime) {
        this.editTime = editTime;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Bankcard{" +
        "id=" + id +
        ", memberId=" + memberId +
        ", openingBank=" + openingBank +
        ", bankMemberName=" + bankMemberName +
        ", bankNumber=" + bankNumber +
        ", weight=" + weight +
        ", addTime=" + addTime +
        ", editTime=" + editTime +
        "}";
    }
}
