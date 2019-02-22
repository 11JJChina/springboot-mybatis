package com.tallsafe.springbootmybatis.controller;

import com.tallsafe.springbootmybatis.core.http.HttpResult;
import com.tallsafe.springbootmybatis.core.page.PageRequest;
import com.tallsafe.springbootmybatis.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("menu")
public class SysMenuController {
    @Autowired
    private SysMenuService sysMenuService;

    @PostMapping(value="/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageQuery) {
        return HttpResult.ok(sysMenuService.findPage(pageQuery));
    }
}
