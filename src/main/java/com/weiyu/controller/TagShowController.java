/*    */ package com.weiyu.controller;
/*    */ 
/*    */ import com.weiyu.entity.Tag;
/*    */ import com.weiyu.service.BlogService;
/*    */ import com.weiyu.service.TagService;
/*    */ import com.weiyu.service.UserService;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.beans.factory.annotation.Value;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.ui.Model;
/*    */ import org.springframework.web.bind.annotation.GetMapping;
/*    */ import org.springframework.web.bind.annotation.PathVariable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Controller
/*    */ public class TagShowController
/*    */ {
/*    */   @Autowired
/*    */   private TagService tagService;
/*    */   @Autowired
/*    */   private BlogService blogService;
/*    */   @Autowired
/*    */   private UserService userService;
/*    */   @Value("${showTags.pageSize}")
/*    */   private Integer pageSize;
/*    */   
/*    */   @GetMapping({"/tags/{id}"})
/*    */   public String tags(Model model, @PathVariable Long id) throws Exception {
/* 36 */     List<Tag> tagList = this.tagService.listTagTop(Integer.valueOf(10000));
/* 37 */     if (id.longValue() == -1L)
/*    */     {
/* 39 */       id = ((Tag)tagList.get(0)).getId();
/*    */     }
/* 41 */     model.addAttribute("tags", tagList);
/* 42 */     model.addAttribute("page", this.blogService.listBlog(1, this.pageSize.intValue(), id));
/* 43 */     model.addAttribute("activeTagId", id);
/* 44 */     model.addAttribute("user", this.userService.getById(Long.valueOf(1L)));
/* 45 */     return "tags";
/*    */   }
/*    */   
/*    */   @GetMapping({"/tags/{id}/{currentPage}"})
/*    */   public String tags(Model model, @PathVariable Long id, @PathVariable int currentPage) throws Exception {
/* 50 */     List<Tag> tagList = this.tagService.listTagTop(Integer.valueOf(10000));
/* 51 */     if (id.longValue() == -1L)
/*    */     {
/* 53 */       id = ((Tag)tagList.get(0)).getId();
/*    */     }
/* 55 */     model.addAttribute("tags", tagList);
/* 56 */     model.addAttribute("page", this.blogService.listBlog(currentPage, this.pageSize.intValue(), id));
/* 57 */     model.addAttribute("activeTagId", id);
/* 58 */     model.addAttribute("user", this.userService.getById(Long.valueOf(1L)));
/* 59 */     return "tags";
/*    */   }
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\fsdownload\myblog-0.0.1-SNAPSHOT.jar!\BOOT-INF\classes\com\weiyu\controller\TagShowController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */