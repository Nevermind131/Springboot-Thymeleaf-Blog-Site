package com.weiyu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.weiyu.entity.Blog;
import com.weiyu.entity.Tag;
import java.util.List;

public interface TagService extends IService<Tag> {
  PageInfo<Tag> listTag(int paramInt) throws Exception;
  
  List<Tag> listTag() throws Exception;
  
  List<Tag> listTag(String paramString) throws Exception;
  
  List<Tag> getTags(Blog paramBlog) throws Exception;
  
  Tag getByName(String paramString);
  
  List<Tag> listTagTop(Integer paramInteger) throws Exception;
}


/* Location:              C:\Users\lenovo\Desktop\fsdownload\myblog-0.0.1-SNAPSHOT.jar!\BOOT-INF\classes\com\weiyu\service\TagService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */