/*    */ package com.weiyu.config;

/*    */
/*    */ import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
/*    */ import org.mybatis.spring.annotation.MapperScan;
/*    */ import org.springframework.context.annotation.Bean;
/*    */ import org.springframework.context.annotation.Configuration;
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
/*    */ @Configuration
/*    */ @MapperScan({"com.weiyu.mapper"})
/*    */ public class MybatisPlusConfig
/*    */ {
/*    */   @Bean
/*    */   public PaginationInterceptor paginationInterceptor() {
/* 23 */     return new PaginationInterceptor();
/*    */   }
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\fsdownload\myblog-0.0.1-SNAPSHOT.jar!\BOOT-INF\classes\com\weiyu\config\MybatisPlusConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */