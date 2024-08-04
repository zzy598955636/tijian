package com.example.tijianapi.service.impl;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.MD5;
import com.example.tijianapi.db.dao.UserMapper;
import com.example.tijianapi.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
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

}
