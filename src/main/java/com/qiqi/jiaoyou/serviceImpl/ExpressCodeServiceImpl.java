package com.qiqi.jiaoyou.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiqi.jiaoyou.mapper.ExpressCodeDao;
import com.qiqi.jiaoyou.pojo.ExpressCode;
import com.qiqi.jiaoyou.service.ExpressCodeService;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 快递公司编码(ExpressCode)表服务实现类
 *
 * @author makejava
 * @since 2020-12-08 17:41:47
 */
@Service("expressCodeService")
public class ExpressCodeServiceImpl extends ServiceImpl<ExpressCodeDao, ExpressCode> implements ExpressCodeService {

    @Override
    public String findCodeByName(String name) {
        QueryWrapper<ExpressCode> wrapper = new QueryWrapper<>();
        wrapper.eq("name",name);
        List<ExpressCode> list =  baseMapper.selectList(wrapper);
        return list.get(0).getCode();
    }
}