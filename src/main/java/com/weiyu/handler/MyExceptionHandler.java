/*    */ package com.weiyu.handler;
/*    */ 
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import org.springframework.core.annotation.AnnotationUtils;
/*    */ import org.springframework.web.bind.annotation.ControllerAdvice;
/*    */ import org.springframework.web.bind.annotation.ExceptionHandler;
/*    */ import org.springframework.web.bind.annotation.ResponseStatus;
/*    */ import org.springframework.web.servlet.ModelAndView;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @ControllerAdvice
/*    */ public class MyExceptionHandler
/*    */ {
/* 19 */   private Logger logger = LoggerFactory.getLogger(getClass());
/*    */ 
/*    */ 
/*    */   
/*    */   @ExceptionHandler({Exception.class})
/*    */   public ModelAndView exceptionHandler(HttpServletRequest request, Exception e) throws Exception {
/* 25 */     this.logger.error("Request URL : {}, Exception : {}", request.getRequestURL(), e);
/*    */ 
/*    */     
/* 28 */     if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
/* 29 */       throw e;
/*    */     }
/*    */     
/* 32 */     ModelAndView mv = new ModelAndView();
/* 33 */     mv.addObject("url", request.getRequestURL());
/* 34 */     mv.addObject("exception", e);
/* 35 */     mv.setViewName("error/error");
/* 36 */     return mv;
/*    */   }
/*    */ }


/* Location:              C:\Users\lenovo\Desktop\fsdownload\myblog-0.0.1-SNAPSHOT.jar!\BOOT-INF\classes\com\weiyu\handler\MyExceptionHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */