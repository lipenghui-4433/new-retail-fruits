package cn.dingdong.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)//主键生成策略
    @Column(name="id")
    private Integer id;
    @Column(name="name") //用户名称
    private String name;
    @Column(name="wechatName")  //微信名称
    private String wechatName;
    @Column(name="wechatId")
    private String wechatId;//微信账号
    @Column(name="openId")
    private String openId; //openId
    @Column(name="sex")
    private String sex;
    @Column(name="phone")//电话
    private String phone;
    @Column(name="createby")
    private String createby;  //创建人
    @Column(name="updateTime")
    private Date updateTime;  //更改时间


}
