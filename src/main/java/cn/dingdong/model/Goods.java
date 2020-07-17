package cn.dingdong.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "goods")
public class Goods {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)//主键生成策略
    @Column(name="id")
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="productName")
    private String productName;  //产品分类名称 1，休闲食品 2.生鲜水果 3，化妆美品
    @Column(name="productId")
    private String productId;  //产品id
    @Column(name="goodsType")
    private String goodsType;  //商品类型 1，零食 2.速食 3.酒类
    @Column(name="activityType")
    private String activityType;  //活动类型 1，普通商品 2.团购  3.秒杀（抢购）
    @Column(name="status")
    private String status;  //商品状态 1，上架 2.下架  3.待上架  4.待下架  5其他
    @Column(name="basePrice")
    private BigDecimal basePrice;  //原始价格
    @Column(name="activiPrice")
    private BigDecimal activiPrice;  //活动价格
    @Column(name="pellPrice")
    private BigDecimal pellPrice;  //团购价格
    @Column(name="killPrice")
    private BigDecimal killPrice;  //秒杀价格
    @Column(name="reservePrice")
    private BigDecimal reservePrice;  //备用价格
    @Column(name="fromHome")
    private String fromHome;  //产地
    @Column(name="specs")
    private String specs;  //规格
    @Column(name="tags")
    private String tags;  //标签  高品质新鲜水果、进口水果、时令水果
    @Column(name="packingType")
    private String packingType;  //包装类型  盒、箱、袋
    @Column(name="weight")
    private String weight;  //重量
    @Column(name="life")
    private String life;  //保质期  7天 14天  21天  28天
    @Column(name="putType")
    private String putType;  //储藏方式  常温、冷藏、冷冻
    @Column(name="details")
    private String details;  //商品详情
    @Column(name="remark")
    private String remark;  //备注
    @Column(name="ags1")
    private String ags1;  //备选字段
    @Column(name="ags2")
    private String ags2;  //备选字段
    @Column(name="ags3")
    private String ags3;  //备选字段
    @Column(name="createTime")
    private Date createTime;  //创建时间
    @Column(name="updateTime")
    private Date updateTime;  //更改时间
    @Column(name="createby")
    private String createby;  //创建人
    @Column(name="updateby")
    private String updateby;  //更改人



}
