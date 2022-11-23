package kr.co.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.co.security.vo.DataBaseVo;

@Service
public class TestService implements UserDetailsService{
	
	private final DBRepository dao;
	
	public TestService(DBRepository dao) {
		this.dao= dao;
	}
	
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		//사용자를 찾음
		DataBaseVo vo= dao.findByUserId(userId);
		return vo;
	}

	
}
