package test.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MembersVo {
   private int num;
   private String name;
   private String phone;
   private String addr;
   private Date regdate;
}
