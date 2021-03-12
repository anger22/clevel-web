package com.qiqi.jiaoyou.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiqi.jiaoyou.mapper.SystemMessageMapper;
import com.qiqi.jiaoyou.pojo.SystemMessage;
import com.qiqi.jiaoyou.service.ISystemMessageService;
import com.qiqi.jiaoyou.util.ResultUtils;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Map;

/**
 * <p>
 * 系统消息表 服务实现类 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
@Service
public class SystemMessageServiceImpl extends ServiceImpl<SystemMessageMapper, SystemMessage> implements ISystemMessageService {

    @Override
    public ResultUtils findListByPage(Integer page, Integer limit,Map<String,String>map){
        ResultUtils resultUtils = new ResultUtils();
        IPage<SystemMessage> wherePage = new Page<>(page, limit);
        QueryWrapper<SystemMessage> wrapper = Wrappers.query();
        for (String key : map.keySet()) {
            if (key.equals("title")){
                wrapper.eq("title",map.get("title"));
                continue;
            }
            wrapper.like(key,map.get(key));
        }

            wrapper.orderByDesc("id");

        IPage<SystemMessage> list =   baseMapper.selectPage(wherePage, wrapper);
        resultUtils.setData(list.getRecords());
        resultUtils.setMessage("查询成功");
        resultUtils.setStatus(200);
        resultUtils.setCode(0);
        resultUtils.setCount((int)list.getTotal());
        return resultUtils;
    }


    /*新增系统消息*/
    @Override
    public ResultUtils add(SystemMessage systemMessage){
        ResultUtils resultUtils = new ResultUtils();
        systemMessage.setAddTime(new Timestamp(System.currentTimeMillis()));
        systemMessage.setDeleteState(2);
        systemMessage.setEnableState(1);
        Integer i =  baseMapper.insert(systemMessage);
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
    public ResultUtils updateData(SystemMessage systemMessage){
        ResultUtils resultUtils = new ResultUtils();
        systemMessage.setEditTime(new Timestamp(System.currentTimeMillis()));
        Integer i =  baseMapper.updateById(systemMessage);
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
        SystemMessage obj = baseMapper.selectById(id);
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
        SystemMessage systemMessage = new SystemMessage();
        systemMessage.setId(id);
        systemMessage.setEnableState(enableState);
        int i = baseMapper.updateById(systemMessage);
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
