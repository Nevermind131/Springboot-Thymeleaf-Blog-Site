/*    */ package com.weiyu.service.ipml;
/*    */ 
/*    */ import com.baomidou.mybatisplus.core.conditions.Wrapper;
/*    */ import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
/*    */ import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
/*    */ import com.weiyu.entity.User;
/*    */ import com.weiyu.mapper.UserMapper;
/*    */ import com.weiyu.service.UserService;
/*    */ import com.weiyu.util.MD5Utils;
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
/*    */ public class UserServiceImpl
/*    */   extends ServiceImpl<UserMapper, User>
/*    */   implements UserService,IService<User>
/*    */ {
/*    */   @Autowired
/*    */   private UserMapper userMapper;
/*    */   
/*    */   public User checkUser(String username, String password) {

    /* 34 */     QueryWrapper<User> qw = new QueryWrapper();
/* 35 */     ((QueryWrapper)qw.eq("username", username)).eq("password", MD5Utils.code(password));
/* 36 */     User user = (User)this.userMapper.selectOne((Wrapper)qw);
/* 37 */     return user;
/*    */   }
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\fsdownload\myblog-0.0.1-SNAPSHOT.jar!\BOOT-INF\classes\com\weiyu\service\ipml\UserServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */