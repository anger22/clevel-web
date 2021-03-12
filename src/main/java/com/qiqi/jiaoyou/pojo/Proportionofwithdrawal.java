package com.qiqi.jiaoyou.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
 * <p>
 * 提现比例表
 * </p>
 *
 * @author GR123
 * @since 2020-07-09
 */
public class Proportionofwithdrawal extends Model<Proportionofwithdrawal> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 分享人数
     */
    private Integer numberOfParticipants;
    /**
     * 礼物价值
     */
    private BigDecimal giftCost;
    /**
     * 对应比例
     */
    private BigDecimal proportion;
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

    public Proportionofwithdrawal setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public Proportionofwithdrawal setNumberOfParticipants(Integer numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
        return this;
    }

    public BigDecimal getGiftCost() {
        return giftCost;
    }

    public void setGiftCost(BigDecimal giftCost) {
        this.giftCost = giftCost;
    }

    public BigDecimal getProportion() {
        return proportion;
    }

    public Proportionofwithdrawal setProportion(BigDecimal proportion) {
        this.proportion = proportion;
        return this;
    }

    public Date getAddTime() {
        return addTime;
    }

    public Proportionofwithdrawal setAddTime(Date addTime) {
        this.addTime = addTime;
        return this;
    }

    public Date getEditTime() {
        return editTime;
    }

    public Proportionofwithdrawal setEditTime(Date editTime) {
        this.editTime = editTime;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Proportionofwithdrawal{" +
        "id=" + id +
        ", numberOfParticipants=" + numberOfParticipants +
        ", proportion=" + proportion +
        ", addTime=" + addTime +
        ", editTime=" + editTime +
        "}";
    }
}
