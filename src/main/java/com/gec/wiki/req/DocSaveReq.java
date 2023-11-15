package com.gec.wiki.req;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class DocSaveReq  {
    private Integer id;
    @NotNull(message = "【电子书】不能为空")
    private Long ebookId;//电子书id
    @NotNull(message = "【父文档】不能为空")
    private Long parent;//父id
    @NotNull(message = "【名称】不能为空")
    private String name;//名称
    @NotNull(message = "【排序】不能为空")
    private Integer sort;//顺序
    private Integer viewCount;//阅读数
    private Integer voteCount;//点赞数
}
