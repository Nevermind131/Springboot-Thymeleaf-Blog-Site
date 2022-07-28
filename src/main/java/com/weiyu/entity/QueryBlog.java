/*    */
package com.weiyu.entity;
/*    */
/*    */

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
/*    */ import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
/*    */ import com.weiyu.entity.Tag;
/*    */ import com.weiyu.entity.Type;
/*    */ import java.io.Serializable;
import java.text.SimpleDateFormat;
/*    */ import java.util.*;
/*    */
/*    */

/*    */
/*    */
@TableName("blog")
/*    */ public class QueryBlog implements Serializable {
    /*    */   private static final long serialVersionUID = 1L;
    /*    */
    @TableId(value = "id", type = IdType.AUTO)
    /*    */ private Long id;
    /*    */   private String title;
    /*    */   private String description;
    /*    */   private String content;
    /*    */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    /*    */ private Date createTime;
    /*    */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    /*    */ private Date updateTime;

    /*    */
    /* 25 */
    public void setId(Long id) {
        this.id = id;
    }

    private Long views;
    @TableField("recommend")
    private Boolean recommend;
    @TableField("share_statement")
    private Boolean shareStatement;
    @TableField("commentabled")
    private Boolean commentabled;
    private Integer flag;
    private Boolean published;
    private Type type;
    private Long userId;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public void setViews(Long views) {
        this.views = views;
    }

    public void setRecommend(Boolean recommend) {
        this.recommend = recommend;
    }

    public void setShareStatement(Boolean shareStatement) {
        this.shareStatement = shareStatement;
    }

    public void setCommentabled(Boolean commentabled) {
        this.commentabled = commentabled;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }


    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    public Long getId() {
        /* 33 */
        return this.id;
        /*    */
    }

    public String getTitle() {
        /* 35 */
        return this.title;
        /*    */
    }

    public String getDescription() {
        /* 37 */
        return this.description;
        /*    */
    }

    public String getContent() {
        /* 39 */
        return this.content;
        /*    */
    }

    /*    */
    public Date getCreateTime() {
        /* 42 */
        return this.createTime;
        /*    */
    }

    /*    */
    public Date getUpdateTime() {
        /* 45 */
        return this.updateTime;
        /*    */
    }

    /*    */
    public Long getViews() {
        /* 48 */
        return this.views;
        /*    */
    }

    /*    */
    public Boolean getRecommend() {
        /* 51 */
        return this.recommend;
        /*    */
    }

    /*    */
    public Boolean getShareStatement() {
        /* 54 */
        return this.shareStatement;
        /*    */
    }

    /*    */
    public Boolean getCommentabled() {
        /* 57 */
        return this.commentabled;
        /*    */
    }

    public Integer getFlag() {
        /* 59 */
        return this.flag;
        /*    */
    }

    public Boolean getPublished() {
        /* 61 */
        return this.published;
        /*    */
    }

    public Type getType() {
        /* 63 */
        return this.type;
        /*    */
    }

    public Long getUserId() {
        /* 65 */
        return this.userId;
        /*    */
    }

    @TableField(exist = false)
    /* 67 */ private List<Tag> tags = new ArrayList<>();

    public List<Tag> getTags() {
        /* 68 */
        return this.tags;
        /*    */
    }

    /*    */
    public String getDateString() {
        /* 71 */
        TimeZone timeZoneSh = TimeZone.getTimeZone("Asia/Shanghai");
        /* 72 */
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        /* 73 */
        sdf.setTimeZone(timeZoneSh);
        /* 74 */
        return sdf.format(this.createTime);
        /*    */
    }
    /*    */
}


/* Location:              C:\Users\lenovo\Desktop\fsdownload\myblog-0.0.1-SNAPSHOT.jar!\BOOT-INF\classes\com\weiyu\entity\QueryBlog.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */