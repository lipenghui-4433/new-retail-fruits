package cn.dingdong.controller;

import cn.dingdong.constant.ResponseStatusEnum;
import cn.dingdong.dto.ResponseDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping("/save")
    public ResponseDTO saveUser(){

        return new ResponseDTO(ResponseStatusEnum.SUCCESS.getCode(),ResponseStatusEnum.SUCCESS.getMsg());
    }
}
