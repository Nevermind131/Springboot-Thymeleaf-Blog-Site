/*    */
package com.weiyu.entity;
/*    */
/*    */

import com.github.pagehelper.PageInfo;
import com.weiyu.entity.Blog;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class ArchiveResult implements Serializable {
    PageInfo<String> pageInfo;
    List<Map.Entry<String, List<Blog>>> list;


    public void setPageInfo(PageInfo<String> pageInfo) {
        this.pageInfo = pageInfo;
    }

    public void setList(List<Map.Entry<String, List<Blog>>> list) {
        this.list = list;
    }

}

