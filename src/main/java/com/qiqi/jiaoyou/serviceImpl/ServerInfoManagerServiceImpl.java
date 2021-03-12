package com.qiqi.jiaoyou.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiqi.jiaoyou.mapper.ServerInfoManagerDao;
import com.qiqi.jiaoyou.pojo.ServerInfoManager;
import com.qiqi.jiaoyou.pojo.ServerInfoType;
import com.qiqi.jiaoyou.service.ServerInfoManagerService;
import com.qiqi.jiaoyou.service.ServerInfoTypeService;
import com.qiqi.jiaoyou.util.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 服务管理信息表(ServerInfoManager)表服务实现类
 *
 * @author makejava
 * @since 2020-12-01 17:35:54
 */
@Service("serverInfoManagerService")
public class ServerInfoManagerServiceImpl extends ServiceImpl<ServerInfoManagerDao, ServerInfoManager> implements ServerInfoManagerService {

	@Autowired
	private ServerInfoTypeService serverInfoTypeService;

	@Override
	public ResultUtils findListByPage(Integer page, Integer limit, Map<String, String> map) {
		ResultUtils resultUtils = new ResultUtils();
		IPage<ServerInfoManager> wherePage = new Page<>(page, limit);
		QueryWrapper<ServerInfoManager> wrapper = Wrappers.query();
		for (String key : map.keySet()) {
			wrapper.like(key,map.get(key));
		}
		wrapper.orderByAsc("server_is_top","update_time");
		wrapper.eq("server_status","1");

		IPage<ServerInfoManager> list =   baseMapper.selectPage(wherePage, wrapper);

		/*在这里拼接返回的标签的值，吧标签数字转换为字符串*/
		List<ServerInfoManager> listOut = new ArrayList<>();

		List<ServerInfoType> listType = serverInfoTypeService.getAllInfo();

		for(int i = 0;i<list.getRecords().size();i++){
			for(int a = 0;a<listType.size();a++){
				if(!list.getRecords().get(i).getServerTypeId().equals(null)){
					if(list.getRecords().get(i).getServerTypeId().equals(listType.get(a).getId())){
						list.getRecords().get(i).setServerTypeText(listType.get(a).getServerTitle());
					}
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
    public ResultUtils findById(Long id) {
      ResultUtils resultUtils = new ResultUtils();
		ServerInfoManager obj = baseMapper.selectById(id);

		List<ServerInfoType> listType = serverInfoTypeService.getAllInfo();

			for(int a = 0;a<listType.size();a++){
				if(obj.getServerTypeId().equals(listType.get(a).getId())){
					obj.setServerTypeText(listType.get(a).getServerTitle());
				}
			}
		resultUtils.setData(obj);
		resultUtils.setStatus(200);
		resultUtils.setMessage("查询成功");
		return resultUtils;

    }

	@Override
	public ResultUtils utop(Long id) {
		ResultUtils resultUtils = new ResultUtils();
        ServerInfoManager serverInfoManager = baseMapper.selectById(id);
        serverInfoManager.setServerIsTop("1");
		Integer i =  baseMapper.updateById(serverInfoManager);
		if(i > 0){
			resultUtils.setStatus(200);
			resultUtils.setMessage("置顶成功");
		}else{
			resultUtils.setStatus(200);
			resultUtils.setMessage("置顶失败");
		}
		return resultUtils;
	}

	@Override
	public ResultUtils ntop(Long id) {
		ResultUtils resultUtils = new ResultUtils();
		 ServerInfoManager serverInfoManager = baseMapper.selectById(id);
        serverInfoManager.setServerIsTop("0");
		Integer i =  baseMapper.updateById(serverInfoManager);
		if(i > 0){
			resultUtils.setStatus(200);
			resultUtils.setMessage("取消置顶成功");
		}else{
			resultUtils.setStatus(200);
			resultUtils.setMessage("取消置顶失败");
		}
		return resultUtils;
	}

	@Override
	public ResultUtils add(ServerInfoManager serverInfoManager) {
		ResultUtils resultUtils = new ResultUtils();
        ServerInfoManager serverInfoType1 = new ServerInfoManager();
		serverInfoType1.setCreateTime(new Date());
		serverInfoType1.setUpdateTime(new Date());
		serverInfoType1.setServerTypeId(serverInfoManager.getServerTypeId());
		serverInfoType1.setServerCover(serverInfoManager.getServerCover());
		serverInfoType1.setServerTitle(serverInfoManager.getServerTitle());
		serverInfoType1.setServerPrice(serverInfoManager.getServerPrice());
		serverInfoType1.setCity(serverInfoManager.getCity());
		serverInfoType1.setWidth(serverInfoManager.getWidth());
		serverInfoType1.setServerIntroduce(serverInfoManager.getServerIntroduce());
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
	public ResultUtils updateData(ServerInfoManager serverInfoManager) {
		 ResultUtils resultUtils = new ResultUtils();
		serverInfoManager.setUpdateTime(new Date());
		Integer i =  baseMapper.updateById(serverInfoManager);
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