package test.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardVo {
   private int num;
   private String writer;
   private String title;
   private String content;
   private int hit;
   private Date regdate;
}
