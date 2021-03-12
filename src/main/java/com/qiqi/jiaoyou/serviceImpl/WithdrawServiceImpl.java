package com.qiqi.jiaoyou.serviceImpl;

import com.qiqi.jiaoyou.mapper.MemberAssetsMapper;
import com.qiqi.jiaoyou.pojo.MemberAssets;
import com.qiqi.jiaoyou.pojo.Withdraw;
import com.qiqi.jiaoyou.mapper.WithdrawMapper;
import com.qiqi.jiaoyou.service.IWithdrawService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.qiqi.jiaoyou.util.ResultUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 * <p>
 * 提现申请表 服务实现类 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
@Service
public class WithdrawServiceImpl extends ServiceImpl<WithdrawMapper, Withdraw> implements IWithdrawService {

    @Autowired
    private MemberAssetsMapper memberAssetsMapper;

    @Override
    public ResultUtils findListByPage(Integer page, Integer limit,Map<String,String>map){
        ResultUtils resultUtils = new ResultUtils();
        IPage<Withdraw> wherePage = new Page<>(page, limit);
        QueryWrapper<Withdraw> wrapper = Wrappers.query();
        for (String key : map.keySet()) {
            wrapper.like(key,map.get(key));
        }
            wrapper.eq("oldOrNew",1);
            wrapper.orderByDesc("id");

        IPage<Withdraw> list =   baseMapper.selectPage(wherePage, wrapper);
        resultUtils.setData(list.getRecords());
        resultUtils.setMessage("查询成功");
        resultUtils.setStatus(200);
        resultUtils.setCode(0);
        resultUtils.setCount((int)list.getTotal());
        return resultUtils;
    }

    @Override
    public ResultUtils add(Withdraw withdraw){
        ResultUtils resultUtils = new ResultUtils();
        Integer i =  baseMapper.insert(withdraw);
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
    public ResultUtils updateData(Withdraw withdraw){
        ResultUtils resultUtils = new ResultUtils();
        boolean a = false;
        //原纪录改变审核状态
        withdraw.setIsExamine(1);
        //审核时间
        withdraw.setExamineTime(new Timestamp(System.currentTimeMillis()));
        Integer i =  baseMapper.updateById(withdraw);
        if (i > 0){
            a = true;
        }
        if (withdraw.getExamineState() == 2){
            //新增一条记录
            Withdraw withdraw1 = baseMapper.selectById(withdraw.getId());
            //标记为新数据
            withdraw1.setOldOrNew(2);
            //将ID设为NULL
            withdraw1.setId(null);
            int insert = baseMapper.insert(withdraw1);
            if (insert > 0){
                //表示审核没有通过  原钻石返回
                withdraw = baseMapper.selectById(withdraw.getId());
                MemberAssets memberAssets = memberAssetsMapper.selectList(new QueryWrapper<MemberAssets>().eq("memberId", withdraw.getMemberId())).get(0);
                long size = memberAssets.getMemberDiamondsizeOfBlack() + (withdraw.getPrice().divide(withdraw.getProportion())).intValue();
                memberAssets.setMemberDiamondsizeOfBlack(size);
                Integer integer = memberAssetsMapper.updateById(memberAssets);
                withdraw.setBalance(new BigDecimal(size).multiply(withdraw.getProportion()));
                baseMapper.updateById(withdraw);
                a = true;
            }else {
                a = false;
            }
        }

        if (a){
            resultUtils.setMessage("审核记录成功");
            resultUtils.setStatus(200);
        }else {
            resultUtils.setStatus(500);
            resultUtils.setMessage("审核记录失败");
        }
        return resultUtils;
    }

    @Override
    public ResultUtils findById(Long id){
        ResultUtils resultUtils = new ResultUtils();
        Withdraw obj = baseMapper.selectById(id);
        resultUtils.setData(obj);
        resultUtils.setStatus(200);
        resultUtils.setMessage("查询成功");
        return resultUtils;
    }
}
