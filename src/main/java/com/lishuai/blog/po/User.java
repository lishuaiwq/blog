package com.lishuai.blog.po;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author:shui.li
 * @Date:2019/1/1221:01
 */

@Data
@Entity
@Table(name ="t_user")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String nickname;
    private String username;
    private String password;
    private String email;
    private String avater;
    private Integer type;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    @OneToMany(mappedBy = "user")
    private List<Blog> blogs=new ArrayList<>();
}
