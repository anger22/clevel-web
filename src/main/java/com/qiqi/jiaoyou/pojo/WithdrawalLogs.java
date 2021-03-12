package com.qiqi.jiaoyou.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * 金钻银钻兑换记录表(WithdrawalLogs)表实体类
 *
 * @author nan
 * @since 2020-12-14 09:32:31
 */
@TableName("withdrawal_logs")
public class WithdrawalLogs extends Model<WithdrawalLogs> {

    private Long id;
    //会员id值
    private Integer memberid;
    //金钻数
    private String gold;
    //银钻数
    private String sliver;
    //1:金钻兑换银钻 2：银钻兑换金钻
    private String type;

    private Date createtime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMemberid() {
        return memberid;
    }

    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }

    public String getGold() {
        return gold;
    }

    public void setGold(String gold) {
        this.gold = gold;
    }

    public String getSliver() {
        return sliver;
    }

    public void setSliver(String sliver) {
        this.sliver = sliver;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
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