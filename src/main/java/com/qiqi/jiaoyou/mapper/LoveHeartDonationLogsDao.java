package com.qiqi.jiaoyou.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qiqi.jiaoyou.pojo.LoveHeartDonationLogs;
import com.qiqi.jiaoyou.vo.loveDonationLogsVo;

import java.util.List;

/**
 * (LoveHeartDonationLogs)表数据库访问层
 *
 * @author makejava
 * @since 2020-12-01 11:02:14
 */
public interface LoveHeartDonationLogsDao extends BaseMapper<LoveHeartDonationLogs> {


    List<loveDonationLogsVo> selectLogsAllInfo(Integer userId);
}