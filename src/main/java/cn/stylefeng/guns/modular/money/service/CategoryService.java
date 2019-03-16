package cn.stylefeng.guns.modular.money.service;

import cn.stylefeng.guns.core.common.constant.state.ManagerStatus;
import cn.stylefeng.guns.modular.money.entity.Category;
import cn.stylefeng.guns.modular.money.entity.MoneyUser;
import cn.stylefeng.guns.modular.money.entity.WeixinUser;
import cn.stylefeng.guns.modular.money.mapper.CategoryMapper;
import cn.stylefeng.guns.modular.money.mapper.MoneyUserMapper;
import cn.stylefeng.guns.modular.money.mapper.WeixinUserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * <p>
 * 微信用户表 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2018-12-07
 */
@Service
public class CategoryService extends ServiceImpl<CategoryMapper, Category> {



//
//    /**
//     * 修改用户
//     *
//     * @author fengshuonan
//     * @Date 2018/12/24 22:53
//     */
//    public void editUser(WeixinUser user) {
//        WeixinUser oldUser = this.getByKey(user.getWeixinKey());
//        user.setId(oldUser.getId());
//        this.updateById(user);
//    }
//
//    /**
//     * 删除用户
//     *
//     * @author fengshuonan
//     * @Date 2018/12/24 22:54
//     */
//    public void deleteUser(Long userId) {
//
//        //不能删除超级管理员
//        if (userId.equals(Const.ADMIN_ID)) {
//            throw new ServiceException(BizExceptionEnum.CANT_DELETE_ADMIN);
//        }
//        this.assertAuth(userId);
//        this.setStatus(userId, ManagerStatus.DELETED.getCode());
//    }
//
//    /**
//     * 修改用户状态
//     *
//     * @author fengshuonan
//     * @Date 2018/12/24 22:45
//     */
//    public int setStatus(Long userId, String status) {
//        return this.baseMapper.setStatus(userId, status);
//    }
//
//    /**
//     * 修改密码
//     *
//     * @author fengshuonan
//     * @Date 2018/12/24 22:45
//     */
//    public void changePwd(String oldPassword, String newPassword) {
//        Long userId = ShiroKit.getUserNotNull().getId();
//        User user = this.getById(userId);
//
//        String oldMd5 = ShiroKit.md5(oldPassword, user.getSalt());
//
//        if (user.getPassword().equals(oldMd5)) {
//            String newMd5 = ShiroKit.md5(newPassword, user.getSalt());
//            user.setPassword(newMd5);
//            this.updateById(user);
//        } else {
//            throw new ServiceException(BizExceptionEnum.OLD_PWD_NOT_RIGHT);
//        }
//    }
//
//    /**
//     * 根据条件查询用户列表
//     *
//     * @author fengshuonan
//     * @Date 2018/12/24 22:45
//     */
//    public Page<Map<String, Object>> selectUsers(DataScope dataScope, String name, String beginTime, String endTime, Long deptId) {
//        Page page = LayuiPageFactory.defaultPage();
//        return this.baseMapper.selectUsers(page, dataScope, name, beginTime, endTime, deptId);
//    }
//
//    /**
//     * 设置用户的角色
//     *
//     * @author fengshuonan
//     * @Date 2018/12/24 22:45
//     */
//    public int setRoles(Long userId, String roleIds) {
//        return this.baseMapper.setRoles(userId, roleIds);
//    }
//
    /**
     * 通过微信key获取
     *
     * @author fengshuonan
     * @Date 2018/12/24 22:46
     */
    public WeixinUser getByKey(String weixinKey) {
        return this.baseMapper.getByKey(weixinKey);
    }
//
//    /**
//     * 获取用户菜单列表
//     *
//     * @author fengshuonan
//     * @Date 2018/12/24 22:46
//     */
//    public List<MenuNode> getUserMenuNodes(List<Long> roleList) {
//        if (roleList == null || roleList.size() == 0) {
//            return new ArrayList<>();
//        } else {
//            List<MenuNode> menus = menuService.getMenusByRoleIds(roleList);
//            List<MenuNode> titles = MenuNode.buildTitle(menus);
//            return ApiMenuFilter.build(titles);
//        }
//
//    }
//
//    /**
//     * 判断当前登录的用户是否有操作这个用户的权限
//     *
//     * @author fengshuonan
//     * @Date 2018/12/24 22:44
//     */
//    public void assertAuth(Long userId) {
//        if (ShiroKit.isAdmin()) {
//            return;
//        }
//        List<Long> deptDataScope = ShiroKit.getDeptDataScope();
//        User user = this.getById(userId);
//        Long deptId = user.getDeptId();
//        if (deptDataScope.contains(deptId)) {
//            return;
//        } else {
//            throw new ServiceException(BizExceptionEnum.NO_PERMITION);
//        }
//
//    }
//
//    /**
//     * 刷新当前登录用户的信息
//     *
//     * @author fengshuonan
//     * @Date 2019/1/19 5:59 PM
//     */
//    public void refreshCurrentUser() {
//        ShiroUser user = ShiroKit.getUserNotNull();
//        Long id = user.getId();
//        User currentUser = this.getById(id);
//        ShiroUser shiroUser = userAuthService.shiroUser(currentUser);
//        ShiroUser lastUser = ShiroKit.getUser();
//        BeanUtil.copyProperties(shiroUser, lastUser);
//    }

}
