package com.example.tijianapi.service.impl;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.MD5;
import com.example.tijianapi.common.PageUtils;
import com.example.tijianapi.db.dao.UserMapper;
import com.example.tijianapi.db.pojo.UserEntity;
import com.example.tijianapi.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public Integer login(Map param) {
        String username = MapUtil.getStr(param, "username");
        String password = MapUtil.getStr(param, "password");
        MD5 md5 = MD5.create();
        String temp = md5.digestHex(username);
        String tempStart = StrUtil.subWithLength(temp, 0, 6);
        String tempEnd = StrUtil.subSuf(temp, temp.length() - 3);
        password = md5.digestHex(tempStart + password + tempEnd).toUpperCase();
        param.replace("password", password);
        Integer userId = userMapper.login(param);
        return userId;
    }

    @Override
    public int updatePassword(Map param) {
        int userId = MapUtil.getInt(param,"userId");
        String username = userMapper.searchUsernameById(userId);

        MD5 md5 = MD5.create();
        String password = MapUtil.getStr(param,"password");
        String temp = md5.digestHex(username);
        String tempStart = StrUtil.subWithLength(temp, 0, 6);
        String tempEnd = StrUtil.subSuf(temp, temp.length() - 3);
        password = md5.digestHex(tempStart + password + tempEnd).toUpperCase();
        param.replace("password", password);

        String newPassword = MapUtil.getStr(param, "newPassword");
        newPassword = md5.digestHex(tempStart + newPassword + tempEnd).toUpperCase();
        param.replace("newPassword", newPassword);

        int rows = userMapper.updatePassword(param);

        return rows;
    }

    @Override
    public PageUtils searchByPage(Map param) {
        ArrayList<HashMap> list = new ArrayList<>();
        long count = userMapper.searchCount(param);
        if (count > 0) {
            list = userMapper.searchByPage(param);
        }
        int page = MapUtil.getInt(param,"page");
        int length = MapUtil.getInt(param,"length");
        PageUtils pageUtils = new PageUtils(list, count, page, length);
        return pageUtils;
    }

    @Override
    @Transactional
    public int insert(UserEntity user) {
        MD5 md5 = MD5.create();
        String temp = md5.digestHex(user.getUsername());
        String tempStart = StrUtil.subWithLength(temp, 0, 6);
        String tempEnd = StrUtil.subSuf(temp, temp.length() - 3);
        String password = md5.digestHex(tempStart + user.getPassword() + tempEnd).toUpperCase();
        user.setPassword(password);
        int rows = userMapper.insert(user);
        return rows;
    }

    @Override
    public HashMap searchById(int userId) {
        HashMap map = userMapper.searchById(userId);
        return map;
    }

    @Override
    @Transactional
    public int update(Map param) {
        int rows = userMapper.update(param);
        return rows;
    }

    @Override
    @Transactional
    public int deleteByIds(Integer[] ids) {
        int rows = userMapper.deleteByIds(ids);
        return rows;
    }

    @Override
    @Transactional
    public int dismiss(int userId) {
        int rows = userMapper.dismiss(userId);
        return rows;
    }

}
