package com.lishuai.blog.po;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 分类
 * @Author:shui.li
 * @Date:2019/1/1220:54
 */
@Entity
@Data
@Table(name = "t_type")
public class Type {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "type")
    private List<Blog> blogs=new ArrayList<>();
}
