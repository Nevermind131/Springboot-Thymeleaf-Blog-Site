package com.weiyu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.weiyu.entity.Blog;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BlogMapper extends BaseMapper<Blog> {
  int insertSelective(Blog paramBlog);
  
  int updateByPrimaryKeySelective(Blog paramBlog);
  
  List<String> getGroupYear();
  
  List<Blog> getByYear(String paramString);
  
  Blog getLast(Date paramDate);
  
  Blog getNext(Date paramDate);
}


/* Location:              C:\Users\lenovo\Desktop\fsdownload\myblog-0.0.1-SNAPSHOT.jar!\BOOT-INF\classes\com\weiyu\mapper\BlogMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */