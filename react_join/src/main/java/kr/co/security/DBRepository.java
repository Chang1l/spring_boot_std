package kr.co.security;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import kr.co.security.vo.DataBaseVo;

@Repository
public interface DBRepository extends JpaRepository<DataBaseVo, Long> {

	//userId 컬럼에 조건을 주고 조회합니다
	public DataBaseVo findByUserId(@Param("userId")String userId);
}
