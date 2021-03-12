package com.qiqi.jiaoyou.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qiqi.jiaoyou.pojo.ExpressCode;

/**
 * 快递公司编码(ExpressCode)表服务接口
 *
 * @author makejava
 * @since 2020-12-08 17:41:47
 */
public interface ExpressCodeService extends IService<ExpressCode> {

    String findCodeByName(String name);

}