package com.qiqi.jiaoyou.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiqi.jiaoyou.mapper.WithdrawalLogsDao;
import com.qiqi.jiaoyou.pojo.WithdrawalLogs;
import com.qiqi.jiaoyou.service.WithdrawalLogsService;
import com.qiqi.jiaoyou.util.ResultUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 金钻银钻兑换记录表(WithdrawalLogs)表服务实现类
 *
 * @author nan
 * @since 2020-12-14 09:32:35
 */
@Service("withdrawalLogsService")
public class WithdrawalLogsServiceImpl extends ServiceImpl<WithdrawalLogsDao, WithdrawalLogs> implements WithdrawalLogsService {

    @Override
    public ResultUtils findListByPage(Integer page, Integer limit, Map<String, String> map) {
      	ResultUtils resultUtils = new ResultUtils();
		IPage<WithdrawalLogs> wherePage = new Page<>(page, limit);
		QueryWrapper<WithdrawalLogs> wrapper = Wrappers.query();
		for (String key : map.keySet()) {
			wrapper.eq("memberId",map.get(key));
		}

		IPage<WithdrawalLogs> list =   baseMapper.selectPage(wherePage, wrapper);
		wrapper.orderByDesc("createTime");
		resultUtils.setData(list.getRecords());
		resultUtils.setMessage("查询成功");
		resultUtils.setStatus(200);
		resultUtils.setCode(0);
		resultUtils.setCount((int)wherePage.getTotal());
		return resultUtils;
    }
}