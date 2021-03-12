package com.qiqi.jiaoyou.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qiqi.jiaoyou.pojo.RedLog;
import com.qiqi.jiaoyou.util.ResultUtils;

import java.util.List;
import java.util.Map;

/**
 * 红包发送记录表(RedLog)表服务接口
 *
 * @author nanstar
 * @since 2020-11-26 10:18:17
 */
public interface RedLogService extends IService<RedLog> {


 /**
     * 查询礼物记录表分页数据
     * 因为是二次开发，根据以往的代码，这里新增的代码不做精简，逻辑按照以往代码的风格来写
     * @param page      页码
     * @param limit 每页条数
     * @return ResultUtils
     */
    ResultUtils findListByPage(Integer page, Integer limit, Map<String,String> map);


    /**
	 * 通过ID查询单条数据
	 *
	 * @param redLogId 主键
	 *
	 * @return 实例对象
	 */
	RedLog queryById(Integer redLogId);

	/**
	 * 查询多条数据
	 *
	 * @param offset 查询起始位置
	 * @param limit 查询条数
	 *
	 * @return 对象列表
	 */
	List<RedLog> queryAllByLimit(int offset, int limit);

	/**
	 * 新增数据
	 *
	 * @param redLog 实例对象
	 *
	 * @return 实例对象
	 */
	RedLog insert(RedLog redLog);

	/**
	 * 修改数据
	 *
	 * @param redLog 实例对象
	 *
	 * @return 实例对象
	 */
	RedLog update(RedLog redLog);

	/**
	 * 通过主键删除数据
	 *
	 * @param redLogId 主键
	 *
	 * @return 是否成功
	 */
	boolean deleteById(Integer redLogId);

}