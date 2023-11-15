package com.gec.wiki.controller;


import com.gec.wiki.req.CategoryQueryReq;
import com.gec.wiki.resp.CategoryQueryResp;
import com.gec.wiki.resp.CommonResp;
import com.gec.wiki.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 
 * @since 2023-11-01
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @RequestMapping("/allList")
    public CommonResp allList(CategoryQueryReq req){
        List<CategoryQueryResp>  categoryQueryResps= categoryService.allList(req);

        CommonResp<List<CategoryQueryResp>> resp = new CommonResp<>();

        resp.setContent(categoryQueryResps);
        return resp;



    }
}
