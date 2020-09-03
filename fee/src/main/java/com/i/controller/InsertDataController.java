package com.i.controller;

import com.i.pojo.RespBean;
import com.i.pojo.TMybatisgeneratortesttable;
import com.i.service.Implements.InsertDataServiceImplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InsertDataController {
    @Autowired
    InsertDataServiceImplements insertDataServiceImplements;
@PostMapping("/insertData")
    public RespBean insertData(@RequestBody TMybatisgeneratortesttable tMybatisgeneratortesttable) {
    TMybatisgeneratortesttable tMybatisgeneratortesttable1 = new TMybatisgeneratortesttable();
    tMybatisgeneratortesttable1.setName(tMybatisgeneratortesttable.getName());
    tMybatisgeneratortesttable1.setGender(tMybatisgeneratortesttable.getGender());
    tMybatisgeneratortesttable1.setTelephone(tMybatisgeneratortesttable.getTelephone());
    tMybatisgeneratortesttable1.setAddress(tMybatisgeneratortesttable.getAddress());
    System.out.println(tMybatisgeneratortesttable.getName());
    int i = insertDataServiceImplements.insertTestData(tMybatisgeneratortesttable1);
        if (i == 1) {
            System.out.println(System.currentTimeMillis());
            return RespBean.ok("insert success!");
        }
    System.out.println(System.currentTimeMillis());
        return RespBean.error("insert fail!");
    }

}
