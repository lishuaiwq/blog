package com.lishuai.blog.po;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:shui.li
 * @Date:2019/1/1220:55
 */
@Entity
@Data
@Table(name = "t_tag")
public class Tag {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "tags")
    private List<Blog> blogs=new ArrayList<>();
}
