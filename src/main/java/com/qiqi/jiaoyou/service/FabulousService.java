package com.qiqi.jiaoyou.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qiqi.jiaoyou.pojo.Fabulous;

/**
 * 朋友圈动态点赞信息记录表(Fabulous)表服务接口
 *
 * @author makejava
 * @since 2020-12-30 20:29:21
 */
public interface FabulousService extends IService<Fabulous> {

    Boolean deleteInfo(String memberId);
}