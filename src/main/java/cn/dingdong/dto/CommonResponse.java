package cn.dingdong.dto;


public class CommonResponse<T> {
    private Integer status = ResponseCode.SUCCESS;
    private String msg = "操作成功!";
    private T data;
    private Object params;

    public CommonResponse() {
    }

    public CommonResponse(Integer status, T data, String msg) {
        this.status = status;
        this.data = data;
        this.msg = msg;
    }

    public static <T> CommonResponse<T> success(T data){
        CommonResponse<T> response = new CommonResponse<>();
        response.setData(data);
        return response;
    }

    public static CommonResponse<String> success(){
        return new CommonResponse<>();
    }

    public static <T> CommonResponse<T> failed(String message){
        CommonResponse<T> response = new CommonResponse<>();
        response.setStatus(ResponseCode.SERVER_EXCEPTION);
        response.setMsg(message);
        return response;
    }

    public static <T> CommonResponse<T> failed(Integer status,String message){
        CommonResponse<T> response = new CommonResponse<>();
        response.setStatus(status);
        response.setMsg(message);
        return response;
    }

    public Integer getStatus() {
        return status;
    }

    public CommonResponse setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Object getData() {
        return data;
    }

    public CommonResponse setData(T data) {
        this.data = data;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public CommonResponse setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getParams() {
        return params;
    }

    public CommonResponse setParams(Object params) {
        this.params = params;
        return this;
    }
}
