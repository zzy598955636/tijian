package com.example.tijianapi.api;

import com.example.tijianapi.common.R;
import com.example.tijianapi.service.DeptService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/mis/dept")
public class DeptController {
    @Resource
    private DeptService deptService;

    @GetMapping("/searchAllDept")
    public R searchAllDept() {
        ArrayList<HashMap> list = deptService.searchAllDept();
        return R.ok().put("list", list);
    }
}

