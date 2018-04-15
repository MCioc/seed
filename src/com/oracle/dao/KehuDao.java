package com.oracle.dao;

import java.util.List;

import com.oracle.vo.Kehu;
import com.oracle.vo.PageInfo;

public interface KehuDao {
	public List<Kehu> getAll();
	public void getAll(PageInfo pageinfo);
    public void add(Kehu company);
    public void delect(Integer[] companyID);
    public void update(Kehu company);
    public Kehu select(Integer companyID);
}
