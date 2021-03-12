package com.qiqi.jiaoyou.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qiqi.jiaoyou.pojo.MemberAssets;
import com.qiqi.jiaoyou.util.ResultUtils;

import java.util.Map;

/**
 * <p>
 * 会员资产表 服务类
 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
public interface IMemberAssetsService extends IService<MemberAssets> {

    /**
     * 查询会员资产表分页数据
     *
     * @param page      页码
     * @param limit 每页条数
     * @return ResultUtils
     */
    ResultUtils findListByPage(Integer page, Integer limit,Map<String,String>map);

    /**
     * 添加会员资产表
     *
     * @param memberAssets 会员资产表
     * @return ResultUtils
     */
    ResultUtils add(MemberAssets memberAssets);

    /**
     * 删除会员资产表
     *
     * @param id 主键
     * @return ResultUtils
     */
    ResultUtils delete(Long id);

    /**
     * 修改会员资产表
     *
     * @param memberAssets 会员资产表
     * @return ResultUtils
     */
    ResultUtils updateData(MemberAssets memberAssets);

    /**
     * id查询数据
     *
     * @param id id
     * @return ResultUtils
     */
    ResultUtils findById(Long id);

    MemberAssets findByMemberId(Long id);

}
