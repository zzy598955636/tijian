package com.example.tijianapi.db.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;
import java.util.Set;

/**
* @author Lenovo
* @description 针对表【tb_user(用户表)】的数据库操作Mapper
* @createDate 2024-07-31 16:29:35
* @Entity com.example.tijianapi.db.pojo.UserEntity
*/
@Mapper
public interface UserMapper {
    public Set<String> searchUserPermissions(int userId);

    public Integer login(Map param);
}




