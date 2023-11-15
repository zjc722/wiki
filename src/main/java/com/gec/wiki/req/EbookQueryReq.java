package com.gec.wiki.req;

import lombok.Data;

@Data
public class EbookQueryReq  extends PageReq{
    private Integer id;
    private String name;
    private long category2Id;
}
