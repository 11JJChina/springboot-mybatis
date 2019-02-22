//package com.tallsafe.springbootmybatis.service.impl;
//
//import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;
//import com.tallsafe.springbootmybatis.core.page.PageRequest;
//import com.tallsafe.springbootmybatis.core.page.PageResult;
//import com.tallsafe.springbootmybatis.core.page.PageUtils;
//import com.tallsafe.springbootmybatis.dao.SysUserMapper;
//import com.tallsafe.springbootmybatis.model.SysUser;
//import com.tallsafe.springbootmybatis.service.SysUserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class SysUserServiceImpl implements SysUserService {
//    @Autowired
//    private SysUserMapper sysUserMapper;
//    @Override
//    public SysUser findByUserId(Long userId) {
//        return sysUserMapper.selectByPrimaryKey(userId);
//    }
//
//    @Override
//    public List<SysUser> findAll() {
//        return sysUserMapper.selectAll();
//    }
//
//    @Override
//    public int save(SysUser record) {
//        return sysUserMapper.insertSelective(record);
//    }
//
//    @Override
//    public int update(SysUser record) {
//        return sysUserMapper.updateByPrimaryKeySelective(record);
//    }
//
////    @Override
////    public int delete(SysUser record) {
////        return sysUserMapper.deleteByPrimaryKey(record.setId());
////    }
//
//    @Override
//    public int delete(List<SysUser> records) {
//        for(SysUser record:records){
//            delete(record);
//        }
//        return 1;
//    }
//
//    @Override
//    public SysUser findById(Long id) {
//        return sysUserMapper.selectByPrimaryKey(id);
//    }
//
////    @Override
////    public PageResult findPage(PageRequest pageRequest) {
////        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));;
////    }
//
//    /**
//     * 调用分页插件完成分页
//     * @param pageRequest
//     * @return
//     */
////    private PageInfo<SysUser> getPageInfo(PageRequest pageRequest) {
////        int pageNum = pageRequest.getPageNum();
////        int pageSize = pageRequest.getPageSize();
////        PageHelper.startPage(pageNum, pageSize);
////        List<SysUser> sysMenus = sysUserMapper.;
////        return new PageInfo<SysUser>(sysMenus);
////    }
//
//
//
//}
