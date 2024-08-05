package com.example.tijianapi.service.impl;

import com.example.tijianapi.db.dao.RoleMapper;
import com.example.tijianapi.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper roleDao;

    @Override
    public ArrayList<HashMap> searchAllRole() {
        ArrayList<HashMap> list = roleDao.searchAllRole();
        return list;
    }
}
