/*    */
package com.weiyu.entity;
/*    */
/*    */

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
/*    */ import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
/*    */ import java.io.Serializable;
import java.util.ArrayList;
/*    */ import java.util.Date;
/*    */ import java.util.List;

/*    */
/*    */
@TableName(autoResultMap = true)
/*    */ public class Comment implements Serializable {
    /*    */   private static final long serialVersionUID = 1L;
    /*    */
    @TableId(value = "id", type = IdType.AUTO)
    /*    */ private Long id;
    /*    */   private String nickname;
    /*    */   private String email;
    /*    */   private String avatar;
    /*    */   private Date createTime;
    /*    */   private String content;
    /*    */   private Long blogId;
    /*    */   private Long parentId;
    /*    */
    @TableField(typeHandler = FastjsonTypeHandler.class)
    /*    */ private com.weiyu.entity.Comment parentComment;
    /*    */
    @TableField(typeHandler = FastjsonTypeHandler.class)
    /*    */ private List<Comment> replyComments;
    /*    */   private boolean adminComment;

    /*    */
    /* 27 */
    public void setId(Long id) {
        this.id = id;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public void setParentComment(com.weiyu.entity.Comment parentComment) {
        this.parentComment = parentComment;
    }

    public void setReplyComments(List<Comment> replyComments) {
        this.replyComments = replyComments;
    }

    public void setAdminComment(boolean adminComment) {
        this.adminComment = adminComment;
    }


    public Long getId() {
        return this.id;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getEmail() {
        return this.email;
    }

    public List<Comment> getReplyComments() {
        return this.replyComments;
    }

    /*    */
    public String getAvatar() {
        return this.avatar;
    }

    /* 62 */
    public Date getCreateTime() {
        return this.createTime;
    }

    public String getContent() {
        return this.content;
    }

    public Long getBlogId() {
        return this.blogId;
    }

    public Long getParentId() {
        return this.parentId;
    }

    public com.weiyu.entity.Comment getParentComment() {
        return this.parentComment;
    }

    public boolean isAdminComment() {
        return this.adminComment;
    }
    /*    */
    /*    */
}


/* Location:              C:\Users\lenovo\Desktop\fsdownload\myblog-0.0.1-SNAPSHOT.jar!\BOOT-INF\classes\com\weiyu\entity\Comment.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */