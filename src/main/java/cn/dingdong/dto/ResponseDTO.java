package cn.dingdong.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by qudx1 on 2017/7/18.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO implements Serializable {
    private String code;
    private String message;
    private Object data;

    public ResponseDTO(String code, String message){
        this.code = code;
        this.message = message;
        this.data = null;
    }

    public ResponseDTO(String code, Object data){
        this.code = code;
        this.message = null;
        this.data = data;
    }

}
