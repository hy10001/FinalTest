package cn.lanqiao.finalTest.model.dto.admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Register {
    private String username;
    private String password;
    private String phone;
    private String verifyCode;
}
