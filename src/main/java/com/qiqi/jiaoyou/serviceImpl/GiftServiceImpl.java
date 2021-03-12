package com.qiqi.jiaoyou.serviceImpl;

import com.qiqi.jiaoyou.pojo.Gift;
import com.qiqi.jiaoyou.mapper.GiftMapper;
import com.qiqi.jiaoyou.pojo.SystemMessage;
import com.qiqi.jiaoyou.service.IGiftService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.qiqi.jiaoyou.util.ResultUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 * <p>
 * 礼物表 服务实现类 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
@Service
public class GiftServiceImpl extends ServiceImpl<GiftMapper, Gift> implements IGiftService {

    @Override
    public ResultUtils findListByPage(Integer page, Integer limit,Map<String,String>map){
        ResultUtils resultUtils = new ResultUtils();
        IPage<Gift> wherePage = new Page<>(page, limit);
        QueryWrapper<Gift> wrapper = Wrappers.query();
        for (String key : map.keySet()) {
            wrapper.like(key,map.get(key));
        }
            wrapper.orderByDesc("id");

        IPage<Gift> list =   baseMapper.selectPage(wherePage, wrapper);
        resultUtils.setData(list.getRecords());
        resultUtils.setMessage("查询成功");
        resultUtils.setStatus(200);
        resultUtils.setCode(0);
        resultUtils.setCount((int)list.getTotal());
        return resultUtils;
    }

    @Override
    public ResultUtils add(Gift gift){
        ResultUtils resultUtils = new ResultUtils();
        gift.setAddTime(new Timestamp(System.currentTimeMillis()));
        gift.setDeleteState(2);
        gift.setEnableState(1);
        Integer i =  baseMapper.insert(gift);
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
            resultUtils.setMessage("删除成功");
        }else{
            resultUtils.setStatus(200);
            resultUtils.setMessage("删除失败");
        }
        return resultUtils;
    }

    @Override
    public ResultUtils updateData(Gift gift){
        ResultUtils resultUtils = new ResultUtils();
        gift.setEditTime(new Timestamp(System.currentTimeMillis()));
        Integer i =  baseMapper.updateById(gift);
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
        Gift obj = baseMapper.selectById(id);
        resultUtils.setData(obj);
        resultUtils.setStatus(200);
        resultUtils.setMessage("查询成功");
        return resultUtils;
    }

    /**
     * 修改启用状态
     *
     * @param id
     * @param enableState
     */
    @Override
    public ResultUtils updateEnable(Integer id, Integer enableState) {
        ResultUtils resultUtils = new ResultUtils();
        Gift gift = new Gift();
        gift.setId(id);
        gift.setEnableState(enableState);
        int i = baseMapper.updateById(gift);
        if (i > 0){
            resultUtils.setMessage("修改成功");
            resultUtils.setStatus(200);
        }else {
            resultUtils.setMessage("修改失败");
            resultUtils.setStatus(500);
        }
        return resultUtils;
    }
}
