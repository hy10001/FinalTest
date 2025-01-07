package cn.lanqiao.finalTest.model.dto.admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminQuery {
    private String username;
    private String password;
    private boolean rememberMe;
    private String is_delete;
}
