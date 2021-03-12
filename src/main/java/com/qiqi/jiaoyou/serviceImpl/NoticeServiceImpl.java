package com.qiqi.jiaoyou.serviceImpl;

import com.qiqi.jiaoyou.pojo.Account;
import com.qiqi.jiaoyou.pojo.Notice;
import com.qiqi.jiaoyou.mapper.NoticeMapper;
import com.qiqi.jiaoyou.service.INoticeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiqi.jiaoyou.utils.JpushUtil;
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
 * 公告表 服务实现类 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements INoticeService {

    @Override
    public ResultUtils findListByPage(Integer page, Integer limit,Map<String,String>map){
        ResultUtils resultUtils = new ResultUtils();
        IPage<Notice> wherePage = new Page<>(page, limit);
        QueryWrapper<Notice> wrapper = Wrappers.query();
        for (String key : map.keySet()) {
            wrapper.like(key,map.get(key));
        }
            wrapper.orderByDesc("id");

        IPage<Notice> list =   baseMapper.selectPage(wherePage, wrapper);
        resultUtils.setData(list.getRecords());
        resultUtils.setMessage("查询成功");
        resultUtils.setStatus(200);
        resultUtils.setCode(0);
        resultUtils.setCount((int)list.getTotal());
        return resultUtils;
    }

    @Override
    public ResultUtils add(Notice notice){
        ResultUtils resultUtils = new ResultUtils();
        notice.setAddTime(new Timestamp(System.currentTimeMillis()));
        notice.setType(1);
        Integer i =  baseMapper.insert(notice);
        if(i > 0){
            Map<String, String> xtrasparams = new HashMap<String, String>(); //扩展字段
            xtrasparams.put("id", notice.getId() + "");
            xtrasparams.put("type", 5 + "");
            JpushUtil.sendToAll(notice.getTitle(),notice.getTitle(),notice.getContext(),xtrasparams);
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
    public ResultUtils updateData(Notice notice){
        ResultUtils resultUtils = new ResultUtils();
        Integer i =  baseMapper.updateById(notice);
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
        Notice obj = baseMapper.selectById(id);
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
        Notice notice = new Notice();
        notice.setId(id);
        int i = baseMapper.updateById(notice);
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
