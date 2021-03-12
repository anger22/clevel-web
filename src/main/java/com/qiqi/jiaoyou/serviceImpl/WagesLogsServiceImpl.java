package com.qiqi.jiaoyou.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiqi.jiaoyou.mapper.WagesLogsDao;
import com.qiqi.jiaoyou.pojo.WagesLogs;
import com.qiqi.jiaoyou.service.WagesLogsService;
import com.qiqi.jiaoyou.util.ResultUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 工资记录表(WagesLogs)表服务实现类
 *
 * @author makejava
 * @since 2020-12-14 19:01:35
 */
@Service("wagesLogsService")
public class WagesLogsServiceImpl extends ServiceImpl<WagesLogsDao, WagesLogs> implements WagesLogsService {

    @Override
    public ResultUtils findListByPage(Integer page, Integer limit, Map<String, String> map) {
        ResultUtils resultUtils = new ResultUtils();
		IPage<WagesLogs> wherePage = new Page<>(page, limit);
		QueryWrapper<WagesLogs> wrapper = Wrappers.query();
		for (String key : map.keySet()) {
			wrapper.eq("memberId",map.get(key));
		}

		IPage<WagesLogs> list =   baseMapper.selectPage(wherePage, wrapper);
		wrapper.orderByDesc("createTime");
		resultUtils.setData(list.getRecords());
		resultUtils.setMessage("查询成功");
		resultUtils.setStatus(200);
		resultUtils.setCode(0);
		resultUtils.setCount((int)wherePage.getTotal());
		return resultUtils;
    }
}