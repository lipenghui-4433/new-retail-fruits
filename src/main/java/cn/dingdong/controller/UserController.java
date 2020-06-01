package cn.dingdong.controller;

import cn.dingdong.constant.ResponseStatusEnum;
import cn.dingdong.dto.ResponseDTO;
import cn.dingdong.model.User;
import cn.dingdong.repository.UserRepository;
import cn.dingdong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/save")
    public ResponseDTO saveUser(){
        User user = new User();
        user.setName("qiangde");
        userRepository.save(user);
        return new ResponseDTO(ResponseStatusEnum.SUCCESS.getCode(),ResponseStatusEnum.SUCCESS.getMsg());
    }
}
