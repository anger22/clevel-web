package com.qiqi.jiaoyou.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qiqi.jiaoyou.pojo.GameSelectLabel;
import com.qiqi.jiaoyou.util.ResultUtils;

import java.util.List;
import java.util.Map;

/**
 * 答题游戏库选项标签(GameSelectLabel)表服务接口
 *
 * @author makejava
 * @since 2020-11-27 11:25:35
 */
public interface GameSelectLabelService extends IService<GameSelectLabel> {
/**
     * id查询数据
     *
     * @param id id
     * @return ResultUtils
     */
    ResultUtils findById(Long id);


    /**
     *
     * 添加礼物表
     *
     * @param  gameSelectLabel 礼物表
     * @return ResultUtils
     */
    ResultUtils add(GameSelectLabel gameSelectLabel);

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
     * @param gameSelectLabel 礼物表
     * @return ResultUtils
     */
    ResultUtils updateData(GameSelectLabel gameSelectLabel);

    List<GameSelectLabel> getAll();


    /**
     * 查询礼物表分页数据
     *
     * @param page      页码
     * @param limit 每页条数
     * @return ResultUtils
     */
    ResultUtils findListByPage(Integer page, Integer limit, Map<String,String> map);
    /**
     * 查询标签选项表的所有数据
     * @return ResultUtils
     */
    ResultUtils findListByAll();
}