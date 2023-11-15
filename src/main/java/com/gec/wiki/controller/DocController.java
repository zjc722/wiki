package com.gec.wiki.controller;


import com.gec.wiki.req.DocQueryReq;
import com.gec.wiki.resp.CommonResp;
import com.gec.wiki.resp.DocQueryResp;
import com.gec.wiki.resp.PageRsep;
import com.gec.wiki.service.IDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 
 * @since 2023-11-13
 */
@RestController
@RequestMapping("/doc")
public class DocController {
    @Autowired
    private IDocService docService;

    @GetMapping("/getDocListByPage")
    public CommonResp getDocListByPage(DocQueryReq req){
//        PageResp<DocQueryResp> repsPage = docService.getDocListByPage(req);
        PageRsep<DocQueryResp> repsPage = docService.getDocListByPage(req);
//        CommonResp<PageResp<DocQueryResp>> resp = new CommonResp<>();
        CommonResp<PageRsep<DocQueryResp>> resp = new CommonResp<>();
        resp.setContent(repsPage);
        return resp;
    }

    @GetMapping("/allList")
    public CommonResp allList(DocQueryReq req){
        List<DocQueryResp> resp = docService.allList(req);
        CommonResp<List<DocQueryResp>> listCommonResp = new CommonResp<>();
        listCommonResp.setContent(resp);
        return listCommonResp;
    }
}
