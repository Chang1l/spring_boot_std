package kr.co.three.dept;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="dept")
public class Dept {

	@Id
	@Column(name="DEPTNO")
	private int deptno;

	@Column(length = 200)
	private String deptnm;
	
	@Column(length = 50)
	private String loc;
}
