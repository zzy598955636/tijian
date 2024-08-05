package com.example.tijianapi.service;

import com.example.tijianapi.common.PageUtils;

import java.util.Map;

public interface UserService {
    public Integer login(Map param);

    public int updatePassword(Map param);

    public PageUtils searchByPage(Map param);
}
