package com.qiqi.jiaoyou.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiqi.jiaoyou.mapper.LoveHeartDonationLogsDao;
import com.qiqi.jiaoyou.pojo.LoveHeartDonationLogs;
import com.qiqi.jiaoyou.service.LoveHeartDonationLogsService;
import com.qiqi.jiaoyou.util.ResultUtils;
import com.qiqi.jiaoyou.vo.loveDonationLogsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (LoveHeartDonationLogs)表服务实现类
 *
 * @author nan
 * @since 2020-12-01 11:02:15
 */
@Service("loveHeartDonationLogsService")
public class LoveHeartDonationLogsServiceImpl extends ServiceImpl<LoveHeartDonationLogsDao, LoveHeartDonationLogs> implements LoveHeartDonationLogsService {
    @Autowired
     private    LoveHeartDonationLogsDao loveHeartDonationLogsDao;
    @Override
    public ResultUtils findListByLogs(Integer page, Integer limit,Integer userId) {
         ResultUtils resultUtils = new ResultUtils();
//        IPage<LoveHeartDonationLogs> wherePage = new Page<>(page, limit);

//        QueryWrapper<LoveHeartDonationLogs> wrapper = Wrappers.query();
//        wrapper.orderByAsc("donation_time");
//        IPage<LoveHeartDonationLogs> list =   baseMapper.selectPage(wherePage, wrapper);


//        List<LoveHeartDonationLogs> lists = baseMapper.selectList(new QueryWrapper<LoveHeartDonationLogs>().eq("id",userId));
        List<loveDonationLogsVo> lists = baseMapper.selectLogsAllInfo(userId);


        resultUtils.setData(lists);
        resultUtils.setMessage("查询成功");
        resultUtils.setStatus(200);
        resultUtils.setCode(0);
//        resultUtils.setCount((int)list.getTotal());
        return resultUtils;
    }
}