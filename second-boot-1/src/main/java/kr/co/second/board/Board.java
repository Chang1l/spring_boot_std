package kr.co.second.board;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@Entity
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int boardNo;
	@Column(length = 200)
	private String content;
	@Column(columnDefinition = "Text" )
	private String title;
	@Column(length = 50)
	private String writer;
	
	private LocalDateTime regDate;
}
