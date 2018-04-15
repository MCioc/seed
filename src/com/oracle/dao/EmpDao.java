package com.oracle.dao;

import java.util.List;

import com.oracle.vo.Emp;

public interface EmpDao {
	  public List<Emp> getAll();
      public void add(Emp user);
      public void delete(Integer userNo);
      public void update(Emp user);
      public Emp select(String userName,String password);
}
