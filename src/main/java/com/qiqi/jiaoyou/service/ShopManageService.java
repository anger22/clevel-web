package com.qiqi.jiaoyou.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qiqi.jiaoyou.pojo.ShopManage;
import com.qiqi.jiaoyou.util.ResultUtils;

import java.util.Map;

/**
 * 商品管理(ShopManage)表服务接口
 *
 * @author makejava
 * @since 2020-12-02 17:19:51
 */
public interface ShopManageService extends IService<ShopManage> {
   /**
     * 查询表分页数据
     *
     * @param page      页码
     * @param limit 每页条数
     * @return ResultUtils
     */
    ResultUtils findListByPage(Integer page, Integer limit, Map<String,String> map);
/**
     * id查询数据
     *
     * @param id id
     * @return ResultUtils
     */
    ResultUtils findById(Long id);


    /**
     * 置顶操作
     *
     * @param id id
     * @return ResultUtils
     */
    ResultUtils utop(Long id);


/**
     * 取消置顶
     *
     * @param id id
     * @return ResultUtils
     */
    ResultUtils ntop(Long id);
/**
     *
     * 添加
     *
     * @param  shopManage
     * @return ResultUtils
     */
    ResultUtils add(ShopManage shopManage);
    /**
     * 删除
     *
     * @param id 主键
     * @return ResultUtils
     */
    ResultUtils delete(Long id);

    /**
     * 修改
     *
     * @param shopManage
     * @return ResultUtils
     */
    ResultUtils updateData(ShopManage shopManage);
}