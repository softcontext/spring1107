package com.example.demo.lombok.step1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * Equivalent to 
 * 	@Getter 
 * 	@Setter 
 * 	@RequiredArgsConstructor 
 * 	@ToString 
 * 	@EqualsAndHashCode
 */
@Data
//@EqualsAndHashCode
//@ToString
//@Getter
//@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
	private int empno;
	private String ename;
	private String job;
	
//	@Override
//	public String toString() {
//		return "{" + empno + "," + ename + "," + job + "}";
//	}
	
//	@Override
//	public boolean equals(Object obj) {
//		if (!(obj instanceof Emp)) {
//			throw new RuntimeException("use Emp instance");
//		}
//		Emp that = (Emp) obj;
//		if (this.empno == that.empno) {
//			return true;
//		}
//		return false;
//	}
}
