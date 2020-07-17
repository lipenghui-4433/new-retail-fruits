package cn.dingdong.controller;

import cn.dingdong.dto.CommonResponse;
import cn.dingdong.dto.ResponseCode;
import cn.dingdong.model.Goods;
import cn.dingdong.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @RequestMapping("/list")
    public CommonResponse list(){
        CommonResponse commonResponse = new CommonResponse();
        try {
            Map<String, Object> map = new HashMap<>();
            //List<Goods> list = goodsService.list(map);
            //commonResponse.setData(list);
            return commonResponse;
        } catch (Exception e) {
            e.printStackTrace();
            commonResponse.setStatus(ResponseCode.SERVER_EXCEPTION)
                    .setMsg("操作失败");
            return commonResponse;
        }

    }

    @RequestMapping("/add")
    public CommonResponse addGoods(Goods goods){
        CommonResponse commonResponse = new CommonResponse();
        try {
            boolean flag = goodsService.addProduct(goods);
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
    public CommonResponse updateGoods(Goods goods){
        CommonResponse commonResponse = new CommonResponse();
        boolean flag = goodsService.updateProduct(goods);
        if (flag) {
            return commonResponse;
        } else {
            commonResponse.setStatus(ResponseCode.SERVER_EXCEPTION)
                    .setMsg("操作失败");
            return commonResponse;
        }
    }

    @RequestMapping("/delete")
    public CommonResponse deleteGoods(String id){
        CommonResponse commonResponse = new CommonResponse();
        if("".equals(id)||id==null){
            return commonResponse.setStatus(ResponseCode.SERVER_EXCEPTION)
                    .setMsg("参数异常");
        }
        boolean flag = goodsService.deleteProduct(id);
        if (flag) {
            return commonResponse;
        } else {
            commonResponse.setStatus(ResponseCode.SERVER_EXCEPTION)
                    .setMsg("操作失败");
            return commonResponse;
        }
    }
}
