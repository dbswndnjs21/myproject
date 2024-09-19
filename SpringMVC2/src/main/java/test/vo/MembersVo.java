package test.vo;

import java.sql.Date;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MembersVo {
   private int num;
   private String name;
   private String phone;
   private String addr;
   private Date regdate;
}
