package com.i.mapper;

import org.apache.ibatis.annotations.Param;
import com.i.pojo.TMybatisgeneratortesttable;
import com.i.pojo.TMybatisgeneratortesttableExample;
import org.springframework.stereotype.Component;

import java.util.List;

public interface TMybatisgeneratortesttableMapper {
    long countByExample(TMybatisgeneratortesttableExample example);

    int deleteByExample(TMybatisgeneratortesttableExample example);

    int deleteByPrimaryKey(Integer id);

    int insertData( TMybatisgeneratortesttable record);

    int insertSelective(TMybatisgeneratortesttable record);

    List<TMybatisgeneratortesttable> selectByExample(TMybatisgeneratortesttableExample example);

    TMybatisgeneratortesttable selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TMybatisgeneratortesttable record, @Param("example") TMybatisgeneratortesttableExample example);

    int updateByExample(@Param("record") TMybatisgeneratortesttable record, @Param("example") TMybatisgeneratortesttableExample example);

    int updateByPrimaryKeySelective(TMybatisgeneratortesttable record);

    int updateByPrimaryKey(TMybatisgeneratortesttable record);
}