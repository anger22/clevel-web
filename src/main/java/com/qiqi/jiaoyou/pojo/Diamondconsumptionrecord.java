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
 * 钻石消费记录
 * </p>
 *
 * @author GR123
 * @since 2020-07-09
 */
public class Diamondconsumptionrecord extends Model<Diamondconsumptionrecord> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 接收方会员ID
     */
    private Integer memberId;
    /**
     * 发送方会员ID
     */
    private Integer sendMemberId;
    /**
     * 类型 1：红包 2： 购买礼物
     */
    private Integer type;
    /**
     * 消费时间
     */
    private Date consumptionTime;
    /**
     * 消费数量
     */
    private Long consumptionSize;
    /**
     * 剩余数量
     */
    private Long surplusSzie;


    public Integer getId() {
        return id;
    }

    public Diamondconsumptionrecord setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public Diamondconsumptionrecord setMemberId(Integer memberId) {
        this.memberId = memberId;
        return this;
    }

    public Integer getSendMemberId() {
        return sendMemberId;
    }

    public Diamondconsumptionrecord setSendMemberId(Integer sendMemberId) {
        this.sendMemberId = sendMemberId;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public Diamondconsumptionrecord setType(Integer type) {
        this.type = type;
        return this;
    }

    public Date getConsumptionTime() {
        return consumptionTime;
    }

    public Diamondconsumptionrecord setConsumptionTime(Date consumptionTime) {
        this.consumptionTime = consumptionTime;
        return this;
    }

    public Long getConsumptionSize() {
        return consumptionSize;
    }

    public Diamondconsumptionrecord setConsumptionSize(Long consumptionSize) {
        this.consumptionSize = consumptionSize;
        return this;
    }

    public Long getSurplusSzie() {
        return surplusSzie;
    }

    public Diamondconsumptionrecord setSurplusSzie(Long surplusSzie) {
        this.surplusSzie = surplusSzie;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Diamondconsumptionrecord{" +
        "id=" + id +
        ", memberId=" + memberId +
        ", sendMemberId=" + sendMemberId +
        ", type=" + type +
        ", consumptionTime=" + consumptionTime +
        ", consumptionSize=" + consumptionSize +
        ", surplusSzie=" + surplusSzie +
        "}";
    }
}
