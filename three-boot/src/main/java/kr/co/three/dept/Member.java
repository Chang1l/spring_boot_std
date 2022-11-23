package kr.co.three.dept;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="member")
public class Member {
	 @Id
	 @Column(length=200)
	 private String uid;
 
	@Column(length = 200)
	private String unm;
	
	private int uage;
	
	private int deptno;
	
	@ManyToOne
	@JoinColumn(name="DEPTNO",insertable = false, updatable = false)
	private Dept dept;
}
