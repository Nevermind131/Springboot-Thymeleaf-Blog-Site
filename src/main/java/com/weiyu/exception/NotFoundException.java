/*    */ package com.weiyu.exception;
/*    */ 
/*    */ import org.springframework.http.HttpStatus;
/*    */ import org.springframework.web.bind.annotation.ResponseStatus;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @ResponseStatus(HttpStatus.NOT_FOUND)
/*    */ public class NotFoundException
/*    */   extends RuntimeException
/*    */ {
/*    */   public NotFoundException() {}
/*    */   
/*    */   public NotFoundException(String message) {
/* 16 */     super(message);
/*    */   }
/*    */   
/*    */   public NotFoundException(String message, Throwable cause) {
/* 20 */     super(message, cause);
/*    */   }
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\fsdownload\myblog-0.0.1-SNAPSHOT.jar!\BOOT-INF\classes\com\weiyu\exception\NotFoundException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */