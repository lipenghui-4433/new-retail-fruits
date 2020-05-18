package cn.dingdong.service.impl;

import cn.dingdong.mapper.UserMapper;
import cn.dingdong.model.User;
import cn.dingdong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public void save(User user) {
        userMapper.save(user);
    }
}
