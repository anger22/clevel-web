package com.qiqi.jiaoyou.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiqi.jiaoyou.mapper.ClubDao;
import com.qiqi.jiaoyou.pojo.Club;
import com.qiqi.jiaoyou.service.ClubService;
import org.springframework.stereotype.Service;

/**
 * 俱乐部(Club)表服务实现类
 *
 * @author makejava
 * @since 2020-12-30 19:30:05
 */
@Service("clubService")
public class ClubServiceImpl extends ServiceImpl<ClubDao, Club> implements ClubService {

    @Override
    public Boolean deleteInfo(String memberId) {
        QueryWrapper<Club> wrapper = new QueryWrapper<>();
        wrapper.eq("memberId",memberId);
        int bl = baseMapper.delete(wrapper);
        if(bl > 0){
            return  true;
        }
        return false;
    }
}