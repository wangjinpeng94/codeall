package com.i.mapper;


import com.i.entity.Item;
import org.apache.ibatis.annotations.Param;

public interface ItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Item record);

    int insertSelective(Item record);

    Item selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);

    Item selectByCode(@Param("code") String code);
}