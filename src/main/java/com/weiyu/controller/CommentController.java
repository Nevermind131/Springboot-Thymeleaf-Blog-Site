/*    */ package com.weiyu.controller;
/*    */ 
/*    */ import com.weiyu.entity.Comment;
/*    */ import com.weiyu.entity.User;
/*    */ import com.weiyu.service.BlogService;
/*    */ import com.weiyu.service.CommentService;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.beans.factory.annotation.Value;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.ui.Model;
/*    */ import org.springframework.web.bind.annotation.GetMapping;
/*    */ import org.springframework.web.bind.annotation.PathVariable;
/*    */ import org.springframework.web.bind.annotation.PostMapping;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Controller
/*    */ public class CommentController
/*    */ {
/*    */   @Autowired
/*    */   private CommentService commentService;
/*    */   @Autowired
/*    */   private BlogService blogService;
/*    */   @Value("${comment.avatar}")
/*    */   private String avatar;
/*    */   
/*    */   @GetMapping({"/comments/{blogId}"})
/*    */   public String comments(@PathVariable Long blogId, Model model) {
/* 39 */     model.addAttribute("comments", this.commentService.listCommentByBlogId(blogId));
/* 40 */     return "blog :: commentList";
/*    */   }
/*    */   
/*    */   @PostMapping({"/comments"})
/*    */   public String post(Comment comment, HttpSession session) throws Exception {
/* 45 */     User user = (User)session.getAttribute("user");
/* 46 */     if (user != null) {
/* 47 */       comment.setAvatar(user.getAvatar());
/* 48 */       comment.setAdminComment(true);
/*    */     } else {
/*    */       
/* 51 */       comment.setAvatar(this.avatar);
/*    */     } 
/* 53 */     this.commentService.saveComment(comment);
/* 54 */     return "redirect:/comments/" + comment.getBlogId();
/*    */   }
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\fsdownload\myblog-0.0.1-SNAPSHOT.jar!\BOOT-INF\classes\com\weiyu\controller\CommentController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */