package com.qiqi.jiaoyou.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiqi.jiaoyou.mapper.BankManageDao;
import com.qiqi.jiaoyou.pojo.BankManage;
import com.qiqi.jiaoyou.pojo.GameSelectLabel;
import com.qiqi.jiaoyou.service.BankManageService;
import com.qiqi.jiaoyou.util.ResultUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 银行卡管理(BankManage)表服务实现类
 *
 * @author nan
 * @since 2020-12-04 18:38:34
 */
@Service("bankManageService")
public class BankManageServiceImpl extends ServiceImpl<BankManageDao, BankManage> implements BankManageService {

    @Override
    public ResultUtils findById(Long id) {
        ResultUtils resultUtils = new ResultUtils();
		BankManage obj = baseMapper.selectById(id);
		resultUtils.setData(obj);
		resultUtils.setStatus(200);
		resultUtils.setMessage("查询成功");
		return resultUtils;
    }

    @Override
    public ResultUtils add(BankManage bankManage) {
        ResultUtils resultUtils = new ResultUtils();
		bankManage.setCreateTime(new Date());
		bankManage.setUpdateTime(new Date());
		bankManage.setBankName(bankManage.getBankName());
		bankManage.setBankIcon(bankManage.getBankIcon());
		bankManage.setBankSort(bankManage.getBankSort());
		bankManage.setBankColor1(bankManage.getBankColor1());
		bankManage.setBankColor2(bankManage.getBankColor2());
		Integer i =  baseMapper.insert(bankManage);
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
    public ResultUtils updateData(BankManage bankManage) {
      ResultUtils resultUtils = new ResultUtils();
		bankManage.setUpdateTime(new Date());
		bankManage.setBankName(bankManage.getBankName());
		bankManage.setBankIcon(bankManage.getBankIcon());
		bankManage.setBankSort(bankManage.getBankSort());
		bankManage.setBankColor1(bankManage.getBankColor1());
		bankManage.setBankColor2(bankManage.getBankColor2());
		Integer i =  baseMapper.updateById(bankManage);
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
        return null;
    }

    @Override
    public ResultUtils findListByPage(Integer page, Integer limit, Map<String, String> map) {
       ResultUtils resultUtils = new ResultUtils();
		IPage<BankManage> wherePage = new Page<>(page, limit);
		QueryWrapper<BankManage> wrapper = Wrappers.query();
		for (String key : map.keySet()) {
			wrapper.like(key,map.get(key));
		}
		wrapper.orderByAsc("bankSort");

		IPage<BankManage> list =   baseMapper.selectPage(wherePage, wrapper);
		resultUtils.setData(list.getRecords());
		resultUtils.setMessage("查询成功");
		resultUtils.setStatus(200);
		resultUtils.setCode(0);
		resultUtils.setCount((int)list.getTotal());
		return resultUtils;
    }

    @Override
    public ResultUtils findListByAll() {
        return null;
    }
}