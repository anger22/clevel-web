package com.qiqi.jiaoyou.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiqi.jiaoyou.mapper.RedLogDao;
import com.qiqi.jiaoyou.pojo.RedLog;
import com.qiqi.jiaoyou.service.RedLogService;
import com.qiqi.jiaoyou.util.ResultUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 红包发送记录表(RedLog)表服务实现类
 *
 * @author makejava
 * @since 2020-11-26 10:18:18
 */
@Service("redLogService")
public class RedLogServiceImpl extends ServiceImpl<RedLogDao, RedLog> implements RedLogService {
	@Resource
	private RedLogDao redLogDao;

	@Override
	public ResultUtils findListByPage(Integer page, Integer limit, Map<String,String> map) {
		 ResultUtils resultUtils = new ResultUtils();
        IPage<RedLog> wherePage = new Page<>(page, limit);
        QueryWrapper<RedLog> wrapper = Wrappers.query();
        for (String key : map.keySet()) {
            wrapper.like(key,map.get(key));
        }
            wrapper.orderByDesc("red_log_send_time");

        IPage<RedLog> list =   baseMapper.selectPage(wherePage, wrapper);

        /*在这里设置 1:只限男 2：只限女 2：不限  1:一对一  2：一对多*/




        resultUtils.setData(list.getRecords());
        resultUtils.setMessage("查询成功");
        resultUtils.setStatus(200);
        resultUtils.setCode(0);
        resultUtils.setCount((int)list.getTotal());
        return resultUtils;
	}

	/**
	 * 通过ID查询单条数据
	 *
	 * @param redLogId 主键
	 *
	 * @return 实例对象
	 */
	@Override
	public RedLog queryById(Integer redLogId) {
		return this.redLogDao.queryById(redLogId);
	}

	/**
	 * 查询多条数据
	 *
	 * @param offset 查询起始位置
	 * @param limit 查询条数
	 *
	 * @return 对象列表
	 */
	@Override
	public List<RedLog> queryAllByLimit(int offset, int limit) {
		return this.redLogDao.queryAllByLimit(offset, limit);
	}

	/**
	 * 新增数据
	 *
	 * @param redLog 实例对象
	 *
	 * @return 实例对象
	 */
	@Override
	public RedLog insert(RedLog redLog) {
		this.redLogDao.insert(redLog);
		return redLog;
	}

	/**
	 * 修改数据
	 *
	 * @param redLog 实例对象
	 *
	 * @return 实例对象
	 */
	@Override
	public RedLog update(RedLog redLog) {
		this.redLogDao.update(redLog);
		return this.queryById(redLog.getRedLogId());
	}

	/**
	 * 通过主键删除数据
	 *
	 * @param redLogId 主键
	 *
	 * @return 是否成功
	 */
	@Override
	public boolean deleteById(Integer redLogId) {
		return this.redLogDao.deleteById(redLogId) > 0;
	}
}