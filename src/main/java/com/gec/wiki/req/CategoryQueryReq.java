package com.gec.wiki.req;

import lombok.Data;

@Data
public class CategoryQueryReq {

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
