package cn.lanqiao.finalTest.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
  private long employeeId;
  private String employeeName;
  private String employeeCode;
  private String department;
  private String position;
  private String phoneNumber;
  private String hireDate;
  private String status;

}
