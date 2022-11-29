package kr.co.security;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

	
	//추가코드
	@Query(value = "SELECT * FROM User WHERE user_id =?1",nativeQuery = true)
	DataBaseVo findByUserId(@Param("userId") String userId) {
		System.out.println("777");
		DataBaseVo vo =dao.findByUserId(userId);
		return vo;
	}

	@Query(value = "SELECT * FROM User ORDER BY idx DESC",nativeQuery = true)
	public List<DataBaseVo> list(){
		return dao.findAll();
	}
	
	public static final String INSERT_USER= "INSERT INTO User(auth, name, password, user_id) "
			+"VALUES (:#{#user.auth},  :#{#user.name}, :#{#user.password}, :#{#user.user_id} )";


	@Transactional
	@Modifying
	@Query(value=INSERT_USER, nativeQuery = true)
	public boolean insertUser(@Param("user") DataBaseVo vo) {//사용자 가입 메소드
			vo= dao.save(vo);
			System.out.println("vo.getIdx():"+vo.getIdx());
			if(vo.getIdx() ==null || vo.getIdx()<=0) return false;
			return true;
	}
}
