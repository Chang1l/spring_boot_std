package kr.co.first.board;

import java.util.List;

public interface BoardService {

	public void register(Board board) throws Exception;
	
	public List<Board> list() throws Exception;
	
	public Board read(int board_no) throws Exception;
	
	public void modify(Board board) throws Exception;
	
	public void remove(int board_no) throws Exception;
}
