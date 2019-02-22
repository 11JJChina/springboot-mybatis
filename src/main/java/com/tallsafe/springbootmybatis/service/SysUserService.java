package com.tallsafe.springbootmybatis.service;

import com.tallsafe.springbootmybatis.core.page.PageRequest;
import com.tallsafe.springbootmybatis.core.page.PageResult;
import com.tallsafe.springbootmybatis.core.service.CurdService;
import com.tallsafe.springbootmybatis.model.SysUser;

import java.util.List;

public interface SysUserService extends CurdService<SysUser> {
    /**
     * 根据用户ID查找用户
     * @param userId
     * @return
     */
    SysUser findByUserId(Long userId);

    /**
     * 查找所有用户
     * @return
     */
    List<SysUser> findAll();

    PageResult findPage(PageRequest pageRequest);
}
