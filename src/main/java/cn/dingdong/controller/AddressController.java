package cn.dingdong.controller;

import cn.dingdong.dto.CommonResponse;
import cn.dingdong.dto.ResponseCode;
import cn.dingdong.model.Address;
import cn.dingdong.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @RequestMapping("/list")
    public CommonResponse list(){
        CommonResponse commonResponse = new CommonResponse();
        try {
            Map<String, Object> map = new HashMap<>();
            List<Address> list = addressService.list(map);
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
    public CommonResponse addAddress(Address address){
        CommonResponse commonResponse = new CommonResponse();
        try {
            boolean flag = addressService.addAddress(address);
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
    public CommonResponse updateAddress(Address address){
        CommonResponse commonResponse = new CommonResponse();
        boolean flag = addressService.updateAddress(address);
        if (flag) {
            return commonResponse;
        } else {
            commonResponse.setStatus(ResponseCode.SERVER_EXCEPTION)
                    .setMsg("操作失败");
            return commonResponse;
        }
    }

    @RequestMapping("/delete")
    public CommonResponse deleteAddress(String id){
        CommonResponse commonResponse = new CommonResponse();
        if("".equals(id)||id==null){
            return commonResponse.setStatus(ResponseCode.SERVER_EXCEPTION)
                    .setMsg("参数异常");
        }
        boolean flag = addressService.deleteAddress(Integer.valueOf(id));
        if (flag) {
            return commonResponse;
        } else {
            commonResponse.setStatus(ResponseCode.SERVER_EXCEPTION)
                    .setMsg("操作失败");
            return commonResponse;
        }
    }

}
