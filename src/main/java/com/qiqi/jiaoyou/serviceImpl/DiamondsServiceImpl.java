package com.qiqi.jiaoyou.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiqi.jiaoyou.pojo.Diamonds;
import com.qiqi.jiaoyou.mapper.DiamondsMapper;
import com.qiqi.jiaoyou.service.IDiamondsService;
import com.qiqi.jiaoyou.util.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author GR123
 * @since 2020-07-15
 */
@Service
public class DiamondsServiceImpl extends ServiceImpl<DiamondsMapper, Diamonds> implements IDiamondsService {
    @Autowired
    private DiamondsMapper diamondsMapper;

    @Override
    public ResultUtils add(Diamonds diamonds) {
        ResultUtils resultUtils = new ResultUtils();
        //1:苹果 2;安卓
        Integer diamondsTerminal = diamonds.getDiamondsTerminal();
        //1:黑卡 2：会员 3：钻石
        Integer diamondsType = diamonds.getDiamondsType();
        //查询该端的数据
        List<Diamonds> diamonds1 = diamondsMapper.selectList(new QueryWrapper<Diamonds>().eq("diamonds_terminal", diamondsTerminal).eq("diamonds_type", diamondsType));
        if (diamondsType == 1 && diamonds1.size() == 1){
            resultUtils.setMessage("黑卡最多只能有一条选择数据");
            resultUtils.setCount(500);
            return resultUtils;
        }
        if (diamondsType == 2 && diamonds1.size() == 3){
            resultUtils.setMessage("会员最多只能有三条选择数据");
            resultUtils.setCount(500);
            return resultUtils;
        }
        if (diamondsType == 3){
            if (diamondsTerminal == 1 && diamonds1.size() == 6){
                resultUtils.setMessage("钻石最多只能有六条选择数据");
                resultUtils.setCount(500);
                return resultUtils;
            }
            if (diamondsTerminal == 2 && diamonds1.size() == 5){
                resultUtils.setMessage("钻石最多只能有五条选择数据");
                resultUtils.setCount(500);
                return resultUtils;
            }
        }
        int insert = diamondsMapper.insert(diamonds);
        if (insert <= 0){
            resultUtils.setMessage("新增失败");
            resultUtils.setCount(500);
            return resultUtils;
        }
        if (diamondsTerminal == 1){
            resultUtils.setMessage("新增成功,请保证该数据与苹果开发平台数据一致");
        }else {
            resultUtils.setMessage("新增成功");
        }
        resultUtils.setCount(200);
        return resultUtils;

    }

    @Override
    public ResultUtils delete(Integer id) {
        ResultUtils resultUtils = new ResultUtils();
        int i = diamondsMapper.deleteById(id);
        if (i <= 0){
            resultUtils.setMessage("删除失败");
            resultUtils.setCount(500);
            return resultUtils;
        }
        resultUtils.setMessage("删除成功");
        resultUtils.setCount(200);
        return resultUtils;
    }

    @Override
    public ResultUtils updateData(Diamonds diamonds) {
        ResultUtils resultUtils = new ResultUtils();
        int insert = diamondsMapper.updateById(diamonds);
        if (insert <= 0){
            resultUtils.setMessage("编辑失败");
            resultUtils.setCount(500);
            return resultUtils;
        }
        if (diamonds.getDiamondsTerminal() == 1){
            resultUtils.setMessage("编辑成功,请保证该数据与苹果开发平台数据一致");
        }else {
            resultUtils.setMessage("编辑成功");
        }
        resultUtils.setCount(200);
        return resultUtils;
    }

    @Override
    public ResultUtils findListByPage(Integer page, Integer limit, Map<String, String> map) {
        ResultUtils resultUtils = new ResultUtils();
        IPage<Diamonds> wherePage = new Page<>(page, limit);
        QueryWrapper<Diamonds> wrapper = Wrappers.query();
        for (String key : map.keySet()) {
            wrapper.like(key,map.get(key));
        }
        wrapper.orderByDesc("diamonds_id");
        List<Diamonds> list = diamondsMapper.selectPage(wherePage,wrapper).getRecords();
        resultUtils.setData(list);
        resultUtils.setMessage("查询成功");
        resultUtils.setStatus(200);
        resultUtils.setCode(0);
        resultUtils.setCount((int)wherePage.getTotal());
        return resultUtils;
    }

    @Override
    public ResultUtils findById(Long id) {
        ResultUtils resultUtils = new ResultUtils();
        resultUtils.setData(diamondsMapper.selectById(id));
        resultUtils.setStatus(200);
        resultUtils.setMessage("查询成功");
        return resultUtils;
    }
}
