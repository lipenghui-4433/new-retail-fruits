package cn.dingdong.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)//主键生成策略
    @Column(name="id")
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="age")
    private Integer age;

}
