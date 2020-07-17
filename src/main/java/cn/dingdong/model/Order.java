package cn.dingdong.model;


import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Order {
    private String oid; //订单编号
    private Date ordertime; //下单时间
    private double total; //总计
    private int state; //状态
    private String address; //收货人地址
    private String name; //收货人姓名
    private String telephone; //收货人电话

    // private String uid;
    // 1_程序对象和对象发生关系,而不是对象和对象的属性发生关系
    // 2_设计Order目的:让order携带订单上的数据向service,dao传递,user对象是可以携带更多的数据
    private User user;

    // 程序中体现订单对象和订单项之间关系,我们再项目中的部分功能中有类似的需求:查询订单的同时还需要获取订单下所有的订单项
    private List<OrderItem> list = new ArrayList<OrderItem>();


}
