package com.qiqi.jiaoyou.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qiqi.jiaoyou.pojo.BankManage;
import com.qiqi.jiaoyou.pojo.GameSelectLabel;
import com.qiqi.jiaoyou.util.ResultUtils;

import java.util.List;
import java.util.Map;

/**
 * 银行卡管理(BankManage)表服务接口
 *
 * @author nan
 * @since 2020-12-04 18:38:34
 */
public interface BankManageService extends IService<BankManage> {

    /**
     * id查询数据
     *
     * @param id id
     * @return ResultUtils
     */
    ResultUtils findById(Long id);


    /**
     *
     * 添加
     *
     * @param  bankManage
     * @return ResultUtils
     */
    ResultUtils add(BankManage bankManage);

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
     * @param bankManage
     * @return ResultUtils
     */
    ResultUtils updateData(BankManage bankManage);

    List<GameSelectLabel> getAll();


    /**
     * 查询分页数据
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