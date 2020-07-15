package cn.dingdong.dto;



public class ResponseCode {
    /**
     *接口成功
     */
    public static final int SUCCESS = 200;
    /**
     *未登录
     */
    public static final int UNLOGIN = 401;
    /**
     * 没有权限
     */
    public static final int NOAUTHORITY = 403;
    /**
     * 参数错误
     */
    public static final int INVALID_PARAM = 400;

    /**
     *服务异常
     */
    public static final int SERVER_EXCEPTION = 500;
}
