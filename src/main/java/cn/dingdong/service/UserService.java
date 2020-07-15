package cn.dingdong.service;

import cn.dingdong.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    public boolean add(User user);

    public boolean updateUser(User user);

    public boolean deleteUser(Integer id);

    public List<User> list(Map<String,Object> ma);
}
