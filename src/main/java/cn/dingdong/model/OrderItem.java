package cn.dingdong.model;

import lombok.Data;

@Data
public class OrderItem {
    private String itemid; //id
    private int quantity; //数量
    private double total; //小计


    //1_对象对应对象
    //2_product,order携带更多的数据
    private Goods goods;
    private Order order;

}
