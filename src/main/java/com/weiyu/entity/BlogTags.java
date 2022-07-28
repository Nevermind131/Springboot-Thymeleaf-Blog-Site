/*    */
package com.weiyu.entity;
/*    */
/*    */

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

public class BlogTags implements Serializable{
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private Long blogId;
    private Long tagId;

    /*    */
    /*    */
    public void setId(Long id) {
        /* 18 */
        this.id = id;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }


    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    public Long getId() {
        /* 25 */
        return this.id;
        /*    */
    }

    public Long getBlogId() {
        /* 27 */
        return this.blogId;
        /*    */
    }

    public Long getTagId() {
        /* 29 */
        return this.tagId;
        /*    */
    }
    /*    */
}

