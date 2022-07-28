package com.weiyu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.weiyu.entity.User;

public interface UserService extends IService<User> {
  User checkUser(String paramString1, String paramString2);
}


/* Location:              C:\Users\lenovo\Desktop\fsdownload\myblog-0.0.1-SNAPSHOT.jar!\BOOT-INF\classes\com\weiyu\service\UserService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */