package com.qiqi.jiaoyou.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiqi.jiaoyou.mapper.LoveHeartDonationDao;
import com.qiqi.jiaoyou.pojo.LoveHeartDonation;
import com.qiqi.jiaoyou.service.LoveHeartDonationService;
import com.qiqi.jiaoyou.util.ResultUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * 爱心捐赠(LoveHeartDonation)表服务实现类
 *
 * @author makejava
 * @since 2020-11-30 11:17:45
 */
@Service("loveHeartDonationService")
public class LoveHeartDonationServiceImpl extends ServiceImpl<LoveHeartDonationDao, LoveHeartDonation> implements LoveHeartDonationService {


    @Override
    public ResultUtils findListByPage(Integer page, Integer limit, Map<String, String> map) {
        ResultUtils resultUtils = new ResultUtils();
        IPage<LoveHeartDonation> wherePage = new Page<>(page, limit);
        QueryWrapper<LoveHeartDonation> wrapper = Wrappers.query();
        for (String key : map.keySet()) {
            wrapper.like(key,map.get(key));
        }
        wrapper.orderByAsc("update_time");

        IPage<LoveHeartDonation> list =   baseMapper.selectPage(wherePage, wrapper);

        resultUtils.setData(list.getRecords());
        resultUtils.setMessage("查询成功");
        resultUtils.setStatus(200);
        resultUtils.setCode(0);
        resultUtils.setCount((int)list.getTotal());
        return resultUtils;
    }



	@Override
    public ResultUtils add(LoveHeartDonation loveHeartDonation) {
      ResultUtils resultUtils = new ResultUtils();
		LoveHeartDonation gameBank1 = new LoveHeartDonation();
		gameBank1.setCreateTime(new Date());
		gameBank1.setUpdateTime(new Date());
		gameBank1.setLoveTitle(loveHeartDonation.getLoveTitle());
		gameBank1.setLoveExplain(loveHeartDonation.getLoveExplain());
		gameBank1.setLoveState("0");
		gameBank1.setLoveCover(loveHeartDonation.getLoveCover());
		gameBank1.setLoveNeedMoney(loveHeartDonation.getLoveNeedMoney());
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
	public ResultUtils findById(Long id) {
		ResultUtils resultUtils = new ResultUtils();
		LoveHeartDonation obj = baseMapper.selectById(id);
		resultUtils.setData(obj);
		resultUtils.setStatus(200);
		resultUtils.setMessage("查询成功");
		return resultUtils;
	}

	@Override
    public ResultUtils delete(Long id) {
        ResultUtils resultUtils = new ResultUtils();
        LoveHeartDonation obj = baseMapper.selectById(id);
        /*0正常，1删除*/
        obj.setLoveState("1");
        obj.setId(Integer.parseInt(id.toString()));
		Integer i =  baseMapper.updateById(obj);
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
    public ResultUtils updateData(LoveHeartDonation loveHeartDonation) {
        ResultUtils resultUtils = new ResultUtils();
		loveHeartDonation.setUpdateTime(new Date());
		Integer i =  baseMapper.updateById(loveHeartDonation);
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