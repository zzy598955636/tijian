package com.example.tijianapi.api;

import cn.dev33.satoken.annotation.SaCheckLogin;
import com.example.tijianapi.common.R;
import com.example.tijianapi.config.sa_token.StpCustomerUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/mis/customer")
public class CustomerController {

    @GetMapping("/search")
    @SaCheckLogin(type = StpCustomerUtil.TYPE)
    public String search(){
        return "test";
    }

    @PostMapping("/demo")
    public HashMap demo(String str) {
        System.out.println(str);
        return new HashMap() {{
            put("msg", "HelloWorld");
        }};
    }
    @GetMapping("/demo1")
    public R demo() {
        return R.ok("执行成功");
    }
}
