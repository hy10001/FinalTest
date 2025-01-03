package cn.lanqiao.finalTest.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class managementException extends RuntimeException{
    private Integer code;
    public managementException(com.heyutongadmin.common.ResultCodeEnum resultCodeEnum){
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }
}
