package com.lishuai.blog.po;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author:shui.li
 * @Date:2019/1/1220:57
 */
@Entity
@Data
@Table(name = "t_comment")
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    private String nickname;
    private String email;
    private String content;
    private String avatar;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @ManyToOne
    private Blog blog;

    @OneToMany(mappedBy = "parentComment")
    private List<Comment> replayComments=new ArrayList<>();

    @ManyToOne
    private Comment parentComment;

}
