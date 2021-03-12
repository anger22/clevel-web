package com.qiqi.jiaoyou.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qiqi.jiaoyou.pojo.GameBank;
import com.qiqi.jiaoyou.pojo.Gift;
import com.qiqi.jiaoyou.util.ResultUtils;

import java.util.Map;

/**
 * 答题游戏题库(GameBank)表服务接口
 *
 * @author makejava
 * @since 2020-11-27 11:12:53
 */
public interface GameBankService extends IService<GameBank> {
 /**
     * id查询数据
     *
     * @param id id
     * @return ResultUtils
     */
    ResultUtils findById(Long id);

    /**
     * 查询礼物表分页数据
     *
     * @param page      页码
     * @param limit 每页条数
     * @return ResultUtils
     */
    ResultUtils findListByPage(Integer page, Integer limit, Map<String,String> map);
    /**
     * 查询所有分页数据
     *
     * @return ResultUtils
     */
    ResultUtils findListByAll();

    /**
     * 添加礼物表
     *
     * @param  gameBank 礼物表
     * @return ResultUtils
     */
    ResultUtils add(GameBank gameBank);

    /**
     * 删除礼物表
     *
     * @param id 主键
     * @return ResultUtils
     */
    ResultUtils delete(Long id);

    /**
     * 修改礼物表
     *
     * @param gameBank 礼物表
     * @return ResultUtils
     */
    ResultUtils updateData(GameBank gameBank);
}