package com.qiqi.jiaoyou.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiqi.jiaoyou.mapper.GameSelectLabelDao;
import com.qiqi.jiaoyou.pojo.GameSelectLabel;
import com.qiqi.jiaoyou.service.GameSelectLabelService;
import com.qiqi.jiaoyou.util.ResultUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 答题游戏库选项标签(GameSelectLabel)表服务实现类
 *
 * @author makejava
 * @since 2020-11-27 11:25:35
 */
@Service("gameSelectLabelService")
public class GameSelectLabelServiceImpl extends ServiceImpl<GameSelectLabelDao,GameSelectLabel> implements GameSelectLabelService {

	@Override
	public ResultUtils findById(Long id) {
		ResultUtils resultUtils = new ResultUtils();
		GameSelectLabel obj = baseMapper.selectById(id);
		resultUtils.setData(obj);
		resultUtils.setStatus(200);
		resultUtils.setMessage("查询成功");
		return resultUtils;
	}

	@Override
	public ResultUtils add(GameSelectLabel gameSelectLabel) {
		ResultUtils resultUtils = new ResultUtils();
		gameSelectLabel.setCreateTime(new Date());
		gameSelectLabel.setUpdateTime(new Date());
		gameSelectLabel.setGameSelectTitle(gameSelectLabel.getGameSelectTitle());
		gameSelectLabel.setGameSelectTitleIcon(gameSelectLabel.getGameSelectTitleIcon());
		gameSelectLabel.setGameSelectSort(gameSelectLabel.getGameSelectSort());
		Integer i =  baseMapper.insert(gameSelectLabel);
		if(i > 0){
			resultUtils.setStatus(200);
			resultUtils.setMessage("添加成功");
		}else{
			resultUtils.setStatus(200);
			resultUtils.setMessage("添加失败");
		}
		return resultUtils;
	}

	@Override
	public ResultUtils delete(Long id) {
		ResultUtils resultUtils = new ResultUtils();
		Integer i =  baseMapper.deleteById(id);
		if(i > 0){
			resultUtils.setStatus(200);
			resultUtils.setMessage("删除成功");
		}else{
			resultUtils.setStatus(200);
			resultUtils.setMessage("删除失败");
		}
		return resultUtils;
	}

	@Override
	public ResultUtils updateData(GameSelectLabel gameSelectLabel) {
		ResultUtils resultUtils = new ResultUtils();
		gameSelectLabel.setUpdateTime(new Date());
		Integer i =  baseMapper.updateById(gameSelectLabel);
		if(i > 0){
			resultUtils.setStatus(200);
			resultUtils.setMessage("更新成功");
		}else{
			resultUtils.setStatus(200);
			resultUtils.setMessage("更新失败");
		}
		return resultUtils;
	}

	@Override
	public List<GameSelectLabel> getAll() {
		QueryWrapper<GameSelectLabel> wrapper = new QueryWrapper<>();
		return baseMapper.selectList(wrapper);
	}

	@Override
	public ResultUtils findListByPage(Integer page, Integer limit, Map<String,String> map) {
		ResultUtils resultUtils = new ResultUtils();
		IPage<GameSelectLabel> wherePage = new Page<>(page, limit);
		QueryWrapper<GameSelectLabel> wrapper = Wrappers.query();
		for (String key : map.keySet()) {
			wrapper.like(key,map.get(key));
		}
		wrapper.orderByAsc("game_select_sort");

		IPage<GameSelectLabel> list =   baseMapper.selectPage(wherePage, wrapper);
		resultUtils.setData(list.getRecords());
		resultUtils.setMessage("查询成功");
		resultUtils.setStatus(200);
		resultUtils.setCode(0);
		resultUtils.setCount((int)list.getTotal());
		return resultUtils;
	}

	@Override
	public ResultUtils findListByAll() {
		ResultUtils resultUtils = new ResultUtils();
		QueryWrapper<GameSelectLabel> wrapper = Wrappers.query();
		wrapper.orderByAsc("game_select_sort");

		List<GameSelectLabel> list =   baseMapper.selectList( wrapper);
		resultUtils.setData(list);
		resultUtils.setMessage("查询成功");
		resultUtils.setStatus(200);
		resultUtils.setCode(0);
		return resultUtils;
	}
}