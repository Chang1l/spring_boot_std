package kr.co.three.dept;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DeptService  extends JpaRepository<Member, String>{

	@Query(value="SELECT m.* , d.* from member m JOIN dept d ON (d.deptno= m.deptno) ORDER BY m.deptno",nativeQuery = true)
	List<Member> findByMember();
}
