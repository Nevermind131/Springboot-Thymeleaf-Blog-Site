package com.weiyu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.weiyu.entity.Blog;
import com.weiyu.entity.Tag;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TagMapper extends BaseMapper<Tag> {
  List<Tag> findAllByOrder();
  
  List<Tag> joinQuery(Blog paramBlog);
  
  void updateNumber(Tag paramTag);
}


/* Location:              C:\Users\lenovo\Desktop\fsdownload\myblog-0.0.1-SNAPSHOT.jar!\BOOT-INF\classes\com\weiyu\mapper\TagMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */