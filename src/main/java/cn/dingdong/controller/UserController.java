package cn.dingdong.controller;

import cn.dingdong.dto.CommonResponse;
import cn.dingdong.dto.ResponseCode;
import cn.dingdong.model.User;
import cn.dingdong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/list")
    public CommonResponse list(){
        CommonResponse commonResponse = new CommonResponse();
        try {
            Map<String, Object> map = new HashMap<>();
            List<User> list = userService.list(map);
            commonResponse.setData(list);
            return commonResponse;
        } catch (Exception e) {
            e.printStackTrace();
            commonResponse.setStatus(ResponseCode.SERVER_EXCEPTION)
                    .setMsg("操作失败");
            return commonResponse;
        }

    }

    @RequestMapping("/add")
    public CommonResponse addUser(User user){
        CommonResponse commonResponse = new CommonResponse();
        try {
            boolean flag = userService.add(user);
            if (flag) {
                return commonResponse;
            } else {
                commonResponse.setStatus(ResponseCode.SERVER_EXCEPTION)
                        .setMsg("操作失败");
                return commonResponse;
            }
        } catch (Exception e) {
            e.printStackTrace();
            commonResponse.setStatus(ResponseCode.SERVER_EXCEPTION)
                    .setMsg(e.getMessage());
            return commonResponse;
        }
    }

    @RequestMapping("/update")
    public CommonResponse updateUser(User user){
        CommonResponse commonResponse = new CommonResponse();
        boolean flag = userService.updateUser(user);
        if (flag) {
            return commonResponse;
        } else {
            commonResponse.setStatus(ResponseCode.SERVER_EXCEPTION)
                    .setMsg("操作失败");
            return commonResponse;
        }
    }

    @RequestMapping("/delete")
    public CommonResponse deleteUser(String id){
        CommonResponse commonResponse = new CommonResponse();
        if("".equals(id)||id==null){
            return commonResponse.setStatus(ResponseCode.SERVER_EXCEPTION)
                    .setMsg("参数异常");
        }
        boolean flag = userService.deleteUser(Integer.valueOf(id));
        if (flag) {
            return commonResponse;
        } else {
            commonResponse.setStatus(ResponseCode.SERVER_EXCEPTION)
                    .setMsg("操作失败");
            return commonResponse;
        }
    }
}
