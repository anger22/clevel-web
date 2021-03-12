package com.qiqi.jiaoyou.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author nan
 * 用来设置返回的会员信息的修改
 * @date 2020/12/4 10:13
 */
@Data
public class MemberVo {

    /*id*/
    private Integer id;
    /*是否是vip 1是 2不是*/
    private Integer userIsvIP;
    /*会员到期时间*/
    private Date vipEndTime;


    /*剩余喇叭数*/
    private Long hornNumber;
    /*剩余金钻数*/
    private Long GoldNumber;
    /*剩余银钻数*/
    private Long silverNumber;


}
