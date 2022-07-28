/*     */ package com.weiyu.controller;
/*     */ 
/*     */ import com.github.pagehelper.PageInfo;
/*     */ import com.weiyu.entity.Tag;
/*     */ import com.weiyu.exception.NotFoundException;
/*     */ import com.weiyu.service.TagService;
/*     */ import javax.validation.Valid;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.validation.BindingResult;
/*     */ import org.springframework.web.bind.annotation.GetMapping;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.PostMapping;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.servlet.mvc.support.RedirectAttributes;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Controller
/*     */ @RequestMapping({"/admin"})
/*     */ public class TagController
/*     */ {
/*     */   @Autowired
/*     */   private TagService tagService;
/*     */   
/*     */   @GetMapping({"/tags"})
/*     */   public String tags(Model model) throws Exception {
/*  38 */     PageInfo<Tag> pageInfo = this.tagService.listTag(1);
/*  39 */     model.addAttribute("page", pageInfo);
/*  40 */     return "admin/tags";
/*     */   }
/*     */ 
/*     */   
/*     */   @GetMapping({"/tags/{currentPage}"})
/*     */   public String tags(@PathVariable int currentPage, Model model) throws Exception {
/*  46 */     PageInfo<Tag> pageInfo = this.tagService.listTag(currentPage);
/*  47 */     model.addAttribute("page", pageInfo);
/*  48 */     return "admin/tags";
/*     */   }
/*     */   
/*     */   @GetMapping({"/tags/input"})
/*     */   public String input(Model model) {
/*  53 */     model.addAttribute("tag", new Tag());
/*  54 */     return "admin/tags-input";
/*     */   }
/*     */ 
/*     */   
/*     */   @PostMapping({"/tags"})
/*     */   public String post(@Valid Tag tag, BindingResult result, RedirectAttributes attributes) {
/*  60 */     Tag tag1 = this.tagService.getByName(tag.getName());
/*  61 */     if (tag1 != null)
/*     */     {
/*  63 */       result.rejectValue("name", "nameError", "不能添加重复分类");
/*     */     }
/*     */     
/*  66 */     if (result.hasErrors()) {
/*  67 */       return "admin/tags-input";
/*     */     }
/*  69 */     boolean isSaved = this.tagService.save(tag);
/*  70 */     if (isSaved) {
/*     */       
/*  72 */       attributes.addFlashAttribute("message", "新增成功");
/*     */     } else {
/*     */       
/*  75 */       attributes.addFlashAttribute("message", "新增失败");
/*     */     } 
/*  77 */     return "redirect:/admin/tags";
/*     */   }
/*     */   
/*     */   @GetMapping({"/tags/{id}/input"})
/*     */   public String editInput(@PathVariable Long id, Model model) throws NotFoundException {
/*  82 */     model.addAttribute("tag", this.tagService.getById(id));
/*  83 */     return "admin/tags-input";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PostMapping({"/tags/{id}"})
/*     */   public String editPost(@Valid Tag tag, BindingResult result, @PathVariable Long id, RedirectAttributes attributes) {
/*  94 */     Tag tag1 = this.tagService.getByName(tag.getName());
/*  95 */     if (tag1 != null)
/*     */     {
/*  97 */       result.rejectValue("name", "nameError", "不能添加重复分类");
/*     */     }
/*     */     
/* 100 */     if (result.hasErrors()) {
/* 101 */       return "admin/tags-input";
/*     */     }
/* 103 */     boolean isSaved = this.tagService.updateById(tag);
/* 104 */     if (isSaved) {
/*     */       
/* 106 */       attributes.addFlashAttribute("message", "更新成功");
/*     */     } else {
/*     */       
/* 109 */       attributes.addFlashAttribute("message", "更新失败");
/*     */     } 
/* 111 */     return "redirect:/admin/tags";
/*     */   }
/*     */   
/*     */   @GetMapping({"/tags/{id}/delete"})
/*     */   public String delete(@PathVariable Long id, RedirectAttributes attributes) {
/* 116 */     this.tagService.removeById(id);
/* 117 */     attributes.addFlashAttribute("message", "删除成功");
/* 118 */     return "redirect:/admin/tags";
/*     */   }
/*     */ }


/* Location:              C:\Users\lenovo\Desktop\fsdownload\myblog-0.0.1-SNAPSHOT.jar!\BOOT-INF\classes\com\weiyu\controller\TagController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */