package com.weiyu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.weiyu.entity.Type;
import java.util.List;

public interface TypeService extends IService<Type> {
  PageInfo<Type> listType(int paramInt) throws Exception;
  
  List<Type> listType() throws Exception;
  
  List<Type> listTypeTop(Integer paramInteger) throws Exception;
  
  Type getByName(String paramString);
}


/* Location:              C:\Users\lenovo\Desktop\fsdownload\myblog-0.0.1-SNAPSHOT.jar!\BOOT-INF\classes\com\weiyu\service\TypeService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */