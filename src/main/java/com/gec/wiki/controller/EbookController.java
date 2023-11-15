package com.gec.wiki.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gec.wiki.entity.Ebook;
import com.gec.wiki.req.EbookQueryReq;
import com.gec.wiki.req.EbookReq;
import com.gec.wiki.req.EbookSaveReq;
import com.gec.wiki.resp.CommonResp;
import com.gec.wiki.resp.EbookQueryResp;
import com.gec.wiki.resp.EbookResp;
import com.gec.wiki.resp.PageRsep;
import com.gec.wiki.service.IEbookService;
import com.gec.wiki.utils.CopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 电子书 前端控制器
 * </p>
 *
 * @author
 * @since 2023-09-25
 */
@RestController
@RequestMapping("/ebook")
public class EbookController {
    @Autowired
    private IEbookService ebookService;

    @RequestMapping("/getList")
    public CommonResp getEbookList(EbookResp req) {

        List<Ebook> list;

        if (!ObjectUtils.isEmpty(req.getName()) && req.getName() != null) {
            QueryWrapper<Ebook> wrapper = new QueryWrapper<>();
            wrapper.like("name", req.getName());
            list = ebookService.list(wrapper);
        } else {
            list = ebookService.list();
        }
        List<EbookResp> ebookRespList = CopyUtil.copyList(list, EbookResp.class);
        CommonResp<List<EbookResp>> resp = new CommonResp<>();
        resp.setContent(ebookRespList);
        return resp;
    }

    @RequestMapping("/getEbook")
    public CommonResp getEbook(EbookReq e) {
        List<Ebook> list;
        if (!ObjectUtils.isEmpty(e.getName())) {
            QueryWrapper<Ebook> wrapper = new QueryWrapper<>();
            wrapper.like("name", e.getName());
            list = ebookService.list(wrapper);
        } else {
            list = ebookService.list();
        }
        List<EbookResp> ebookResps = CopyUtil.copyList(list, EbookResp.class);
        CommonResp<List<EbookResp>> resp = new CommonResp<>();
        resp.setContent(ebookResps);
        return resp;
    }

//        @RequestMapping("/getEbookListByPage")
//    public CommonResp getEbookListByPage(EbookReq req) {
//        Page<Ebook> page = new Page<>(req.getPage(), req.getSize());
//        page = ebookService.page(page);
//        List<Ebook> list = page.getRecords();
////            LOG.info("总行数：{}",page.getTotal()+"");
////            LOG.info("总页数：{}",page.getPages()+"");
//        List<EbookResp> ebookResps = CopyUtil.copyList(list, EbookResp.class);
//        PageRsep<EbookResp> respPageResp = new PageRsep<>();
//        respPageResp.setTotal(page.getTotal());
//        respPageResp.setList(ebookResps);
//        CommonResp<PageRsep<EbookResp>> resp = new CommonResp<>();
//        resp.setContent(respPageResp);
//        return resp;
//
//    }

    @RequestMapping("/getEbookListByPage")
    public CommonResp getEbookListByPage(@Valid EbookQueryReq req){
        PageRsep<EbookQueryResp> ebookListByPage = ebookService.getEbookListByPage(req);
        CommonResp<PageRsep<EbookQueryResp>> resp = new CommonResp<>();
        resp.setContent(ebookListByPage);
        return resp;
    }


    @RequestMapping("/save")
    public CommonResp save(@RequestBody EbookSaveReq req) {
        Ebook ebook = CopyUtil.copy(req, Ebook.class);
        ebookService.saveOrUpdate(ebook);
        CommonResp resp = new CommonResp();
        return resp;
    }


    @RequestMapping("/remove")
    public CommonResp remove(int id) {
        ebookService.removeById(id);

        CommonResp resp = new CommonResp();
        return resp;
    }

    @RequestMapping("/uploadImage")
    public CommonResp uploadImage(@RequestParam(value = "file", required = false) MultipartFile file) {
        String imageName = ebookService.uploadImage(file, "C://Users//庄嘉灿//Desktop//mjy//web//public//image");
        CommonResp<Object> resp = new CommonResp<>();
        resp.setContent(imageName);

        return resp;
    }

}
