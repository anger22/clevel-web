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
 * 角色表
 * </p>
 *
 * @author GR123
 * @since 2020-07-09
 */
public class Role extends Model<Role> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 角色名称
     */
    private String name;
    /**
     * 菜单
     */
    private String menus;
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

    @TableField(exist = false)
    private String menuStr;

    public String getMenuStr() {
        return menuStr;
    }

    public void setMenuStr(String menuStr) {
        this.menuStr = menuStr;
    }

    public Integer getId() {
        return id;
    }

    public Role setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Role setName(String name) {
        this.name = name;
        return this;
    }

    public String getMenus() {
        return menus;
    }

    public Role setMenus(String menus) {
        this.menus = menus;
        return this;
    }

    public Date getAddTime() {
        return addTime;
    }

    public Role setAddTime(Date addTime) {
        this.addTime = addTime;
        return this;
    }

    public Date getEditTime() {
        return editTime;
    }

    public Role setEditTime(Date editTime) {
        this.editTime = editTime;
        return this;
    }

    public Integer getEnableState() {
        return enableState;
    }

    public Role setEnableState(Integer enableState) {
        this.enableState = enableState;
        return this;
    }

    public Integer getDeleteState() {
        return deleteState;
    }

    public Role setDeleteState(Integer deleteState) {
        this.deleteState = deleteState;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Role{" +
        "id=" + id +
        ", name=" + name +
        ", menus=" + menus +
        ", addTime=" + addTime +
        ", editTime=" + editTime +
        ", enableState=" + enableState +
        ", deleteState=" + deleteState +
        "}";
    }
}
