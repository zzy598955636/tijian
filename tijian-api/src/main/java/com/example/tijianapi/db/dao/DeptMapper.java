package com.example.tijianapi.db.dao;

import java.util.ArrayList;
import java.util.HashMap;

/**
* @author Lenovo
* @description 针对表【tb_dept(部门表)】的数据库操作Mapper
* @createDate 2024-07-31 16:29:35
* @Entity com.example.tijianapi.db.pojo.DeptEntity
*/
public interface DeptMapper {
    public ArrayList<HashMap> searchAllDept();
}




