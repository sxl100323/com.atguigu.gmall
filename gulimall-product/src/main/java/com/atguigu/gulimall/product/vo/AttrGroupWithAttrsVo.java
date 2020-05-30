package com.atguigu.gulimall.product.vo;

import com.atguigu.gulimall.product.entity.AttrEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.List;

@Data
public class AttrGroupWithAttrsVo {
    @TableId
    private Long attrGroupId;
    /**
     *
     */
    private String attrGroupName;
    /**
     *
     */
    private Integer sort;
    /**
     *
     */
    private String descript;
    /**
     *
     */
    private String icon;
    /**
     *
     */
    private Long catelogId;

    private List<AttrEntity> attrs;

}
