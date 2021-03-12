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
 * 礼物表
 * </p>
 *
 * @author GR123
 * @since 2020-07-09
 */
public class Gift extends Model<Gift> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 图片
     */
    private String images;
    /**
     * 权重
     */
    private Integer weight;
    /**
     * 单价
     */
    private Integer price;
    /**
     * 添加时间
     */
    private Date addTime;
    /**
     * 编辑时间
     */
    private Date editTime;
    /**
     * 启用状态 1:启用2:禁用
     */
    private Integer enableState;
    /**
     * 删除状态 1:已删除2:未删除
     */
    private Integer deleteState;


    public Integer getId() {
        return id;
    }

    public Gift setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Gift setName(String name) {
        this.name = name;
        return this;
    }

    public String getImages() {
        return images;
    }

    public Gift setImages(String images) {
        this.images = images;
        return this;
    }

    public Integer getWeight() {
        return weight;
    }

    public Gift setWeight(Integer weight) {
        this.weight = weight;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public Gift setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public Date getAddTime() {
        return addTime;
    }

    public Gift setAddTime(Date addTime) {
        this.addTime = addTime;
        return this;
    }

    public Date getEditTime() {
        return editTime;
    }

    public Gift setEditTime(Date editTime) {
        this.editTime = editTime;
        return this;
    }

    public Integer getEnableState() {
        return enableState;
    }

    public Gift setEnableState(Integer enableState) {
        this.enableState = enableState;
        return this;
    }

    public Integer getDeleteState() {
        return deleteState;
    }

    public Gift setDeleteState(Integer deleteState) {
        this.deleteState = deleteState;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Gift{" +
        "id=" + id +
        ", name=" + name +
        ", images=" + images +
        ", weight=" + weight +
        ", price=" + price +
        ", addTime=" + addTime +
        ", editTime=" + editTime +
        ", enableState=" + enableState +
        ", deleteState=" + deleteState +
        "}";
    }
}
