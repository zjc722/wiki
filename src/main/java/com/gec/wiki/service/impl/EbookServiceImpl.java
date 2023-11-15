package com.gec.wiki.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gec.wiki.entity.Ebook;
import com.gec.wiki.exception.BusinessException;
import com.gec.wiki.exception.BusinessExceptionCode;
import com.gec.wiki.mapper.EbookMapper;
import com.gec.wiki.req.EbookQueryReq;
import com.gec.wiki.resp.EbookQueryResp;
import com.gec.wiki.resp.PageRsep;
import com.gec.wiki.service.IEbookService;
import com.gec.wiki.utils.CopyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Service
public class EbookServiceImpl extends ServiceImpl<EbookMapper, Ebook> implements IEbookService {
    private static final Logger LOG = LoggerFactory.getLogger(EbookServiceImpl.class);

    @Override
    public String uploadImage(MultipartFile file, String folder) {
        if (file == null) {
            throw new BusinessException(BusinessExceptionCode.Select_Upload_Image);
        }
        if (file.getSize() > 1024 * 1024 * 10) {
            throw new BusinessException(BusinessExceptionCode.Files_Larger_Than_10M);
        }
//获取文件后缀
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1, file.getOriginalFilename().length());
        if (!"jpg,jpeg,gif,png".toUpperCase().contains(suffix.toUpperCase())) {
            throw new BusinessException(BusinessExceptionCode.Files_Wrong_Format);
        }
        String savePath = folder;
        File savePathFile = new File(savePath);
        if (!savePathFile.exists()) {
//若不存在该目录，则创建目录
            savePathFile.mkdir();
        }
//通过UUID生成唯一文件名
//        String filename = UUID.randomUUID().toString().replaceAll("-", "") + "." + suffix;
        try {
//将文件保存指定目录
            file.transferTo(new File(savePath + file.getOriginalFilename()));
            File file1 = new File(file.getOriginalFilename());
//FileUtils.copyInputStreamToFile(file.getInputStream(),new
//            File(savePath + file.getOriginalFilename());
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException(BusinessExceptionCode.Save_File_Exception);
        }
//返回文件名称
        LOG.info("文件名:{}", file.getOriginalFilename());
        return file.getOriginalFilename();
    }

    @Override
    public PageRsep<EbookQueryResp> getEbookListByPage(EbookQueryReq req) {
        Page<Ebook> page = new Page<>(req.getPage(), req.getSize());
        QueryWrapper<Ebook> wrapper = new QueryWrapper<>();
        if (!ObjectUtils.isEmpty(req.getCategory2Id())&&req.getCategory2Id()!=0){
            wrapper.eq("category2_id",req.getCategory2Id());
        }
        if (!ObjectUtils.isEmpty(req.getName())&&req.getName()!=null) {
            wrapper.like("name",req.getName());
        }
        page = this.page(page,wrapper);
        List<Ebook> list = page.getRecords();

        List<EbookQueryResp> ebookResps = CopyUtil.copyList(list, EbookQueryResp.class);
        PageRsep<EbookQueryResp> respPageResp = new PageRsep<>();
        respPageResp.setTotal(page.getTotal());
        respPageResp.setList(ebookResps);
        return respPageResp;
    }
}

