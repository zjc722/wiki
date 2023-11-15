package com.gec.wiki.resp;

import lombok.Data;

@Data
public class DocQueryResp {
    private Integer id;
    private Long ebookId;//电子书id
    private Long parent;//父id
    private String name;//名称
    private Integer sort;//顺序
    private Integer viewCount;//阅读数
    private Integer voteCount;//点赞数
}
