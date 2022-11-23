package kr.co.three.board;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardService extends JpaRepository<Board, Integer> {

   public static final String INSERT_BOARD = "INSERT INTO BOARD ( CONTENT, TITLE, WRITER, REG_DATE ) "
         + "VALUES ( :#{#board.content}, :#{#board.title}, :#{#board.writer}, " + ":#{#board.regDate} )";

   @Transactional
   @Modifying
   @Query(value = INSERT_BOARD, nativeQuery = true)
   int insertBoard(@Param("board") Board board);

   @Query(value = "SELECT * FROM BOARD ORDER BY BOARD_NO DESC", nativeQuery = true)
   List<Board> findByBoard();

   @Query(value = "SELECT * FROM BOARD WHERE BOARD_NO = ?1", nativeQuery = true)
   Board findByBoard_no(int boardNo);

   @Query(value = "SELECT * FROM BOARD WHERE TITLE LIKE ?1 OR WRITER LIKE ?2", nativeQuery = true)
   List<Board> findByTitleOrWriter(String title, String writer);
            
   public static final String UPDATE_BOARD = "UPDATE BOARD SET CONTENT = :#{#board.content} "
         + ", TITLE = :#{#board.title}, WRITER = :#{#board.writer} WHERE BOARD_NO = :#{#board.boardNo} ";

   @Transactional
   @Modifying
   @Query(value = UPDATE_BOARD, nativeQuery = true)
   int updateBoard(@Param("board") Board board);

   public static final String DELETE_BOARD = "DELETE FROM BOARD WHERE BOARD_NO = :boardNo";

   @Transactional
   @Modifying
   @Query(value = DELETE_BOARD, nativeQuery = true)
   int deleteBoard(@Param("boardNo") int boardNo);

}