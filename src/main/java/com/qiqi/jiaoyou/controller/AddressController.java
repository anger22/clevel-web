package com.qiqi.jiaoyou.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qiqi.jiaoyou.pojo.Address;
import com.qiqi.jiaoyou.service.AddressService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 地址管理表(Address)表控制层
 *
 * @author makejava
 * @since 2020-12-03 16:59:09
 */
@RestController
@RequestMapping("address")
public class AddressController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private AddressService addressService;

    /**
     * 分页查询所有数据
     *
     * @param page    分页对象
     * @param address 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Address> page, Address address) {
        return success(this.addressService.page(page, new QueryWrapper<>(address)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.addressService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param address 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Address address) {
        return success(this.addressService.save(address));
    }

    /**
     * 修改数据
     *
     * @param address 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Address address) {
        return success(this.addressService.updateById(address));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.addressService.removeByIds(idList));
    }
}