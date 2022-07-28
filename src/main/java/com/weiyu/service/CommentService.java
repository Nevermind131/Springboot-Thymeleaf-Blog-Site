package com.weiyu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.weiyu.entity.Comment;
import java.util.List;

public interface CommentService extends IService<Comment> {
  List<Comment> listCommentByBlogId(Long paramLong);
  
  Boolean saveComment(Comment paramComment) throws Exception;
}


/* Location:              C:\Users\lenovo\Desktop\fsdownload\myblog-0.0.1-SNAPSHOT.jar!\BOOT-INF\classes\com\weiyu\service\CommentService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */