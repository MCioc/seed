package com.oracle.vo;

import java.sql.Date;

public class Emp {
      int EmpID;
      String EmpNO;
      String password;
      String EmpName;
      String sex;
      Date brith;
	public int getEmpID() {
		return EmpID;
	}
	public void setEmpID(int empID) {
		EmpID = empID;
	}
	public String getEmpNO() {
		return EmpNO;
	}
	public void setEmpNO(String empNO) {
		EmpNO = empNO;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmpName() {
		return EmpName;
	}
	public void setEmpName(String empName) {
		EmpName = empName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBrith() {
		return brith;
	}
	public void setBrith(Date brith) {
		this.brith = brith;
	}
	@Override
	public String toString() {
		return "Emp [EmpID=" + EmpID + ", EmpNO=" + EmpNO + ", password=" + password + ", EmpName=" + EmpName + ", sex="
				+ sex + ", brith=" + brith + "]";
	}
    
       
}
