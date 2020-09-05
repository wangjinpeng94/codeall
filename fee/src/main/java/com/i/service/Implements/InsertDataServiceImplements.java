package com.i.service.Implements;

import com.i.mapper.TMybatisgeneratortesttableMapper;
import com.i.pojo.TMybatisgeneratortesttable;
import com.i.service.InsertDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsertDataServiceImplements implements InsertDataService {
    @Autowired
    TMybatisgeneratortesttableMapper tMybatisgeneratortesttableMapper;

    @Override
    public int insertTestData(TMybatisgeneratortesttable tMybatisgeneratortesttable) {

        return tMybatisgeneratortesttableMapper.insertData(tMybatisgeneratortesttable);
    }
}
