package cn.dingdong.model;

import lombok.Data;

import java.util.Date;

@Data
public class ShopCart {

    private Long id;

    private String title;

    private String sellPoint;

    private Long ActivityPrice;  //活动价

    private Long price;  //原价

    private Integer num;//作为购物项购买的商品数量

    private String barcode;

    private String image;//展示购物项中的图片

    private Long goodId;

    private Byte status;

    private Date created;

    private Date updated;
}
