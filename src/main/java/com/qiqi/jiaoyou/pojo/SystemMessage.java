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
 * 系统消息表
 * </p>
 *
 * @author GR123
 * @since 2020-07-09
 */
@TableName("system_message")
public class SystemMessage extends Model<SystemMessage> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String context;
    /**
     * 添加时间
     */
    private Date addTime;
    /**
     * 修改时间
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

    public SystemMessage setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public SystemMessage setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContext() {
        return context;
    }

    public SystemMessage setContext(String context) {
        this.context = context;
        return this;
    }

    public Date getAddTime() {
        return addTime;
    }

    public SystemMessage setAddTime(Date addTime) {
        this.addTime = addTime;
        return this;
    }

    public Date getEditTime() {
        return editTime;
    }

    public SystemMessage setEditTime(Date editTime) {
        this.editTime = editTime;
        return this;
    }

    public Integer getEnableState() {
        return enableState;
    }

    public SystemMessage setEnableState(Integer enableState) {
        this.enableState = enableState;
        return this;
    }

    public Integer getDeleteState() {
        return deleteState;
    }

    public SystemMessage setDeleteState(Integer deleteState) {
        this.deleteState = deleteState;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "SystemMessage{" +
        "id=" + id +
        ", title=" + title +
        ", context=" + context +
        ", addTime=" + addTime +
        ", editTime=" + editTime +
        ", enableState=" + enableState +
        ", deleteState=" + deleteState +
        "}";
    }
}
