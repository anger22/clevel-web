package com.qiqi.jiaoyou.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author nan
 * @date 2020/12/1 14:08
 */
@Data
public class loveDonationLogsVo {

 private Integer id;
    //捐赠用户id
    private Integer userId;
    //捐赠项目id
    private Integer donationProjectId;
    //捐赠时间
    private Date donationTime;
    //捐赠金额
    private Double donationMoney;
    //备注
    private String donationRemark;

   private  String nickName;

   private String head;
}
