package com.qiqi.jiaoyou.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiqi.jiaoyou.mapper.GameBankDao;
import com.qiqi.jiaoyou.pojo.GameBank;
import com.qiqi.jiaoyou.pojo.GameSelectLabel;
import com.qiqi.jiaoyou.service.GameBankService;
import com.qiqi.jiaoyou.service.GameSelectLabelService;
import com.qiqi.jiaoyou.util.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 答题游戏题库(GameBank)表服务实现类
 *
 * @author makejava
 * @since 2020-11-27 11:12:53
 */
@Service
public class GameBankServiceImpl extends ServiceImpl<GameBankDao,GameBank> implements GameBankService {

	@Autowired
	private GameSelectLabelService gameSelectLabelService;
	@Override
	public ResultUtils findById(Long id) {
		ResultUtils resultUtils = new ResultUtils();
		GameBank obj = baseMapper.selectById(id);
		resultUtils.setData(obj);
		resultUtils.setStatus(200);
		resultUtils.setMessage("查询成功");
		return resultUtils;
	}

	@Override
	public ResultUtils findListByPage(Integer page, Integer limit, Map<String,String> map) {
		ResultUtils resultUtils = new ResultUtils();
		IPage<GameBank> wherePage = new Page<>(page, limit);
		QueryWrapper<GameBank> wrapper = Wrappers.query();
		for (String key : map.keySet()) {
			wrapper.like(key,map.get(key));
		}
		wrapper.orderByAsc("game_sort");

		IPage<GameBank> list =   baseMapper.selectPage(wherePage, wrapper);

		/*在这里拼接返回的标签的值，吧标签数字转换为字符串*/
		List<GameSelectLabel> listType = gameSelectLabelService.getAll();
		for(int i = 0;i<list.getRecords().size();i++){
			for(int a = 0;a<listType.size();a++){
				if(list.getRecords().get(i).getGameSelectId().equals(listType.get(a).getId().toString())){
					list.getRecords().get(i).setGameSelectText(listType.get(a).getGameSelectTitle());
				}
			}
		}

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
		QueryWrapper<GameBank> wrapper = Wrappers.query();
		wrapper.orderByAsc("game_sort");

		List<GameBank> list =   baseMapper.selectList(wrapper);
		resultUtils.setData(list);
		resultUtils.setMessage("查询成功");
		resultUtils.setStatus(200);
		resultUtils.setCode(0);
		return resultUtils;
	}

	@Override
	public ResultUtils add(GameBank gameBank) {
		ResultUtils resultUtils = new ResultUtils();
		GameBank gameBank1 = new GameBank();
		gameBank1.setCreateTime(new Date());
		gameBank1.setUpdateTime(new Date());
		gameBank1.setGameStem(gameBank.getGameStem());
		gameBank1.setGameSelectId(gameBank.getGameSelectId());
		gameBank1.setTrueAnswer(gameBank.getTrueAnswer());
		gameBank1.setGameSort(gameBank.getGameSort());
		Integer i =  baseMapper.insert(gameBank1);
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
	public ResultUtils updateData(GameBank gameBank) {
		ResultUtils resultUtils = new ResultUtils();
		gameBank.setUpdateTime(new Date());
		Integer i =  baseMapper.updateById(gameBank);
		if(i > 0){
			resultUtils.setStatus(200);
			resultUtils.setMessage("更新成功");
		}else{
			resultUtils.setStatus(200);
			resultUtils.setMessage("更新失败");
		}
		return resultUtils;
	}
}