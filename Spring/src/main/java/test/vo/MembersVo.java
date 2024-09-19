package test.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@NoArgsConstructor
@AllArgsConstructor
@Data // setter getter tostring까지 다만듬
public class MembersVo {
    private int num;
    private String name;
    private String phone;
    private String addr;
    private Date regdate;
}
