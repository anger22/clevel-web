package com.qiqi.jiaoyou.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiqi.jiaoyou.mapper.CircleOfFriendsMapper;
import com.qiqi.jiaoyou.pojo.CircleOfFriends;
import com.qiqi.jiaoyou.service.ICircleOfFriendsService;
import com.qiqi.jiaoyou.util.ResultUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 朋友圈动态 服务实现类 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
@Service
public class CircleOfFriendsServiceImpl extends ServiceImpl<CircleOfFriendsMapper, CircleOfFriends> implements ICircleOfFriendsService {

    @Override
    public ResultUtils findListByPage(Integer page, Integer limit,Map<String,String>map){
        ResultUtils resultUtils = new ResultUtils();
        IPage<CircleOfFriends> wherePage = new Page<>(page, limit);
        QueryWrapper<CircleOfFriends> wrapper = Wrappers.query();
        for (String key : map.keySet()) {
            wrapper.like(key,map.get(key));
        }
            wrapper.orderByDesc("id");

        IPage<CircleOfFriends> list =   baseMapper.selectPage(wherePage, wrapper);
        resultUtils.setData(list.getRecords());
        resultUtils.setMessage("查询成功");
        resultUtils.setStatus(200);
        resultUtils.setCode(0);
        resultUtils.setCount((int)list.getTotal());
        return resultUtils;
    }

    @Override
    public ResultUtils add(CircleOfFriends circleOfFriends){
        ResultUtils resultUtils = new ResultUtils();
        Integer i =  baseMapper.insert(circleOfFriends);
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
    public ResultUtils updateData(CircleOfFriends circleOfFriends){
        ResultUtils resultUtils = new ResultUtils();
        Integer i =  baseMapper.updateById(circleOfFriends);
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
        CircleOfFriends obj = baseMapper.selectById(id);
        resultUtils.setData(obj);
        resultUtils.setStatus(200);
        resultUtils.setMessage("查询成功");
        return resultUtils;
    }

    @Override
    public Boolean deleteMemberInfo(String memberId) {
        QueryWrapper<CircleOfFriends> wrapper = new QueryWrapper<>();
        wrapper.eq("memerId",memberId);
        int i = baseMapper.delete(wrapper);
        if(i > 0){
            return  true;
        }
        return false;
    }
}
