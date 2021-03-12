package com.qiqi.jiaoyou.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qiqi.jiaoyou.pojo.LoveHeartDonation;
import com.qiqi.jiaoyou.util.ResultUtils;

import java.util.Map;

/**
 * 爱心捐赠(LoveHeartDonation)表服务接口
 *
 * @author makejava
 * @since 2020-11-30 11:17:45
 */
public interface LoveHeartDonationService extends IService<LoveHeartDonation> {

    /**
     * 查询爱心捐赠分页数*
     * @param page      页码
     * @param limit 每页条数
     * @return ResultUtils
     */
    ResultUtils findListByPage(Integer page, Integer limit, Map<String,String> map);

   /**
     * 添加信息
     *
     * @param  loveHeartDonation
     * @return ResultUtils
     */
    ResultUtils add(LoveHeartDonation loveHeartDonation);
 /**
     * id查询数据
     *
     * @param id id
     * @return ResultUtils
     */
    ResultUtils findById(Long id);
    /**
     * 删除信息
     *
     * @param id 主键
     * @return ResultUtils
     */
    ResultUtils delete(Long id);

    /**
     * 修改信息
     *
     * @param loveHeartDonation 礼物表
     * @return ResultUtils
     */
    ResultUtils updateData(LoveHeartDonation loveHeartDonation);
}