package com.qiqi.jiaoyou.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qiqi.jiaoyou.pojo.ClubBuddy;

/**
 * 俱乐部好友表(ClubBuddy)表服务接口
 *
 * @author makejava
 * @since 2020-12-30 19:43:19
 */
public interface ClubBuddyService extends IService<ClubBuddy> {


    /**
     * 删除用户的俱乐部好友信息
     * @param memberId
     * @return
     */
    Boolean deleteInfoById(String memberId);

}