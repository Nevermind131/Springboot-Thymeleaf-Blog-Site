/*    */
package com.weiyu.controller;
/*    */
/*    */

import com.weiyu.entity.Blog;
/*    */ import com.weiyu.entity.QueryBlog;
/*    */ import com.weiyu.service.BlogService;
/*    */ import com.weiyu.service.TagService;
/*    */ import com.weiyu.service.TypeService;
/*    */ import com.weiyu.service.UserService;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.core.env.Environment;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.ui.Model;
/*    */ import org.springframework.web.bind.annotation.GetMapping;
/*    */ import org.springframework.web.bind.annotation.PathVariable;
/*    */ import org.springframework.web.bind.annotation.PostMapping;
/*    */ import org.springframework.web.bind.annotation.RequestParam;

/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
@Controller
/*    */ public class IndexController
        /*    */ {
    /*    */
    @Autowired
    /*    */ private BlogService blogService;
    /*    */
    @Autowired
    /*    */ private TypeService typeService;
    /*    */
    @Autowired
    /*    */ private TagService tagService;
    /*    */
    @Autowired
    /*    */ private UserService userService;
    /*    */
    @Autowired
    /*    */ private Environment env;

    /*    */
    /*    */
    @GetMapping({"/"})
    /*    */ public String index(Model model) throws Exception {
        /* 41 */
        model.addAttribute("page", this.blogService.listBlog(1, Integer.parseInt(this.env.getProperty("pageSize.blog")), new Blog()));
        /* 42 */
        model.addAttribute("types", this.typeService.listTypeTop(Integer.valueOf(this.env.getProperty("pageSize.type"))));
        /* 43 */
        model.addAttribute("tags", this.tagService.listTagTop(Integer.valueOf(this.env.getProperty("pageSize.tag"))));
        /* 44 */
        model.addAttribute("recommendBlogs", this.blogService.listRecommendBlogTop(Integer.parseInt(this.env.getProperty("pageSize.recommend"))));
        /* 45 */
        model.addAttribute("user", this.userService.getById(Long.valueOf(1L)));
        /* 46 */
        return "index";
        /*    */
    }

    /*    */
    /*    */
    @GetMapping({"/{currentPage}"})
    /*    */ public String index(Model model, @PathVariable int currentPage) throws Exception {
        /* 51 */
        model.addAttribute("page", this.blogService.listBlog(currentPage, Integer.parseInt(this.env.getProperty("pageSize.blog")), new Blog()));
        /* 52 */
        model.addAttribute("types", this.typeService.listTypeTop(Integer.valueOf(this.env.getProperty("pageSize.type"))));
        /* 53 */
        model.addAttribute("tags", this.tagService.listTagTop(Integer.valueOf(this.env.getProperty("pageSize.tag"))));
        /* 54 */
        model.addAttribute("recommendBlogs", this.blogService.listRecommendBlogTop(Integer.parseInt(this.env.getProperty("pageSize.recommend"))));
        /* 55 */
        model.addAttribute("user", this.userService.getById(Long.valueOf(1L)));
        /* 56 */
        return "index";
        /*    */
    }

    /*    */
    /*    */
    @PostMapping({"/search"})
    /*    */ public String search(Model model, @RequestParam String query) throws Exception {
        /* 61 */
        model.addAttribute("page", this.blogService.listBlog(1, Integer.parseInt(this.env.getProperty("pageSize.search")), query));
        /* 62 */
        model.addAttribute("user", this.userService.getById(Long.valueOf(1L)));
        /* 63 */
        return "search";
        /*    */
    }

    /*    */
    /*    */
    @GetMapping({"/blog/{id}"})
    /*    */ public String blog(@PathVariable Long id, Model model) throws Exception {
        /* 68 */
        Blog blog = (Blog) this.blogService.getById(id);
        /* 69 */
        QueryBlog queryBlog = this.blogService.getAndConvert(id);
        /* 70 */
        model.addAttribute("blog", queryBlog);
        /* 71 */
        model.addAttribute("user", this.userService.getById(Long.valueOf(1L)));
        /* 72 */
        model.addAttribute("tags", this.tagService.getTags(blog));
        /* 73 */
        model.addAttribute("last", this.blogService.getLast(queryBlog.getCreateTime()));
        /* 74 */
        model.addAttribute("next", this.blogService.getNext(queryBlog.getCreateTime()));
        /* 75 */
        return "blog";
        /*    */
    }

    @GetMapping({"/footer/newblog"})
    public String newblogs(Model model) throws Exception {
        model.addAttribute("newblogs", this.blogService.listRecommendBlogTop(3));
        return "_fragments :: newblogList";
    }
}

