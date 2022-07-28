/*    */ package com.weiyu.controller;
/*    */ 
/*    */ import com.weiyu.entity.User;
/*    */ import com.weiyu.service.UserService;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.annotation.GetMapping;
/*    */ import org.springframework.web.bind.annotation.PostMapping;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RequestParam;
/*    */ import org.springframework.web.servlet.mvc.support.RedirectAttributes;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Controller
/*    */ @RequestMapping({"/admin"})
/*    */ public class UserController
/*    */ {
/*    */   @Autowired
/*    */   private UserService userService;
/*    */   
/*    */   @GetMapping
/*    */   public String loginPage() {
/* 30 */     return "admin/login";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @PostMapping({"/login"})
/*    */   public String login(@RequestParam String username, @RequestParam String password, HttpSession session, RedirectAttributes attributes) {
/* 38 */     User user = this.userService.checkUser(username, password);
/* 39 */     if (user != null) {
/*    */ 
/*    */ 
/*    */       
/* 43 */       user.setPassword(null);
/* 44 */       session.setAttribute("user", user);
/* 45 */       return "admin/index";
/*    */     } 
/*    */     
/* 48 */     attributes.addFlashAttribute("message", "用户名或密码错误");
/* 49 */     return "redirect:/admin";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @GetMapping({"/logout"})
/*    */   public String logout(HttpSession session) {
/* 57 */     session.removeAttribute("user");
/* 58 */     return "redirect:/admin";
/*    */   }
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\fsdownload\myblog-0.0.1-SNAPSHOT.jar!\BOOT-INF\classes\com\weiyu\controller\UserController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */