package cn.dingdong.controller;

import cn.dingdong.constant.ResponseStatusEnum;
import cn.dingdong.dto.ResponseDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @RequestMapping("/save")
    public ResponseDTO saveUser(){

        return new ResponseDTO(ResponseStatusEnum.SUCCESS.getCode(),ResponseStatusEnum.SUCCESS.getMsg());
    }
}
