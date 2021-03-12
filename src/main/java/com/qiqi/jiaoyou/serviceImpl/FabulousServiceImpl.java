package com.qiqi.jiaoyou.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiqi.jiaoyou.mapper.FabulousDao;
import com.qiqi.jiaoyou.pojo.Fabulous;
import com.qiqi.jiaoyou.service.FabulousService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * 朋友圈动态点赞信息记录表(Fabulous)表服务实现类
 *
 * @author makejava
 * @since 2020-12-30 20:29:21
 */
@Service("fabulousService")
public class FabulousServiceImpl extends ServiceImpl<FabulousDao, Fabulous> implements FabulousService {

    @Override
    public Boolean deleteInfo(String memberId) {
        QueryWrapper<Fabulous> wrapper = new QueryWrapper<>();
        wrapper.eq("memberId",memberId);
        int bl = baseMapper.delete(wrapper);
        if(bl > 0){
            return  true;
        }
        return false;
    }

    @Override
    public boolean save(Fabulous entity) {
        return false;
    }

    @Override
    public boolean saveBatch(Collection<Fabulous> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<Fabulous> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean remove(Wrapper<Fabulous> queryWrapper) {
        return false;
    }

    @Override
    public boolean updateById(Fabulous entity) {
        return false;
    }

    @Override
    public boolean update(Fabulous entity, Wrapper<Fabulous> updateWrapper) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<Fabulous> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(Fabulous entity) {
        return false;
    }

    @Override
    public Fabulous getOne(Wrapper<Fabulous> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<Fabulous> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<Fabulous> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public int count(Wrapper<Fabulous> queryWrapper) {
        return 0;
    }

    @Override
    public List<Fabulous> list(Wrapper<Fabulous> queryWrapper) {
        return null;
    }

    @Override
    public IPage<Fabulous> page(IPage<Fabulous> page, Wrapper<Fabulous> queryWrapper) {
        return null;
    }

    @Override
    public List<Map<String, Object>> listMaps(Wrapper<Fabulous> queryWrapper) {
        return null;
    }

    @Override
    public <V> List<V> listObjs(Wrapper<Fabulous> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public IPage<Map<String, Object>> pageMaps(IPage<Fabulous> page, Wrapper<Fabulous> queryWrapper) {
        return null;
    }
}