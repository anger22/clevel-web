package com.qiqi.jiaoyou.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author GR123
 * @since 2020-07-09
 */
public class Menu extends Model<Menu> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "f_id", type = IdType.AUTO)
    private Integer fId;
    /**
     * 分类 1:一级,2:二级,3:三级
     */
    @TableField("f_clasid")
    private Integer fClasid;
    /**
     * 二级id
     */
    @TableField("f_tid")
    private Integer fTid;
    /**
     * 一级id
     */
    @TableField("f_oid")
    private Integer fOid;
    /**
     * 权限名称
     */
    @TableField("f_name")
    private String fName;
    /**
     * 权重
     */
    @TableField("f_weight")
    private Integer fWeight;
    /**
     * 权限地址
     */
    @TableField("f_address")
    private String fAddress;

    @TableField(exist = false)
    private List<Menu> list;

    public List<Menu> getList() {
        return list;
    }

    public void setList(List<Menu> list) {
        this.list = list;
    }

    public Integer getfId() {
        return fId;
    }

    public Menu setfId(Integer fId) {
        this.fId = fId;
        return this;
    }

    public Integer getfClasid() {
        return fClasid;
    }

    public Menu setfClasid(Integer fClasid) {
        this.fClasid = fClasid;
        return this;
    }

    public Integer getfTid() {
        return fTid;
    }

    public Menu setfTid(Integer fTid) {
        this.fTid = fTid;
        return this;
    }

    public Integer getfOid() {
        return fOid;
    }

    public Menu setfOid(Integer fOid) {
        this.fOid = fOid;
        return this;
    }

    public String getfName() {
        return fName;
    }

    public Menu setfName(String fName) {
        this.fName = fName;
        return this;
    }

    public Integer getfWeight() {
        return fWeight;
    }

    public Menu setfWeight(Integer fWeight) {
        this.fWeight = fWeight;
        return this;
    }

    public String getfAddress() {
        return fAddress;
    }

    public Menu setfAddress(String fAddress) {
        this.fAddress = fAddress;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.fId;
    }

    @Override
    public String toString() {
        return "Menu{" +
        "fId=" + fId +
        ", fClasid=" + fClasid +
        ", fTid=" + fTid +
        ", fOid=" + fOid +
        ", fName=" + fName +
        ", fWeight=" + fWeight +
        ", fAddress=" + fAddress +
        "}";
    }
}
