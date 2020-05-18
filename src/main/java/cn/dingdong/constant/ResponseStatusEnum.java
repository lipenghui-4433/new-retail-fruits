package cn.dingdong.constant;

/**
 * Created by qudx1 on 2017/7/18.
 */
public enum ResponseStatusEnum {

    SUCCESS("200","success"),
    FAILED("7100","暂无数据"),
    ERROR("7200","操作失败"),
    URLPERMISSIONDENY("201","no permission");


    ResponseStatusEnum(String code, String msg){
        this.code = code;
        this.msg = msg;
    }
    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
