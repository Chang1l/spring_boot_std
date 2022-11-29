package kr.co.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.security.vo.DataBaseVo;

@Service
public class TestServiceImpl implements UserDetailsService {
	
	private final DBRepository dao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public TestServiceImpl(DBRepository dao) {
		this.dao=dao;
	}
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		//사용자를 찾습니다
		return null;
	}
	public boolean newMember(DataBaseVo vo) {
		//사용자 가입 메소드입니다
			
		vo.setPassword(passwordEncoder.encode(vo.getPassword()));
		System.out.println("password"+vo.getPassword());//암호화 할 비밀번호
		vo=dao.save(vo);
		
		if(vo.getIdx()==null || vo.getIdx().intValue()<=0) return false;
		return true;
	}

	
}
