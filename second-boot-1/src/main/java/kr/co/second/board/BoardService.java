package kr.co.second.board;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardService  extends JpaRepository<Board, Integer>{
List<Board> findByTitleLikeOrWriterLike(String title, String writer);
	
}
