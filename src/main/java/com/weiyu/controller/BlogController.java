package com.weiyu.controller;


import com.weiyu.entity.Blog;
import com.weiyu.entity.Result;
import com.weiyu.entity.User;
import com.weiyu.service.BlogService;
import com.weiyu.service.TagService;
import com.weiyu.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author weiyu
 * @since 2022-01-31
 */
@Controller
@RequestMapping("/admin")
public class BlogController {

    private static final String LIST = "admin/blogs";
    private static final String REDIRECT_LIST = "redirect:/admin/blogs";
    private static final String INPUT = "admin/blogs-input";

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;


    @GetMapping("/blogs")
    public String blogs(Model model) throws Exception {
        model.addAttribute("types", typeService.listType());
        model.addAttribute("page", blogService.listBlog(1, new Blog()));
        return LIST;
    }

    /**
     * 配合ajax使用的
     */

    @PostMapping("/blogs/{currentPage}")
    public String blogs(Model model, @PathVariable int currentPage) throws Exception {
        model.addAttribute("types", typeService.listType());
        model.addAttribute("page", blogService.listBlog(currentPage, new Blog()));
        return "admin/blogs :: blogList";
    }

    @PostMapping("/blogs/search")
    public String search(Model model, Blog blog) throws Exception {
        model.addAttribute("page", blogService.listBlog(1, blog));
        return "admin/blogs :: blogList";
    }

    @PostMapping("/blogs/{currentPage}/search")
    public String search(Model model, Blog blog, @PathVariable int currentPage) throws Exception {
        model.addAttribute("page", blogService.listBlog(currentPage, blog));
        return "admin/blogs :: blogList";
    }

    /**
     * 新增跳转页面
     */
    @GetMapping("/blogs/input")
    public String input(Model model) throws Exception {
        setTypeAndTag(model);
        //因为是新增和修改共用一个页面，所以防止报错把 修改时页面 需要的blog域new一个Blog空对象
        model.addAttribute("blog", new Blog());
        return INPUT;
    }

    /**
     * 修改跳转页面
     */
    @GetMapping("/blogs/{id}/input")
    public String editInput(@PathVariable Long id, Model model) throws Exception {
        setTypeAndTag(model);
        Blog blog = blogService.getById(id);
        blog.setTags(tagService.getTags(blog));
        blog.init();

        model.addAttribute("blog", blog);
        return INPUT;
    }

    private void setTypeAndTag(Model model) throws Exception {
        model.addAttribute("types", typeService.listType());
        model.addAttribute("tags", tagService.listTag());
    }

    /**
     * 新增和修改
     */
    @PostMapping("/blogs")
    @Transactional
    public String post(Blog blog, RedirectAttributes attributes, HttpSession session) throws Exception {

        if(blog.getRecommend()==null){
            blog.setRecommend(false);
        }
        if(blog.getShareStatement()==null){
            blog.setShareStatement(false);
        }
        if(blog.getCommentabled()==null){
            blog.setCommentabled(false);
        }
        blog.setUserId(((User) session.getAttribute("user")).getId());
        blog.setTypeId(blog.getTypeId());
        blog.setTags(tagService.listTag(blog.getTagIds()));

        boolean isSaved;
        if (blog.getId() == null) {
            //新增
            isSaved=blogService.saveBlog(blog);
        }else{
            //修改
            isSaved=blogService.update(blog);
        }

        if (isSaved) {
            //保存成功
            attributes.addFlashAttribute("message", "操作成功");
        } else {
            //保存失败
            attributes.addFlashAttribute("message", "操作失败");
        }
        return REDIRECT_LIST;
    }

    @GetMapping("/blogs/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes) throws Exception{
        blogService.deleteById(id);
        attributes.addFlashAttribute("message", "删除成功");
        return REDIRECT_LIST;
    }

//    @GetMapping("/upimg")
//    public String img(){
//        return "admin/Test";
//    }

    @PostMapping("/img")
    @ResponseBody
    public Result imageUpload(@RequestParam("editormd-image-file") MultipartFile img) throws IOException {
        String fileName = img.getOriginalFilename();
        ApplicationHome home=new ApplicationHome(getClass());
        File sysfile=home.getSource();
        //String realPath=sysfile.getParentFile().toString() ;
        String realPath="";
        String url=realPath+File.separator+"blog_img";
        File file=new File(url);
        try {
            boolean mkdir=false;
            if (file.exists()) {
                mkdir=true;
            }
            if (!file.exists() && !file.isDirectory()) {
                mkdir = file.mkdir();
            }
            if(mkdir){
                img.transferTo(new File(url+File.separator+fileName));
            }else{
                System.out.println("mkdir fail!!!!!");
            }
        } catch (IOException e) {
            //e.printStackTrace();
            return Result.fail();
        } catch (IllegalStateException e) {
            //e.printStackTrace();
            return Result.fail();
        }
        //String imgUrl="http:"+File.separator+File.separator+"localhost"+File.separator+"blog_img"+File.separator+fileName;
        String imgUrl=File.separator+"blog_img"+File.separator+fileName;
        return Result.suc(imgUrl);
    }



}

