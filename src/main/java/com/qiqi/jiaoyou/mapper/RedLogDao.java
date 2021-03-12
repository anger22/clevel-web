package com.qiqi.jiaoyou.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qiqi.jiaoyou.pojo.RedLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 红包发送记录表(RedLog)表数据库访问层
 *
 * @author makejava
 * @since 2020-11-26 10:18:16
 */
public interface RedLogDao extends BaseMapper<RedLog> {

	/**
	 * 通过ID查询单条数据
	 *
	 * @param redLogId 主键
	 *
	 * @return 实例对象
	 */
	RedLog queryById(Integer redLogId);

	/**
	 * 查询指定行数据
	 *
	 * @param offset 查询起始位置
	 * @param limit 查询条数
	 *
	 * @return 对象列表
	 */
	List<RedLog> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


	/**
	 * 通过实体作为筛选条件查询
	 *
	 * @param redLog 实例对象
	 *
	 * @return 对象列表
	 */
	List<RedLog> queryAll(RedLog redLog);

	/**
	 * 新增数据
	 *
	 * @param redLog 实例对象
	 *
	 * @return 影响行数
	 */
	int insert(RedLog redLog);

	/**
	 * 修改数据
	 *
	 * @param redLog 实例对象
	 *
	 * @return 影响行数
	 */
	int update(RedLog redLog);

	/**
	 * 通过主键删除数据
	 *
	 * @param redLogId 主键
	 *
	 * @return 影响行数
	 */
	int deleteById(Integer redLogId);

}