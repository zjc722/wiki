package com.gec.wiki.service;

import com.gec.wiki.entity.Ebook;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gec.wiki.req.EbookQueryReq;
import com.gec.wiki.resp.EbookQueryResp;
import com.gec.wiki.resp.PageRsep;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 电子书 服务类
 * </p>
 *
 * @author 
 * @since 2023-09-25
 */
public interface IEbookService extends IService<Ebook> {

    String uploadImage(MultipartFile file,String folder);

    PageRsep<EbookQueryResp> getEbookListByPage(EbookQueryReq req);
}
