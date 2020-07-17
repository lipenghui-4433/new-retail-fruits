package cn.dingdong.model;

import lombok.Data;

@Data
public class ResultMapModel {
    private String attribute ; //entity中属性的名称

    private String column;  //表中的类名

    private String columType;  //jdbctype类型

    private int level;
}
