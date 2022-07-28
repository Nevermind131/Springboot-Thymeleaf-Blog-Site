
package com.weiyu.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;

@Data
public class Type implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @NotBlank(message = "分类名称不能为空")
    private String name;
    private Long number;




}


/* Location:              C:\Users\lenovo\Desktop\fsdownload\myblog-0.0.1-SNAPSHOT.jar!\BOOT-INF\classes\com\weiyu\entity\Type.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */