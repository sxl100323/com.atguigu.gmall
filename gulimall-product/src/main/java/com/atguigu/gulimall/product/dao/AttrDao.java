package com.atguigu.gulimall.product.dao;

import com.atguigu.gulimall.product.entity.AttrEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * 
 * @author shengmin
 * @email shengmin100323@163.com
 * @date 2020-04-06 20:21:12
 */
@Mapper
public interface AttrDao extends BaseMapper<AttrEntity> {


    List<Long> selectSearchAttrIds(@Param("attrIds") List<Long> attrIds);
}
