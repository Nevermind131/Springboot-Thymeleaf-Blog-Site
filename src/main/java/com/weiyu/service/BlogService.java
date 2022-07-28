package com.weiyu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.weiyu.entity.ArchiveResult;
import com.weiyu.entity.Blog;
import com.weiyu.entity.QueryBlog;
import java.util.Date;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

public interface BlogService extends IService<Blog> {
  PageInfo<QueryBlog> listBlog(int paramInt, Blog paramBlog) throws Exception;
  
  PageInfo<QueryBlog> listBlog(int paramInt1, int paramInt2, Blog paramBlog) throws Exception;
  
  PageInfo<QueryBlog> listBlog(int paramInt1, int paramInt2, String paramString) throws Exception;
  
  PageInfo<QueryBlog> listBlog(int paramInt1, int paramInt2, Long paramLong) throws Exception;
  
  List<QueryBlog> listRecommendBlogTop(int paramInt) throws Exception;
  
  ArchiveResult archiveBlog(int paramInt1, int paramInt2);
  
  Long countBlog();
  
  @Transactional
  boolean saveBlog(Blog paramBlog) throws Exception;
  
  boolean update(Blog paramBlog);
  
  QueryBlog getBlogDetails(Long paramLong);
  
  QueryBlog getAndConvert(Long paramLong);
  
  void deleteById(Long paramLong);
  
  Blog getLast(Date paramDate);
  
  Blog getNext(Date paramDate);
}


/* Location:              C:\Users\lenovo\Desktop\fsdownload\myblog-0.0.1-SNAPSHOT.jar!\BOOT-INF\classes\com\weiyu\service\BlogService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */