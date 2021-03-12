package com.qiqi.jiaoyou.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * 服务信息管理类型表(ServerInfoType)表实体类
 *
 * @author nan
 * @since 2020-12-01 17:35:55
 */
@TableName("server_info_type")
public class ServerInfoType extends Model<ServerInfoType> {
private static final long serialVersionUID = 1L;
	 @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    //标题
    @TableField("server_title")
    private String serverTitle;
    //排序
    @TableField("server_sort")
    private String serverSort;
    //状态 0：删除，1：正常
    @TableField("server_status")
    private String serverStatus;

    @TableField("create_time")
    private Date createTime;

    @TableField("server_type")
    private Integer serverType;

    @Override
    public String toString() {
        return "ServerInfoType{" +
                "id=" + id +
                ", serverTitle='" + serverTitle + '\'' +
                ", serverSort='" + serverSort + '\'' +
                ", serverStatus='" + serverStatus + '\'' +
                ", createTime=" + createTime +
                ", serverType=" + serverType +
                ", serverIcon='" + serverIcon + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }

    public String getServerIcon() {
        return serverIcon;
    }

    public void setServerIcon(String serverIcon) {
        this.serverIcon = serverIcon;
    }

    @TableField("server_icon")
   private String serverIcon;

    public Integer getServerType() {
        return serverType;
    }

    public void setServerType(Integer serverType) {
        this.serverType = serverType;
    }

    @TableField("update_time")
    private Date updateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServerTitle() {
        return serverTitle;
    }

    public void setServerTitle(String serverTitle) {
        this.serverTitle = serverTitle;
    }

    public String getServerSort() {
        return serverSort;
    }

    public void setServerSort(String serverSort) {
        this.serverSort = serverSort;
    }

    public String getServerStatus() {
        return serverStatus;
    }

    public void setServerStatus(String serverStatus) {
        this.serverStatus = serverStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}