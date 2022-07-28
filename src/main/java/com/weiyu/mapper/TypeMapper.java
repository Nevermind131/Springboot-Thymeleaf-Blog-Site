package com.weiyu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.weiyu.entity.Type;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TypeMapper extends BaseMapper<Type> {
  List<Type> findAllByOrder();
  
  void updateNumber(Type paramType);
}


/* Location:              C:\Users\lenovo\Desktop\fsdownload\myblog-0.0.1-SNAPSHOT.jar!\BOOT-INF\classes\com\weiyu\mapper\TypeMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */