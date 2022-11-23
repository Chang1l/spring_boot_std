package kr.co.three.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.three.board.Board;
import kr.co.three.board.BoardService;
import lombok.RequiredArgsConstructor;

// @RequiredArgsConstructor => final 이 있을때 사용해야함 notnull
@RequiredArgsConstructor
@RestController
@RequestMapping("/boards")
public class BoardController {

   private final BoardService service;

   @PostMapping
   public String register(@Validated @RequestBody Board board) throws Exception {
      board.setRegDate(LocalDateTime.now());
      service.insertBoard(board);
      return "ok";
   }

   @GetMapping
   public List<Board> list() {
      List<Board> bl = service.findAll();
      for (Board b : bl) {
         System.out.println("b: " + b.toString());
      }
      return bl;
   }

   @GetMapping("/{boardNo}")
   public ResponseEntity<Board> read(@PathVariable("boardNo") int boardNo) throws Exception {
      Optional<Board> boardList = service.findById(boardNo);
      Board board = null;
      if (boardList.isPresent()) {
         board = boardList.get();
      }
      return new ResponseEntity<>(board, HttpStatus.OK);
   }

   @GetMapping("/search/{keyword}")
   public List<Board> search(@PathVariable("keyword") String keyword) throws Exception {
      keyword = "%" + keyword + "%";
      List<Board> board = service.findByTitleOrWriter(keyword, keyword);
      return board;
   }

   @PutMapping("/{boardNo}")
   public String modify(@Validated @RequestBody Board board,@PathVariable("boardNo") int boardNo) throws Exception {
	   board.setBoardNo(boardNo);
	   System.out.println(board.toString());
      int r = service.updateBoard(board);
      System.out.println(" 줄 수: " + r);
      return "ok";
   }

   @DeleteMapping("/{boardNo}")
   public String remove(@PathVariable("boardNo") int boardNo) throws Exception {
      int r = service.deleteBoard(boardNo);
      System.out.println("삭제된 줄 수: " + r);
      return "ok";
   }

}