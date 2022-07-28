/*     */ package com.weiyu.service.ipml;
/*     */ 
/*     */ import com.alibaba.fastjson.JSON;
/*     */ import com.baomidou.mybatisplus.core.conditions.Wrapper;
/*     */ import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
/*     */ import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
/*     */ import com.weiyu.entity.Comment;
/*     */ import com.weiyu.mapper.CommentMapper;
/*     */ import com.weiyu.service.CommentService;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import org.springframework.beans.BeanUtils;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ import org.springframework.transaction.annotation.Transactional;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Service
/*     */ public class CommentServiceImpl
/*     */   extends ServiceImpl<CommentMapper, Comment>
/*     */   implements CommentService
/*     */ {
/*     */   @Autowired
/*     */   private CommentMapper commentMapper;
/*     */   
/*     */   public List<Comment> listCommentByBlogId(Long blogId) {
/*  35 */     QueryWrapper<Comment> qw = new QueryWrapper();
/*  36 */     ((QueryWrapper)qw.eq("blog_id", blogId)).eq("parent_id", Integer.valueOf(-1));
/*  37 */     List<Comment> commentList = this.commentMapper.selectList((Wrapper)qw);
/*  38 */     return eachComment(commentList);
/*     */   }
/*     */ 
/*     */   
/*     */   @Transactional
/*     */   public Boolean saveComment(Comment comment) throws Exception {
/*  44 */     comment.setCreateTime(new Date());
/*  45 */     Long parentCommentId = comment.getParentId();
/*  46 */     if (parentCommentId.longValue() != -1L) {
/*  47 */       comment.setParentComment((Comment)this.commentMapper.selectById(parentCommentId));
/*     */     } else {
/*  49 */       comment.setParentComment(null);
/*     */     } 
/*  51 */     int insert = this.commentMapper.insert(comment);
/*     */     
/*  53 */     int update = 0;
/*  54 */     if (insert > 0) {
/*     */       
/*  56 */       Comment parentComment = (Comment)this.commentMapper.selectById(comment.getParentId());
/*  57 */       while (parentComment != null) {
/*     */ 
/*     */ 
/*     */         
/*  61 */         List<Comment> replyComments = parentComment.getReplyComments();
/*  62 */         String arrJson = JSON.toJSONString(replyComments);
/*  63 */         List<Comment> replys1 = JSON.parseArray(arrJson, Comment.class);
/*  64 */         replys1.add(comment);
/*  65 */         parentComment.setReplyComments(replys1);
/*  66 */         update = this.commentMapper.updateById(parentComment);
/*     */         
/*  68 */         parentComment = (Comment)this.commentMapper.selectById(parentComment.getParentId());
/*     */       } 
/*     */     } 
/*     */     
/*  72 */     return Boolean.valueOf((update > 0));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<Comment> eachComment(List<Comment> comments) {
/*  82 */     List<Comment> commentsView = new ArrayList<>();
/*  83 */     for (Comment comment : comments) {
/*  84 */       Comment c = new Comment();
/*  85 */       BeanUtils.copyProperties(comment, c);
/*  86 */       commentsView.add(c);
/*     */     } 
/*     */     
/*  89 */     combineChildren(commentsView);
/*  90 */     return commentsView;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void combineChildren(List<Comment> comments) {
/*  99 */     if (comments != null && comments.size() > 0) {
/* 100 */       for (Comment comment : comments) {
/*     */         
/* 102 */         List<Comment> replyComments = comment.getReplyComments();
/*     */ 
/*     */ 
/*     */         
/* 106 */         String arrJson = JSON.toJSONString(replyComments);
/* 107 */         List<Comment> replys1 = JSON.parseArray(arrJson, Comment.class);
/*     */         
/* 109 */         if (replys1 != null && replys1.size() > 0) {
/* 110 */           for (Comment reply1 : replys1)
/*     */           {
/* 112 */             recursively(reply1);
/*     */           }
/*     */           
/* 115 */           comment.setReplyComments(this.tempReplys);
/*     */           
/* 117 */           this.tempReplys = new ArrayList<>();
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 125 */   private List<Comment> tempReplys = new ArrayList<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void recursively(Comment comment) {
/* 134 */     this.tempReplys.add(comment);
/*     */     
/* 136 */     if (comment.getReplyComments().size() > 0) {
/*     */       
/* 138 */       List<Comment> replyComments = comment.getReplyComments();
/* 139 */       String arrJson = JSON.toJSONString(replyComments);
/* 140 */       List<Comment> replys = JSON.parseArray(arrJson, Comment.class);
/*     */       
/* 142 */       for (Comment reply : replys) {
/* 143 */         this.tempReplys.add(reply);
/* 144 */         if (reply.getReplyComments().size() > 0)
/* 145 */           recursively(reply); 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\lenovo\Desktop\fsdownload\myblog-0.0.1-SNAPSHOT.jar!\BOOT-INF\classes\com\weiyu\service\ipml\CommentServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */