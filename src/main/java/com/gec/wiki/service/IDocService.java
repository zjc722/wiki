package com.gec.wiki.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gec.wiki.entity.Doc;
import com.gec.wiki.req.DocQueryReq;
import com.gec.wiki.resp.DocQueryResp;
import com.gec.wiki.resp.PageRsep;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2023-11-14
 */
public interface IDocService extends IService<Doc> {
//    PageResp<DocQueryResp> getDocListByPage(DocQueryReq req);

    PageRsep<DocQueryResp> getDocListByPage(DocQueryReq req);
    List<DocQueryResp> allList(DocQueryReq req);

}
