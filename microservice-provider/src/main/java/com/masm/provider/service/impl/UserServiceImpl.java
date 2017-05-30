package com.masm.provider.service.impl;

import com.masm.provider.dao.UserMapper;
import com.masm.provider.entity.User;
import com.masm.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by simple on 2017/5/29.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findById(int id) {
        return userMapper.findById(id);
    }
}
