package com.qiqi.jiaoyou.service;

import com.qiqi.jiaoyou.pojo.Notice;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qiqi.jiaoyou.util.ResultUtils;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 公告表 服务类
 * </p>
 *
 * @author sunlaiqian
 * @since 2020-04-22
 */
public interface INoticeService extends IService<Notice> {

    /**
     * 查询公告表分页数据
     *
     * @param page      页码
     * @param limit 每页条数
     * @return ResultUtils
     */
    ResultUtils findListByPage(Integer page, Integer limit,Map<String,String>map);

    /**
     * 添加公告表
     *
     * @param notice 公告表
     * @return ResultUtils
     */
    ResultUtils add(Notice notice);

    /**
     * 删除公告表
     *
     * @param id 主键
     * @return ResultUtils
     */
    ResultUtils delete(Long id);

    /**
     * 修改公告表
     *
     * @param notice 公告表
     * @return ResultUtils
     */
    ResultUtils updateData(Notice notice);

    /**
     * id查询数据
     *
     * @param id id
     * @return ResultUtils
     */
    ResultUtils findById(Long id);

    /**
     * 修改启用状态
     */
    ResultUtils updateEnable(Integer id, Integer enableState);
}
