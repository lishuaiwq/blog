package com.lishuai.blog.po;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author:shui.li
 * @Date:2019/1/1220:43
 */
@Entity
@Data
@Table(name = "t_blog")
public class Blog {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String content;
    /**
     * 首图，给图片的编码
     *
     */
    private String firstPicture;

    private String flag;

    private Integer views;

    /**
     * 赞赏是否开启
     */
    private boolean appreciAction;

    /**
     * 转载是否开启
     */
    private boolean shareStatement;
    /**
     * 评论是否开启
     */
    private boolean commenttabled;

    /**
     * 是否发布还是保存为草稿
     */
    private boolean published;

    /**
     * 是否推荐
     */
    private boolean recommend;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    @ManyToOne
    private  Type type;//一个博客只有一个标签

    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<Tag> tags=new ArrayList<>();


    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "blog")
    private  List<Comment> comments=new ArrayList<>();

}
