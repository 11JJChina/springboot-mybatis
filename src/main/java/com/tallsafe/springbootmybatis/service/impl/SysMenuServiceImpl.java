package com.tallsafe.springbootmybatis.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tallsafe.springbootmybatis.core.page.PageRequest;
import com.tallsafe.springbootmybatis.core.page.PageResult;
import com.tallsafe.springbootmybatis.core.page.PageUtils;
import com.tallsafe.springbootmybatis.dao.SysMenuMapper;
import com.tallsafe.springbootmybatis.model.SysMenu;
import com.tallsafe.springbootmybatis.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysMenuServiceImpl implements SysMenuService {
    @Autowired
    private SysMenuMapper sysMenuMapper;
    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
    }

    /**
     * 调用分页插件完成分页
     * @param pageRequest
     * @return
     */
    private PageInfo<SysMenu> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<SysMenu> sysMenus = sysMenuMapper.selectPage();
        return new PageInfo<SysMenu>(sysMenus);
    }
}
