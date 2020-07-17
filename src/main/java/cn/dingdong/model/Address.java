package cn.dingdong.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)//主键生成策略
    @Column(name="id")
    private Integer id;
    @Column(name="province")
    private String province;//省
    @Column(name="city")
    private String city;  //市
    @Column(name="area")
    private String area;  //区
    @Column(name="street")
    private String street;  //街道
    @Column(name="phone")
    private String phone;  //联系电话
    @Column(name="contacts")
    private String contacts;  //联系人
    @Column(name="ags1")
    private String ags1;  //备选字段
    @Column(name="ags2")
    private String ags2;  //备选字段
    @Column(name="uesrId")
    private Date uesrId;  //用户id



}
