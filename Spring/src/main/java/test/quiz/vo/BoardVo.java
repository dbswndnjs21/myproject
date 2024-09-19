package test.quiz.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BoardVo {
	private int num;
	private String writer;
	private String title;
	private String content;
	private Date regdate;

}
