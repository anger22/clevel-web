package com.qiqi.jiaoyou.serviceImpl;

import com.qiqi.jiaoyou.pojo.Diamondconsumptionrecord;
import com.qiqi.jiaoyou.mapper.DiamondconsumptionrecordMapper;
import com.qiqi.jiaoyou.service.IDiamondconsumptionrecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.qiqi.jiaoyou.util.ResultUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 * <p>
 * 钻石消费记录 服务实现类 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
@Service
public class DiamondconsumptionrecordServiceImpl extends ServiceImpl<DiamondconsumptionrecordMapper, Diamondconsumptionrecord> implements IDiamondconsumptionrecordService {

    @Override
    public ResultUtils findListByPage(Integer page, Integer limit,Map<String,String>map){
        ResultUtils resultUtils = new ResultUtils();
        IPage<Diamondconsumptionrecord> wherePage = new Page<>(page, limit);
        QueryWrapper<Diamondconsumptionrecord> wrapper = Wrappers.query();
        for (String key : map.keySet()) {
            wrapper.like(key,map.get(key));
        }
            wrapper.orderByDesc("id");

        IPage<Diamondconsumptionrecord> list =   baseMapper.selectPage(wherePage, wrapper);
        resultUtils.setData(list.getRecords());
        resultUtils.setMessage("查询成功");
        resultUtils.setStatus(200);
        resultUtils.setCode(0);
        resultUtils.setCount((int)list.getTotal());
        return resultUtils;
    }

    @Override
    public ResultUtils add(Diamondconsumptionrecord diamondconsumptionrecord){
        ResultUtils resultUtils = new ResultUtils();
        Integer i =  baseMapper.insert(diamondconsumptionrecord);
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
    public ResultUtils updateData(Diamondconsumptionrecord diamondconsumptionrecord){
        ResultUtils resultUtils = new ResultUtils();
        Integer i =  baseMapper.updateById(diamondconsumptionrecord);
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
        Diamondconsumptionrecord obj = baseMapper.selectById(id);
        resultUtils.setData(obj);
        resultUtils.setStatus(200);
        resultUtils.setMessage("查询成功");
        return resultUtils;
    }
}
