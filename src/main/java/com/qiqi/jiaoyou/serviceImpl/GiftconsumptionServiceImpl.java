package com.qiqi.jiaoyou.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiqi.jiaoyou.mapper.GiftconsumptionMapper;
import com.qiqi.jiaoyou.pojo.Giftconsumption;
import com.qiqi.jiaoyou.service.IGiftconsumptionService;
import com.qiqi.jiaoyou.util.ResultUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 礼物记录表 服务实现类 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
@Service
public class GiftconsumptionServiceImpl extends ServiceImpl<GiftconsumptionMapper, Giftconsumption> implements IGiftconsumptionService {

    @Override
    public ResultUtils findListByPage(Integer page, Integer limit,Map<String,String>map){
        ResultUtils resultUtils = new ResultUtils();
        IPage<Giftconsumption> wherePage = new Page<>(page, limit);
        QueryWrapper<Giftconsumption> wrapper = Wrappers.query();
        for (String key : map.keySet()) {
            wrapper.like(key,map.get(key)).or()
                    .eq("sendMemberId",map.get(key));
        }
            wrapper.orderByDesc("REVISION");

        IPage<Giftconsumption> list =   baseMapper.selectPage(wherePage, wrapper);
        resultUtils.setData(list.getRecords());
        resultUtils.setMessage("查询成功");
        resultUtils.setStatus(200);
        resultUtils.setCode(0);
        resultUtils.setCount((int)list.getTotal());
        return resultUtils;
    }

    @Override
    public ResultUtils add(Giftconsumption giftconsumption){
        ResultUtils resultUtils = new ResultUtils();
        Integer i =  baseMapper.insert(giftconsumption);
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
    public ResultUtils delete(Long id){
        ResultUtils resultUtils = new ResultUtils();
        Integer i =  baseMapper.deleteById(id);
        if(i > 0){
            resultUtils.setStatus(200);
            resultUtils.setMessage("编辑成功");
        }else{
            resultUtils.setStatus(200);
            resultUtils.setMessage("编辑失败");
        }
        return resultUtils;
    }

    @Override
    public ResultUtils updateData(Giftconsumption giftconsumption){
        ResultUtils resultUtils = new ResultUtils();
        Integer i =  baseMapper.updateById(giftconsumption);
        if(i > 0){
            resultUtils.setStatus(200);
            resultUtils.setMessage("编辑成功");
        }else{
            resultUtils.setStatus(200);
            resultUtils.setMessage("编辑失败");
        }
        return resultUtils;
    }

    @Override
    public ResultUtils findById(Long id){
        ResultUtils resultUtils = new ResultUtils();
        Giftconsumption obj = baseMapper.selectById(id);
        resultUtils.setData(obj);
        resultUtils.setStatus(200);
        resultUtils.setMessage("查询成功");
        return resultUtils;
    }
}
