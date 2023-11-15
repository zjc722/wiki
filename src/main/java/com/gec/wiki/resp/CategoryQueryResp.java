package com.gec.wiki.resp;

import lombok.Data;

@Data
public class CategoryQueryResp {
    private Long id;
    private Long parent;
    private String name;
    private Integer sort;

    @Override
    public String toString() {
        return "CategoryQueryReq{" +
                "id=" + id +
                ", parent=" + parent +
                ", name='" + name + '\'' +
                ", sort=" + sort +
                '}';
    }
}
