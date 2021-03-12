package com.qiqi.jiaoyou.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * 爱心捐赠(LoveHeartDonation)表实体类
 *
 * @author makejava
 * @since 2020-11-30 11:17:41
 */
@TableName("love_heart_donation")
public class LoveHeartDonation extends Model<LoveHeartDonation> {
private static final long serialVersionUID = 1L;
	 @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    //标题

   @TableField("love_title")
   private String loveTitle;
    //说明
   @TableField("love_explain")
    private String loveExplain;
    //需要金额
   @TableField("love_need_money")
    private String loveNeedMoney;
    //已捐赠金额
   @TableField("love_now_money")
    private String loveNowMoney;
    //封面
   @TableField("love_cover")
    private String loveCover;
    //0:正常，1：删除
   @TableField("love_state")
    private String loveState;
    //创建时间
   @TableField("create_time")
    private Date createTime;
    //更新时间
   @TableField("update_time")
    private Date updateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoveTitle() {
        return loveTitle;
    }

    public void setLoveTitle(String loveTitle) {
        this.loveTitle = loveTitle;
    }

    public String getLoveExplain() {
        return loveExplain;
    }

    public void setLoveExplain(String loveExplain) {
        this.loveExplain = loveExplain;
    }

    public String getLoveNeedMoney() {
        return loveNeedMoney;
    }

    public void setLoveNeedMoney(String loveNeedMoney) {
        this.loveNeedMoney = loveNeedMoney;
    }

    public String getLoveNowMoney() {
        return loveNowMoney;
    }

    public void setLoveNowMoney(String loveNowMoney) {
        this.loveNowMoney = loveNowMoney;
    }

    public String getLoveCover() {
        return loveCover;
    }

    public void setLoveCover(String loveCover) {
        this.loveCover = loveCover;
    }

    public String getLoveState() {
        return loveState;
    }

    public void setLoveState(String loveState) {
        this.loveState = loveState;
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