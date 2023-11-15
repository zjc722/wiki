package com.gec.wiki.service;

import com.gec.wiki.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gec.wiki.req.CategoryQueryReq;
import com.gec.wiki.resp.CategoryQueryResp;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2023-11-01
 */
public interface ICategoryService extends IService<Category> {

    List<CategoryQueryResp> allList (CategoryQueryReq req);



}
