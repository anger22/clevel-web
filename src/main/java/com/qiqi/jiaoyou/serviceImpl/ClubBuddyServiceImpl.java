package com.qiqi.jiaoyou.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiqi.jiaoyou.mapper.ClubBuddyDao;
import com.qiqi.jiaoyou.pojo.ClubBuddy;
import com.qiqi.jiaoyou.service.ClubBuddyService;
import org.springframework.stereotype.Service;

/**
 * 俱乐部好友表(ClubBuddy)表服务实现类
 *
 * @author makejava
 * @since 2020-12-30 19:43:19
 */
@Service("clubBuddyService")
public class ClubBuddyServiceImpl extends ServiceImpl<ClubBuddyDao, ClubBuddy> implements ClubBuddyService {

    @Override
    public Boolean deleteInfoById(String  memberId) {
        QueryWrapper<ClubBuddy> wrapper = new QueryWrapper<>();
        wrapper.eq("oneself_id",memberId).or()
                .eq("member_id",memberId);
        int bl = baseMapper.delete(wrapper);
        if(bl > 0){
            return  true;
        }
        return false;
    }
}