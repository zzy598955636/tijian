package com.example.tijianapi.service;

import com.example.tijianapi.common.PageUtils;
import com.example.tijianapi.db.pojo.UserEntity;

import java.util.HashMap;
import java.util.Map;

public interface UserService {
    public Integer login(Map param);

    public int updatePassword(Map param);

    public PageUtils searchByPage(Map param);

    public int insert(UserEntity user);

    public HashMap searchById(int userId);
    public int update(Map param);

    public int deleteByIds(Integer[] ids);
}
