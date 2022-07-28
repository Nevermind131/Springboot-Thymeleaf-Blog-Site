/*    */
package com.weiyu.controller;
/*    */
/*    */

import com.weiyu.entity.User;
import com.weiyu.service.BlogService;
/*    */ import com.weiyu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.beans.factory.annotation.Value;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.ui.Model;
/*    */ import org.springframework.web.bind.annotation.GetMapping;
/*    */ import org.springframework.web.bind.annotation.PathVariable;

/*    */
/*    */
/*    */
/*    */
@Controller
/*    */ public class ArchiveShowController
        /*    */ {
    /*    */
    @Autowired
    /*    */ private BlogService blogService;
    /*    */
    @Value("${showArchives.pageSize}")
    /*    */ private Integer pageSize;



    /*    */
    /*    */
    @GetMapping({"/archives/{currentPage}"})
    /*    */ public String archives(@PathVariable int currentPage, Model model) {
        /* 23 */
        model.addAttribute("archiveResult", this.blogService.archiveBlog(currentPage, this.pageSize.intValue()));
        /* 24 */
        model.addAttribute("blogCount", this.blogService.countBlog());


        /* 25 */
        return "archives";
        /*    */
    }
    /*    */
}


/* Location:              C:\Users\lenovo\Desktop\fsdownload\myblog-0.0.1-SNAPSHOT.jar!\BOOT-INF\classes\com\weiyu\controller\ArchiveShowController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */