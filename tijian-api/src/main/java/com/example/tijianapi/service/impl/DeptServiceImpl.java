package com.example.tijianapi.service.impl;

import com.example.tijianapi.db.dao.DeptMapper;
import com.example.tijianapi.service.DeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class DeptServiceImpl implements DeptService {
    @Resource
    private DeptMapper deptDao;

    @Override
    public ArrayList<HashMap> searchAllDept() {
        ArrayList<HashMap> list = deptDao.searchAllDept();
        return list;
    }
}

