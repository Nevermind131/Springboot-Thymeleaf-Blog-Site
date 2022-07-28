/*    */
package com.weiyu.entity;
/*    */
/*    */

import com.baomidou.mybatisplus.annotation.IdType;
/*    */ import com.baomidou.mybatisplus.annotation.TableField;
/*    */ import com.baomidou.mybatisplus.annotation.TableId;
/*    */ import com.fasterxml.jackson.annotation.JsonFormat;
/*    */ import com.weiyu.entity.Tag;
/*    */ import java.io.Serializable;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Date;
/*    */ import java.util.List;

public class Blog  implements Serializable{
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
    /*    */   private Long views;

    /*    */
    /*    */
    public void setId(Long id) {
        /* 31 */
        this.id = id;
    }

    @TableField("recommend")
    private Boolean recommend;
    private Boolean shareStatement;
    private Boolean commentabled;
    private Integer flag;
    private Boolean published;
    private Long typeId;
    @TableField(exist = false)
    private String tagIds;
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

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public void setTagIds(String tagIds) {
        this.tagIds = tagIds;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public String toString() {
        return "Blog(id=" + getId() + ", title=" + getTitle() + ", description=" + getDescription() + ", content=" + getContent() + ", createTime=" + getCreateTime() + ", updateTime=" + getUpdateTime() + ", views=" + getViews() + ", recommend=" + getRecommend() + ", shareStatement=" + getShareStatement() + ", commentabled=" + getCommentabled() + ", flag=" + getFlag() + ", published=" + getPublished() + ", typeId=" + getTypeId() + ", tagIds=" + getTagIds() + ", userId=" + getUserId() + ", tags=" + getTags() + ")";
    }



    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    public Long getId() {
        /* 38 */
        return this.id;
        /*    */
    }

    public String getTitle() {
        /* 40 */
        return this.title;
        /*    */
    }

    public String getDescription() {
        /* 42 */
        return this.description;
        /*    */
    }

    public String getContent() {
        /* 44 */
        return this.content;
        /*    */
    }

    /*    */
    public Date getCreateTime() {
        /* 47 */
        return this.createTime;
        /*    */
    }

    /*    */
    public Date getUpdateTime() {
        /* 50 */
        return this.updateTime;
        /*    */
    }

    public Long getViews() {
        /* 52 */
        return this.views;
        /*    */
    }

    /*    */
    public Boolean getRecommend() {
        /* 55 */
        return this.recommend;
        /*    */
    }

    public Boolean getShareStatement() {
        /* 57 */
        return this.shareStatement;
        /*    */
    }

    public Boolean getCommentabled() {
        /* 59 */
        return this.commentabled;
        /*    */
    }

    public Integer getFlag() {
        /* 61 */
        return this.flag;
        /*    */
    }

    public Boolean getPublished() {
        /* 63 */
        return this.published;
        /*    */
    }

    public Long getTypeId() {
        /* 65 */
        return this.typeId;
        /*    */
    }

    /*    */
    public String getTagIds() {
        /* 68 */
        return this.tagIds;
        /*    */
    }

    public Long getUserId() {
        /* 70 */
        return this.userId;
        /*    */
    }

    @TableField(exist = false)
    /* 72 */ private List<Tag> tags = new ArrayList<>();

    public List<Tag> getTags() {
        /* 73 */
        return this.tags;
        /*    */
    }

    /*    */
    /*    */
    public void init() {
        /* 77 */
        this.tagIds = tagsToIds(getTags());
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */
    private String tagsToIds(List<Tag> tags) {
        /* 83 */
        if (!tags.isEmpty()) {
            /* 84 */
            StringBuffer ids = new StringBuffer();
            /* 85 */
            boolean flag = false;
            /* 86 */
            for (Tag tag : tags) {
                /* 87 */
                if (flag) {
                    /* 88 */
                    ids.append(",");
                    /*    */
                } else {
                    /* 90 */
                    flag = true;
                    /*    */
                }
                /* 92 */
                ids.append(tag.getId());
                /*    */
            }
            /* 94 */
            return ids.toString();
            /*    */
        }
        /* 96 */
        return this.tagIds;
        /*    */
    }
    /*    */
}


/* Location:              C:\Users\lenovo\Desktop\fsdownload\myblog-0.0.1-SNAPSHOT.jar!\BOOT-INF\classes\com\weiyu\entity\Blog.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */