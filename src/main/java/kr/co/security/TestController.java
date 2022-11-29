package kr.co.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.security.vo.DataBaseVo;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/member")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8090"})
//포트가 서로 다른 사이트간의 데이터를 주고 받기 위한 어노테이션
public class TestController {
   
   private final TestService testService;
   
   @Autowired
   private PasswordEncoder passwordEncoder;
   
   @GetMapping("/{uid}")
   public ResponseEntity<DataBaseVo> read(@PathVariable("uid") String userId) throws Exception{
      DataBaseVo vo = testService.findByUserId(userId);
      System.out.println("vo: "+vo);
      return new ResponseEntity<>(vo, HttpStatus.OK);
   }
   @GetMapping("/list")
   public ResponseEntity<List<DataBaseVo>> list() throws Exception{
      return new ResponseEntity<>(testService.list(), HttpStatus.OK);
   }
   
   @PostMapping("/join")
   public String register(@Validated @RequestBody DataBaseVo vo) throws Exception{
      vo.setPassword(passwordEncoder.encode(vo.getPassword()));
      boolean res = testService.insertUser(vo);
      return res == true ? "ok" : "no";
   }
}
   
   