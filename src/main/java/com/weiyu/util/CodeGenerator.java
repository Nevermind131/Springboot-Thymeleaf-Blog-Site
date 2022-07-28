/*     */ package com.weiyu.util;
/*     */ 
/*     */ import com.baomidou.mybatisplus.annotation.DbType;
/*     */ import com.baomidou.mybatisplus.annotation.IdType;
/*     */ import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
/*     */ import com.baomidou.mybatisplus.core.toolkit.StringUtils;
/*     */ import com.baomidou.mybatisplus.generator.AutoGenerator;
/*     */ import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
/*     */ import com.baomidou.mybatisplus.generator.config.GlobalConfig;
/*     */ import com.baomidou.mybatisplus.generator.config.PackageConfig;
/*     */ import com.baomidou.mybatisplus.generator.config.StrategyConfig;
/*     */ import com.baomidou.mybatisplus.generator.config.rules.DateType;
/*     */ import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
/*     */ import java.util.Scanner;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CodeGenerator
/*     */ {
/*     */   public static String scanner(String tip) {
/*  25 */     Scanner scanner = new Scanner(System.in);
/*  26 */     StringBuilder help = new StringBuilder();
/*  27 */     help.append("请输入" + tip + "：");
/*  28 */     System.out.println(help.toString());
/*  29 */     if (scanner.hasNext()) {
/*  30 */       String ipt = scanner.next();
/*  31 */       if (StringUtils.isNotBlank(ipt)) {
/*  32 */         return ipt;
/*     */       }
/*     */     } 
/*  35 */     throw new MybatisPlusException("请输入正确的" + tip + "！");
/*     */   }
/*     */ 
/*     */   
/*     */   public static void main(String[] args) {
/*  40 */     AutoGenerator mpg = new AutoGenerator();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  45 */     GlobalConfig gc = new GlobalConfig();
/*     */ 
/*     */ 
/*     */     
/*  49 */     gc.setOutputDir(scanner("请输入你的项目路径") + "/src/main/java");
/*  50 */     gc.setAuthor("weiyu");
/*     */     
/*  52 */     gc.setOpen(false);
/*     */     
/*  54 */     gc.setFileOverride(false);
/*     */     
/*  56 */     gc.setServiceName("%sService");
/*     */     
/*  58 */     gc.setSwagger2(true);
/*     */     
/*  60 */     gc.setIdType(IdType.AUTO);
/*     */     
/*  62 */     gc.setDateType(DateType.ONLY_DATE);
/*  63 */     mpg.setGlobalConfig(gc);
/*     */ 
/*     */     
/*  66 */     DataSourceConfig dsc = new DataSourceConfig();
/*  67 */     dsc.setUrl("jdbc:mysql:///myblog?serverTimezone=GMT");
/*     */     
/*  69 */     dsc.setDriverName("com.mysql.cj.jdbc.Driver");
/*  70 */     dsc.setUsername("root");
/*  71 */     dsc.setPassword("root");
/*  72 */     dsc.setDbType(DbType.MYSQL);
/*  73 */     mpg.setDataSource(dsc);
/*     */ 
/*     */     
/*  76 */     PackageConfig pc = new PackageConfig();
/*  77 */     pc.setModuleName(scanner("请输入模块名"));
/*  78 */     pc.setParent("com");
/*  79 */     pc.setController("controller");
/*  80 */     pc.setService("service");
/*  81 */     pc.setServiceImpl("service.ipml");
/*  82 */     pc.setMapper("mapper");
/*  83 */     pc.setXml("mapper");
/*  84 */     pc.setEntity("entity");
/*  85 */     mpg.setPackageInfo(pc);
/*     */ 
/*     */ 
/*     */     
/*  89 */     StrategyConfig strategy = new StrategyConfig();
/*     */     
/*  91 */     strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
/*  92 */     strategy.setNaming(NamingStrategy.underline_to_camel);
/*  93 */     strategy.setColumnNaming(NamingStrategy.underline_to_camel);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  98 */     strategy.setEntityLombokModel(true);
/*     */     
/* 100 */     strategy.setRestControllerStyle(true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 106 */     strategy.setControllerMappingHyphenStyle(true);
/*     */     
/* 108 */     mpg.setStrategy(strategy);
/*     */ 
/*     */     
/* 111 */     mpg.execute();
/*     */   }
/*     */ }


/* Location:              C:\Users\lenovo\Desktop\fsdownload\myblog-0.0.1-SNAPSHOT.jar!\BOOT-INF\classes\com\weiy\\util\CodeGenerator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */