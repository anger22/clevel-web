package com.qiqi.jiaoyou.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qiqi.jiaoyou.pojo.Club;

/**
 * 俱乐部(Club)表服务接口
 *
 * @author makejava
 * @since 2020-12-30 19:30:05
 */
public interface ClubService extends IService<Club> {

    Boolean deleteInfo(String memberId);
}