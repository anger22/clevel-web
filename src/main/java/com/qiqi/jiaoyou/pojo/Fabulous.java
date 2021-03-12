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
 * 
 * </p>
 *
 * @author GR123
 * @since 2020-07-09
 */
public class Fabulous extends Model<Fabulous> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "fabulousId", type = IdType.AUTO)
    private Integer fabulousId;
    /**
     * 会员ID
     */
    private Integer memberId;
    /**
     * 动态id
     */
    private Integer dynamicId;
    /**
     * 动态类型 1：朋友圈动态 2：车友圈动态
     */
    private Integer type;
    /**
     * 点赞时间
     */
    private Date addTime;


    public Integer getFabulousId() {
        return fabulousId;
    }

    public Fabulous setFabulousId(Integer fabulousId) {
        this.fabulousId = fabulousId;
        return this;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public Fabulous setMemberId(Integer memberId) {
        this.memberId = memberId;
        return this;
    }

    public Integer getDynamicId() {
        return dynamicId;
    }

    public Fabulous setDynamicId(Integer dynamicId) {
        this.dynamicId = dynamicId;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public Fabulous setType(Integer type) {
        this.type = type;
        return this;
    }

    public Date getAddTime() {
        return addTime;
    }

    public Fabulous setAddTime(Date addTime) {
        this.addTime = addTime;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.fabulousId;
    }

    @Override
    public String toString() {
        return "Fabulous{" +
        "fabulousId=" + fabulousId +
        ", memberId=" + memberId +
        ", dynamicId=" + dynamicId +
        ", type=" + type +
        ", addTime=" + addTime +
        "}";
    }
}
