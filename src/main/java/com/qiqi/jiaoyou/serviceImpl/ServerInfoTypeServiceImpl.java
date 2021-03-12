package com.qiqi.jiaoyou.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiqi.jiaoyou.mapper.ServerInfoTypeDao;
import com.qiqi.jiaoyou.pojo.ServerInfoType;
import com.qiqi.jiaoyou.service.ServerInfoTypeService;
import com.qiqi.jiaoyou.util.ResultUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 服务信息管理类型表(ServerInfoType)表服务实现类
 *
 * @author makejava
 * @since 2020-12-01 17:35:57
 */
@Service("serverInfoTypeService")
public class ServerInfoTypeServiceImpl extends ServiceImpl<ServerInfoTypeDao, ServerInfoType> implements ServerInfoTypeService {

    @Override
    public ResultUtils add(ServerInfoType serverInfoType) {
        ResultUtils resultUtils = new ResultUtils();
        ServerInfoType serverInfoType1 = new ServerInfoType();
		serverInfoType1.setCreateTime(new Date());
		serverInfoType1.setUpdateTime(new Date());
		serverInfoType1.setServerTitle(serverInfoType.getServerTitle());
		serverInfoType1.setServerSort(serverInfoType.getServerSort());
		serverInfoType1.setServerStatus("1");
		serverInfoType1.setServerIcon(serverInfoType.getServerIcon());
		serverInfoType1.setServerType(serverInfoType.getServerType());
		Integer i =  baseMapper.insert(serverInfoType1);
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
	public ResultUtils findById(Long id) {
		ResultUtils resultUtils = new ResultUtils();
		ServerInfoType obj = baseMapper.selectById(id);
		resultUtils.setData(obj);
		resultUtils.setStatus(200);
		resultUtils.setMessage("查询成功");
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
	public List<ServerInfoType> getAllInfo() {
    	QueryWrapper<ServerInfoType> wrapper = new QueryWrapper<>();
    	wrapper.eq("server_status","1");
    	List<ServerInfoType> list =  baseMapper.selectList(wrapper);
		return list;
	}

	@Override
    public ResultUtils updateData(ServerInfoType serverInfoType) {
       ResultUtils resultUtils = new ResultUtils();
		serverInfoType.setUpdateTime(new Date());
		Integer i =  baseMapper.updateById(serverInfoType);
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
	public ResultUtils findListByPage(Integer page, Integer limit, Map<String, String> map) {
		ResultUtils resultUtils = new ResultUtils();
		IPage<ServerInfoType> wherePage = new Page<>(page, limit);
		QueryWrapper<ServerInfoType> wrapper = Wrappers.query();
		for (String key : map.keySet()) {
			wrapper.like(key,map.get(key));
		}
		wrapper.orderByAsc("server_sort");
		wrapper.eq("server_status","1");

		IPage<ServerInfoType> list =   baseMapper.selectPage(wherePage, wrapper);
		resultUtils.setData(list.getRecords());
		resultUtils.setMessage("查询成功");
		resultUtils.setStatus(200);
		resultUtils.setCode(0);
		resultUtils.setCount((int)list.getTotal());
		return resultUtils;
	}
}