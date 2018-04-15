package com.oracle.dao;

import java.util.List;

import com.oracle.jdbc.util.Dao;
import com.oracle.jdbc.util.Transactional;
import com.oracle.vo.Emp;

public class EmpDaoImpl implements EmpDao {

	@Override
	@Transactional
	public void add(Emp user) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public void delete(Integer userNo) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public void update(Emp user) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public Emp select(String userName, String password) {
		//÷¥––≤È—Ø”Ôæ‰
	    Emp user=Dao.queryOne("select *from tb_emp where EmpName=? and Password=?",Emp.class,userName,password);
	    System.out.println(user);
        return user;
	}

	@Override
	@Transactional
	public List<Emp> getAll() {
		
		return Dao.query("select* from tb_emp order by empId", Emp.class);
	}

}
