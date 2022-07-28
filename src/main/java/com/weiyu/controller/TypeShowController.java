package com.weiyu.controller;

import com.weiyu.entity.Blog;
import com.weiyu.entity.Type;
import com.weiyu.service.BlogService;
import com.weiyu.service.TypeService;
import com.weiyu.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class TypeShowController {
    @Autowired
    private TypeService typeService;
    @Autowired
    private BlogService blogService;
    @Autowired
    private UserService userService;
    @Value("${showTypes.pageSize}")
    private Integer pageSize;

    @GetMapping({"/types/{id}"})
    public String types(Model model, @PathVariable Long id) throws Exception {
        List<Type> typeList = this.typeService.listTypeTop(Integer.valueOf(10000));
        if (id.longValue() == -1L) {
            id = ((Type) typeList.get(0)).getId();
        }
        model.addAttribute("types", typeList);
        Blog blog = new Blog();
        blog.setTypeId(id);
        model.addAttribute("page", this.blogService.listBlog(1, this.pageSize.intValue(), blog));
        model.addAttribute("activeTypeId", id);
        model.addAttribute("user", this.userService.getById(Long.valueOf(1L)));
        return "types";
    }

    @GetMapping({"/types/{id}/{currentPage}"})
    public String types(Model model, @PathVariable Long id, @PathVariable int currentPage) throws Exception {
        List<Type> typeList = this.typeService.listTypeTop(Integer.valueOf(10000));
        if (id.longValue() == -1L) {
            id = ((Type) typeList.get(0)).getId();
        }
        model.addAttribute("types", typeList);
        Blog blog = new Blog();
        blog.setTypeId(id);
        model.addAttribute("page", this.blogService.listBlog(currentPage, this.pageSize.intValue(), blog));
        model.addAttribute("activeTypeId", id);
        model.addAttribute("user", this.userService.getById(Long.valueOf(1L)));
        return "types";
    }
}



