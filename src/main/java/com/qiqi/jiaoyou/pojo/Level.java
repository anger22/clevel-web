package com.qiqi.jiaoyou.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 等级表
 * </p>
 *
 * @author GR123
 * @since 2020-07-09
 */
public class Level extends Model<Level> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 等级名称
     */
    private String levelName;
    /**
     * 经验值
     */
    private Long empiricalValue;
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

    public Level setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getLevelName() {
        return levelName;
    }

    public Level setLevelName(String levelName) {
        this.levelName = levelName;
        return this;
    }

    public Long getEmpiricalValue() {
        return empiricalValue;
    }

    public Level setEmpiricalValue(Long empiricalValue) {
        this.empiricalValue = empiricalValue;
        return this;
    }

    public Date getAddTime() {
        return addTime;
    }

    public Level setAddTime(Date addTime) {
        this.addTime = addTime;
        return this;
    }

    public Date getEditTime() {
        return editTime;
    }

    public Level setEditTime(Date editTime) {
        this.editTime = editTime;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Level{" +
        "id=" + id +
        ", levelName=" + levelName +
        ", empiricalValue=" + empiricalValue +
        ", addTime=" + addTime +
        ", editTime=" + editTime +
        "}";
    }
}
