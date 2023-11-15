package com.gec.wiki.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gec.wiki.entity.Doc;
import com.gec.wiki.mapper.DocMapper;
import com.gec.wiki.req.DocQueryReq;
import com.gec.wiki.resp.DocQueryResp;
import com.gec.wiki.resp.PageRsep;
import com.gec.wiki.service.IDocService;
import com.gec.wiki.utils.CopyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 
 * @since 2023-11-13
 */
@Service
public class DocServiceImpl extends ServiceImpl<DocMapper, Doc> implements IDocService {

    private static final Logger LOG = LoggerFactory.getLogger(DocServiceImpl.class);
    @Override
//    public PageResp<DocQueryResp> getDocListByPage(DocQueryReq req) {
      public PageRsep<DocQueryResp> getDocListByPage(DocQueryReq req) {
        Page<Doc> page = new Page<>(req.getPage(), req.getSize());
        page = this.page(page);
        List<Doc> list = page.getRecords();

        LOG.info("总行数：{}",page.getTotal()+"");
        LOG.info("总页数：{}",page.getPages()+"");

        List<DocQueryResp> docResps = CopyUtil.copyList(list, DocQueryResp.class);

//        PageResp<DocQueryResp> repsPage = new PageResp<>();
        PageRsep<DocQueryResp> repsPage = new PageRsep<>();
        repsPage.setList(docResps);
        repsPage.setTotal(page.getTotal());
        return repsPage;
    }

    @Override
    public List<DocQueryResp> allList(DocQueryReq req) {
        QueryWrapper<Doc> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("sort");
        List<Doc> list = this.list(wrapper);

        List<DocQueryResp> resp = CopyUtil.copyList(list, DocQueryResp.class);
        return resp;
    }
}
