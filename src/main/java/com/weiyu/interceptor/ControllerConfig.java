/*    */ package com.weiyu.interceptor;
/*    */ 
/*    */ import com.weiyu.interceptor.LoginInterceptor;
/*    */ import org.springframework.context.annotation.Configuration;
/*    */ import org.springframework.web.servlet.HandlerInterceptor;
/*    */ import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
/*    */ import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/*    */ 
/*    */ @Configuration
/*    */ public class ControllerConfig implements WebMvcConfigurer {
/*    */   public void addInterceptors(InterceptorRegistry registry) {
/* 12 */     registry.addInterceptor((HandlerInterceptor)new LoginInterceptor())
/* 13 */       .addPathPatterns(new String[] { "/admin/**"
/* 14 */         }).excludePathPatterns(new String[] { "/admin"
/* 15 */         }).excludePathPatterns(new String[] { "/admin/login" });
/*    */   }
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\fsdownload\myblog-0.0.1-SNAPSHOT.jar!\BOOT-INF\classes\com\weiyu\interceptor\ControllerConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */