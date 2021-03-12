package com.qiqi.jiaoyou.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 后台管理员表
 * </p>
 *
 * @author GR123
 * @since 2020-07-09
 */
public class Account extends Model<Account> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 账号
     */
    private String account;
    /**
     * 密码
     */
    private String password;
    /**
     * 姓名
     */
    private String name;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 角色
     */
    private Integer roleId;
    /**
     * 添加时间
     */
    private Date addTime;
    /**
     * 修改时间
     */
    private Date editTime;
    /**
     * token
     */
    private String token;
    /**
     * 启用状态 1:启用2:禁用
     */
    private Integer enableState;
    /**
     * 删除状态 1:已删除2:未删除
     */
    private Integer deleteState;

    @TableField(exist = false)
    private String oldPassword;

    @TableField(exist = false)
    private String roleName;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getId() {
        return id;
    }

    public Account setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getAccount() {
        return account;
    }

    public Account setAccount(String account) {
        this.account = account;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Account setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public Account setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Account setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public Account setRoleId(Integer roleId) {
        this.roleId = roleId;
        return this;
    }

    public Date getAddTime() {
        return addTime;
    }

    public Account setAddTime(Date addTime) {
        this.addTime = addTime;
        return this;
    }

    public Date getEditTime() {
        return editTime;
    }

    public Account setEditTime(Date editTime) {
        this.editTime = editTime;
        return this;
    }

    public String getToken() {
        return token;
    }

    public Account setToken(String token) {
        this.token = token;
        return this;
    }

    public Integer getEnableState() {
        return enableState;
    }

    public Account setEnableState(Integer enableState) {
        this.enableState = enableState;
        return this;
    }

    public Integer getDeleteState() {
        return deleteState;
    }

    public Account setDeleteState(Integer deleteState) {
        this.deleteState = deleteState;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Account{" +
        "id=" + id +
        ", account=" + account +
        ", password=" + password +
        ", name=" + name +
        ", phone=" + phone +
        ", roleId=" + roleId +
        ", addTime=" + addTime +
        ", editTime=" + editTime +
        ", token=" + token +
        ", enableState=" + enableState +
        ", deleteState=" + deleteState +
        "}";
    }
}
