/*    */ package com.weiyu.service.ipml;
/*    */ 
/*    */ import com.baomidou.mybatisplus.core.conditions.Wrapper;
/*    */ import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
/*    */ import com.baomidou.mybatisplus.core.metadata.IPage;
/*    */ import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
/*    */ import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
/*    */ import com.github.pagehelper.PageHelper;
/*    */ import com.github.pagehelper.PageInfo;
/*    */ import com.weiyu.entity.Blog;
/*    */ import com.weiyu.entity.Tag;
/*    */ import com.weiyu.mapper.TagMapper;
/*    */ import com.weiyu.service.TagService;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
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
/*    */ 
/*    */ @Service
/*    */ public class TagServiceImpl
/*    */   extends ServiceImpl<TagMapper, Tag>
/*    */   implements TagService
/*    */ {
/*    */   @Autowired
/*    */   private TagMapper tagMapper;
/*    */   
/*    */   public PageInfo<Tag> listTag(int currentPage) throws Exception {
/* 40 */     PageHelper.startPage(currentPage, 10);
/* 41 */     List<Tag> tagList = this.tagMapper.findAllByOrder();
/*    */     
/* 43 */     PageInfo<Tag> pageInfo = new PageInfo(tagList);
/*    */     
/* 45 */     return pageInfo;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public List<Tag> listTag() throws Exception {
/* 52 */     QueryWrapper<Tag> qw = new QueryWrapper();
/* 53 */     qw.orderByDesc("id");
/*    */     
/* 55 */     List<Tag> tagList = this.tagMapper.selectList((Wrapper)qw);
/*    */     
/* 57 */     return tagList;
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Tag> listTag(String ids) throws Exception {
/* 62 */     List<Tag> tagList = null;
/* 63 */     if (!"".equals(ids) && ids != null) {
/* 64 */       tagList = this.tagMapper.selectBatchIds(convertToList(ids));
/*    */     }
/* 66 */     return tagList;
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Tag> getTags(Blog blog) throws Exception {
/* 71 */     return this.tagMapper.joinQuery(blog);
/*    */   }
/*    */ 
/*    */   
/*    */   public Tag getByName(String name) {
/* 76 */     QueryWrapper<Tag> wrapper = new QueryWrapper();
/* 77 */     wrapper.eq("name", name);
/* 78 */     return (Tag)this.tagMapper.selectOne((Wrapper)wrapper);
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Tag> listTagTop(Integer size) throws Exception {
/* 83 */     Page<Tag> page = new Page(1L, size.intValue());
/* 84 */     QueryWrapper<Tag> qw = new QueryWrapper();
/* 85 */     qw.orderByDesc("number");
/* 86 */     page = (Page<Tag>)this.tagMapper.selectPage((IPage)page, (Wrapper)qw);
/* 87 */     return page.getRecords();
/*    */   }
/*    */   
/*    */   private List<Long> convertToList(String ids) {
/* 91 */     List<Long> list = new ArrayList<>();
/* 92 */     if (!"".equals(ids) && ids != null) {
/* 93 */       String[] idArr = ids.split(",");
/* 94 */       for (String s : idArr) {
/* 95 */         list.add(new Long(s));
/*    */       }
/*    */     } 
/* 98 */     return list;
/*    */   }
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\fsdownload\myblog-0.0.1-SNAPSHOT.jar!\BOOT-INF\classes\com\weiyu\service\ipml\TagServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */