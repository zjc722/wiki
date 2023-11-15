package com.gec.wiki.resp;

import lombok.Data;

import java.util.List;

//接受分页后的数据
@Data
public class PageRsep<T> {
    public Long total;
    private List<T> list;
}
