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
 * 喇叭消费记录
 * </p>
 *
 * @author GR123
 * @since 2020-07-09
 */
public class Speakerconsumptionrecord extends Model<Speakerconsumptionrecord> {

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
    private Long surplusSize;


    public Integer getId() {
        return id;
    }

    public Speakerconsumptionrecord setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public Speakerconsumptionrecord setMemberId(Integer memberId) {
        this.memberId = memberId;
        return this;
    }

    public Date getConsumptionTime() {
        return consumptionTime;
    }

    public Speakerconsumptionrecord setConsumptionTime(Date consumptionTime) {
        this.consumptionTime = consumptionTime;
        return this;
    }

    public Long getConsumptionSize() {
        return consumptionSize;
    }

    public Speakerconsumptionrecord setConsumptionSize(Long consumptionSize) {
        this.consumptionSize = consumptionSize;
        return this;
    }

    public Long getSurplusSize() {
        return surplusSize;
    }

    public Speakerconsumptionrecord setSurplusSize(Long surplusSize) {
        this.surplusSize = surplusSize;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Speakerconsumptionrecord{" +
        "id=" + id +
        ", memberId=" + memberId +
        ", consumptionTime=" + consumptionTime +
        ", consumptionSize=" + consumptionSize +
        ", surplusSize=" + surplusSize +
        "}";
    }
}
