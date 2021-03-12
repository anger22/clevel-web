package com.qiqi.jiaoyou.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * 服务管理信息表(ServerInfoManager)表实体类
 *
 * @author makejava
 * @since 2020-12-01 17:35:49
 */
@TableName("server_info_manager")
public class ServerInfoManager extends Model<ServerInfoManager> {
private static final long serialVersionUID = 1L;
	 @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    //服务类型id
    @TableField("server_type_id")
    private Integer serverTypeId;
    //服务信息封面图
    @TableField("server_cover")
    private String serverCover;
    //服务标题
    @TableField("server_title")
    private String serverTitle;
    //价格
    @TableField("server_price")
    private Double serverPrice;
    //图文简介
    @TableField("server_introduce")
    private String serverIntroduce;
    //是否置顶 0：未置顶 1：置顶
    @TableField("server_is_top")
    private String serverIsTop;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;
    //状态 0：删除 1：正常
    @TableField("server_title")
    private String serverStatus;

    @TableField("city")
    private String city;

    @Override
    public String toString() {
        return "ServerInfoManager{" +
                "id=" + id +
                ", serverTypeId=" + serverTypeId +
                ", serverCover='" + serverCover + '\'' +
                ", serverTitle='" + serverTitle + '\'' +
                ", serverPrice=" + serverPrice +
                ", serverIntroduce='" + serverIntroduce + '\'' +
                ", serverIsTop='" + serverIsTop + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", serverStatus='" + serverStatus + '\'' +
                ", city='" + city + '\'' +
                ", width='" + width + '\'' +
                ", serverTypeText='" + serverTypeText + '\'' +
                '}';
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    /*简介图片的宽高比（宽/高）默认两位小数*/
   @TableField("width")
   private String width;


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getServerTypeText() {
        return serverTypeText;
    }

    public void setServerTypeText(String serverTypeText) {
        this.serverTypeText = serverTypeText;
    }

    @TableField(exist = false)
    private String serverTypeText;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getServerTypeId() {
        return serverTypeId;
    }

    public void setServerTypeId(Integer serverTypeId) {
        this.serverTypeId = serverTypeId;
    }

    public String getServerCover() {
        return serverCover;
    }

    public void setServerCover(String serverCover) {
        this.serverCover = serverCover;
    }

    public String getServerTitle() {
        return serverTitle;
    }

    public void setServerTitle(String serverTitle) {
        this.serverTitle = serverTitle;
    }

    public Double getServerPrice() {
        return serverPrice;
    }

    public void setServerPrice(Double serverPrice) {
        this.serverPrice = serverPrice;
    }

    public String getServerIntroduce() {
        return serverIntroduce;
    }

    public void setServerIntroduce(String serverIntroduce) {
        this.serverIntroduce = serverIntroduce;
    }

    public String getServerIsTop() {
        return serverIsTop;
    }

    public void setServerIsTop(String serverIsTop) {
        this.serverIsTop = serverIsTop;
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

    public String getServerStatus() {
        return serverStatus;
    }

    public void setServerStatus(String serverStatus) {
        this.serverStatus = serverStatus;
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