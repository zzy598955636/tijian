package com.example.tijianapi.api;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaMode;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import com.example.tijianapi.api.form.LoginForm;
import com.example.tijianapi.api.form.SearchUserByPageForm;
import com.example.tijianapi.api.form.UpdatePasswordForm;
import com.example.tijianapi.common.PageUtils;
import com.example.tijianapi.common.R;
import com.example.tijianapi.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/mis/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    public R login(@RequestBody @Valid LoginForm form) {
        //把Form对象转换成Map对象。因为Form对象中含有后端验证表达式，该对象仅用于Web层，不适合传给业务层
        Map param = BeanUtil.beanToMap(form);

        //获取登陆用户的主键值
        Integer userId = userService.login(param);
        if (userId != null) {
            /*
             * 实现同端互斥效果，把该用户Web端的令牌销毁。
             * 在其他浏览器上已经登陆的该账户，令牌就失效了，实现同端互斥。
             */
            StpUtil.logout(userId,"Web");

            //通过会话对象，向SaToken传递userId
            StpUtil.login(userId,"Web");
            //生成新的令牌字符串，标记该令牌是给Web端用户使用的
            String token = StpUtil.getTokenValueByLoginId(userId, "Web");
            //获取用户的权限列表
            List<String> permissions = StpUtil.getPermissionList();
            //向前端返回数据
            return R.ok().put("result", true).put("token", token).put("permissions", permissions);
        }
        //如果登陆失败，返回给前端的result是false
        return R.ok().put("result", false);
    }

    @SaCheckLogin
    @GetMapping("/logout")
    public R logout(){
        int userId = StpUtil.getLoginIdAsInt();

        StpUtil.logout(userId,"web");
        return R.ok();
    }


    @RequestMapping("/updatePassword")
    public R updatePassword(@Valid @RequestBody UpdatePasswordForm form){
        int userId = StpUtil.getLoginIdAsInt();
        HashMap param = new HashMap(){{
            put("userId", userId);
            put("password", form.getPassword());
            put("newPassword", form.getNewPassword());
        }};
        int  rows = userService.updatePassword(param);
        return R.ok().put("rows", rows);
    }

    @PostMapping("/searchByPage")
    @SaCheckPermission(value = {"ROOT", "USER:SELECT"}, mode = SaMode.OR)
    public R searchByPage(@Valid @RequestBody SearchUserByPageForm form) {
        int page = form.getPage();
        int length = form.getLength();
        int start = (page - 1) * length;
        Map param = BeanUtil.beanToMap(form);
        param.put("start", start);
        PageUtils pageUtils = userService.searchByPage(param);
        return R.ok().put("page", pageUtils);
    }
}
