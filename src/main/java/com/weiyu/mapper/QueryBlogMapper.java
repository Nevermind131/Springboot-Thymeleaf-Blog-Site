package com.weiyu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.weiyu.entity.Blog;
import com.weiyu.entity.QueryBlog;
import com.weiyu.entity.Tag;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QueryBlogMapper extends BaseMapper<QueryBlog> {
  List<QueryBlog> findAllByOrder(Blog paramBlog);
  
  List<QueryBlog> findPublishedByOrder(Blog paramBlog);
  
  List<QueryBlog> findRecommendByOrder();
  
  List<QueryBlog> findByQuery(String paramString);
  
  List<QueryBlog> findByTagId(Long paramLong);
  
  QueryBlog findOneById(Long paramLong);
  
  List<Tag> getTagsOfBlog(Long paramLong);
}


/* Location:              C:\Users\lenovo\Desktop\fsdownload\myblog-0.0.1-SNAPSHOT.jar!\BOOT-INF\classes\com\weiyu\mapper\QueryBlogMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */