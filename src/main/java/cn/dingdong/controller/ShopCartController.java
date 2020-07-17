package cn.dingdong.controller;

import cn.dingdong.model.ShopCart;
import cn.dingdong.service.GoodsService;
import cn.dingdong.service.ShopCartService;
import io.lettuce.core.RedisClient;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class ShopCartController {

    /*@Autowired
    private ShopCartService shopCartService;
    @Autowired
    private GoodsService goodsService;

    @Autowired
    private StringRedisTemplate redisTemplate;



    @RequestMapping("/add")
    public String addCart(@PathVariable String userId, @RequestParam(defaultValue = "1") Integer num,String goodsId) {
        try {
            // 从redis中取出购物车，判断是否已经有购物项
            Boolean hexists = redisTemplate.hasKey(*//*CART_REDIS_KEY_PRE +*//* ":" + userId + ""+ goodsId + "");
            if (hexists) {
                String hget = redisTemplate.get(*//*CART_REDIS_KEY_PRE +*//* ":" + userId + ""+ goodsId + "");
                // 将数量相加
                TbItem item = JsonUtils.jsonToPojo(hget, TbItem.class);
                item.setNum(item.getNum() + num);
                // 将商品重新放入购物车中
                jedisClient.hset(CART_REDIS_KEY_PRE + ":" + userId + "", itemId + "", JsonUtils.objectToJson(item));
                return E3Result.ok();
            }

            // 表示购物车中没有要添加的商品信息
            // 根据商品的id查询商品的信息
            TbItem item = goodsService.selectByPrimaryKey(itemId);
            item.setNum(num);
            if (StringUtils.isNotBlank(item.getImage())) {
                item.setImage(item.getImage().split(",")[0]);
            }
            // 将商品信息存入购物车中
            jedisClient.hset(CART_REDIS_KEY_PRE + ":" + userId + "", itemId + "", JsonUtils.objectToJson(item));
            return E3Result.ok();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "cartSuccess";

    }



    private List<ShopCart> getCartItemList(HttpServletRequest request) {
        // 使用utf-8，需要设置第三个参数为true
        String json = CookieUtils.getCookieValue(request, CART_COOKIE, true);
        if (StringUtils.isNotBlank(json)) {
            // 返回cookie中取出的数据集合
            return JsonUtils.jsonToList(json, TbItem.class);
        }
        // 返回空集合对象
        return new ArrayList<>();
    }



    @RequestMapping("/cart/cart")
    public String getCartList(HttpServletRequest request, HttpServletResponse response, Model model) {
        // 从cookie中取出商品信息，
        List<ShopCart> itemList = getCartItemList(request);
        // 将购物车信息返回给页面中
        model.addAttribute("cartList", itemList);
        // 跳转逻辑视图
        return "cart";
    }
    @RequestMapping("/delete")
    public String deleteCartItem(@PathVariable Long itemId, HttpServletRequest request, HttpServletResponse response) {
        List<ShopCart> list = getCartItemList(request);
        for (ShopCart item : list) {
            if (item.getId() == itemId.longValue()) {
                list.remove(item);
                break;
            }
        }
        // 删除成功后，将购物车列表写入cookie中
        CookieUtils.setCookie(request, response, CART_COOKIE, JsonUtils.objectToJson(list), EXPIRE_KEY, true);

        // 删除成功后，重定向到购物车列表页面
        return "redirect:/cart/cart.html";

    }

    *//**
     * 删除购物车
     *
     * @return
     *
     *//*
    public String deleteCartItem(Long id, Long itemId) {
        Long hdel = jedisClient.hdel(CART_REDIS_KEY_PRE + ":" + id + "", itemId + "");
        System.out.println("删除购物车购物项为"+hdel);
        return null;
    }


    *//**
     * 更新购物车中商品的数量
     *//*
    public String updateRedisNum(Long id, Long itemId, Integer num) {
        // 取出需要更改数量的商品信息
        String hget = jedisClient.hget(CART_REDIS_KEY_PRE + ":" + id + "", itemId + "");
        // 将取出的json数据转换为商品对象，然后更新数量
        TbItem item = JsonUtils.jsonToPojo(hget, TbItem.class);
        item.setNum(num);
        // 更新成功后，将数据写到redis购物车中
        jedisClient.hset(CART_REDIS_KEY_PRE + ":" + id + "", itemId + "", JsonUtils.objectToJson(item));
        return null;
    }
*/




}
