package com.lishuai.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * @Author:shui.li
 * @Date:2019/1/1216:19
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(){

        return "admin/index";
    }
}
