package com.gec.wiki.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gec.wiki.entity.Category;
import com.gec.wiki.mapper.CategoryMapper;
import com.gec.wiki.req.CategoryQueryReq;
import com.gec.wiki.resp.CategoryQueryResp;
import com.gec.wiki.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gec.wiki.utils.CopyUtil;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 
 * @since 2023-11-01
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

    @Override
    public List<CategoryQueryResp> allList(CategoryQueryReq req) {
        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("sort");
        List<Category> list = this.list(wrapper);

        List<CategoryQueryResp> categoryQueryResps = CopyUtil.copyList(list, CategoryQueryResp.class);

        return categoryQueryResps;
    }
}
