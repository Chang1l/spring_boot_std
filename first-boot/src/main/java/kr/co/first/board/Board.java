package kr.co.first.board;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class Board {

	private int board_no;
	private String content;
	private LocalDateTime reg_date;
	private String title;
	private String writer;

}
