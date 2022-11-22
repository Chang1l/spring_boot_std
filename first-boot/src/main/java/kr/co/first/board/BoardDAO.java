package kr.co.first.board;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class BoardDAO {
   
   private final JdbcTemplate jdbcTemplate;
   private final String INSETSQL = "INSERT INTO BOARD (TITLE, WRITER, CONTENT, REG_DATE) VALUES (?,?,?, NOW())";
   private final String SELECTLISTSQL = "SELECT BOARD_NO, TITLE, CONTENT, WRITER, REG_DATE FROM BOARD WHERE BOARD_NO > 0 ORDER BY BOARD_NO DESC";
   private final String SELECTONESQL = "SELECT BOARD_NO, TITLE, CONTENT, WRITER, REG_DATE FROM BOARD WHERE BOARD_NO =?";
   private final String UPDATESQL = "UPDATE BOARD SET TITLE = ?, CONTENT = ?, WRITER = ? WHERE BOARD_NO = ?";
   private final String DELETESQL = "DELETE FROM BOARD WHERE BOARD_NO = ?";
   public void create(Board board) throws Exception {
//      jdbcTemplate.update(new PreparedStatementCreator() {
//         @Override
//         public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//            PreparedStatement ps = con.prepareStatement(INSETSQL);
//            ps.setString(1, board.getTitle());
//            ps.setString(2, board.getWriter());
//            ps.setString(3, board.getContent());
//            return ps;
//         }
//      });
      jdbcTemplate.update(INSETSQL, board.getTitle(), board.getWriter(), board.getContent());
   }
   public List<Board> list(){
      List<Board> results = jdbcTemplate.query(SELECTLISTSQL, new BoardMapper());
      return results;
   }
   
   public Board read(int boardNo) {
      List<Board> results = jdbcTemplate.query(SELECTONESQL, new BoardMapper(),boardNo);
      return results.isEmpty() ? null : results.get(0);
   }
   public void update(Board board) {
      jdbcTemplate.update(UPDATESQL, board.getTitle(), board.getContent(), board.getWriter(),board.getBoard_no());
      
   }
   public void delete(int boardNo) {
      jdbcTemplate.update(DELETESQL, boardNo);
      
   }
}

class BoardMapper implements RowMapper<Board>{

   @Override
   public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
      Board board = new Board();
      board.setBoard_no(rs.getInt("BOARD_NO"));
      board.setContent(rs.getString("CONTENT"));
      board.setTitle(rs.getString("TITLE"));
      board.setWriter(rs.getString("WRITER"));
      Timestamp timestamp = rs.getTimestamp("REG_DATE");
      board.setReg_date(timestamp.toLocalDateTime());
      return board;
   }
   
   
}