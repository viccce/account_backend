package com.example.backend.user.service.impl;

import com.example.backend.user.dao.UserDao;
import com.example.backend.user.service.UserService;
import com.example.backend.user.vo.UserVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public UserVo login(UserVo user) {
        UserVo result = this.doDetail(user);
        if (result != null && user.getPassword() != null && user.getPassword().equals(result.getPassword())) {
            return result;
        } else {
            return null;
        }
    }

    @Override
    public List<UserVo> findList(UserVo user) {
        return userDao.findList(user);
    }

    @Override
    public UserVo doDetail(UserVo user) {
        return userDao.doDetail(user);
    }

    @Override
    public void save(UserVo user) {
        if (user.getActionType() != null && "update".equals(user.getActionType())) {
            this.doUpdate(user);
        } else {
            this.doCreate(user);
        }
    }

    @Override
    public void doDelete(UserVo user) {

    }

    private void doCreate(UserVo user) {
        userDao.create(user);
    }

    private void doUpdate(UserVo user) {
        userDao.update(user);
    }
}
