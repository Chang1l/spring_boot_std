package kr.co.first;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import kr.co.first.board.Board;

@SpringBootTest  //유닛(단위)테스트
class FirstBootApplicationTests {
	
	
	@Test //단위마다 메인처럼 작동
	void contextLoads() {
		Board b =new Board();
		b.setBoard_no(0);
		b.setTitle("0번글");
		b.setContent("0번내용");
		System.out.println(b.toString());
	}

}
