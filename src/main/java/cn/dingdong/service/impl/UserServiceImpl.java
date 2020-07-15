package cn.dingdong.service.impl;

import cn.dingdong.mapper.UserMapper;
import cn.dingdong.model.User;
import cn.dingdong.repository.UserRepository;
import cn.dingdong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired(required=false)
    private UserMapper userMapper;

    @Autowired
    private UserRepository  userRepository;

    @Override
    public boolean add(User user) {
        try {
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateUser(User user) {
        try {
            userRepository.saveAndFlush(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteUser(Integer id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public List<User> list(Map<String, Object> ma) {
        List<User> all = userRepository.findAll();
        return all;
    }
}
