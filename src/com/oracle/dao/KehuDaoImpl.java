package com.oracle.dao;

import java.sql.Date;
import java.util.List;

import com.oracle.jdbc.util.Dao;
import com.oracle.jdbc.util.Transactional;
import com.oracle.vo.Kehu;
import com.oracle.vo.PageInfo;

public class KehuDaoImpl implements KehuDao {

	@Override
	@Transactional
	public List<Kehu> getAll() {
		List<Kehu> list=Dao.query("select * from tb_company order by CompanyID",Kehu.class);
		System.out.println(list);
		return list;
	}

	@Override
	@Transactional
	public void getAll(PageInfo pageinfo) {
		Object[] obj=Dao.queryOne("select count(*) from tb_company");
		int count=((Long)obj[0]).intValue();
		pageinfo.setCountRecord(count);
		
		List<Kehu> list=Dao.query("select * from tb_company order by CompanyID limit ?,?",Kehu.class,(pageinfo.getCurrentPage()-1)*pageinfo.getPageSize(),pageinfo.getPageSize());
		System.out.println(list);
		pageinfo.setList(list);
	}
	@Override
	@Transactional
	public void add(Kehu company) {
		Dao.executeSql("insert into tb_company values(null,?,?,?,?,?,?)", company.getCompanyName(),company.getLinkMan(),company.getTel(),company.getAddress(),new Date(System.currentTimeMillis()),company.getDescript());

	}

	@Override
	@Transactional
	public void delect(Integer[] companyID) {
		String sql="delete from tb_company where CompanyID in (";
		String sql1=")";
		for(int i=0;i<companyID.length-1;i++){
			sql+="?,";
		}
		sql1="?"+sql1;
		sql+=sql1;
		System.out.println(sql);
		Dao.execute(sql, companyID);
	}

	@Override
	@Transactional
	public void update(Kehu company) {
		Dao.executeSql("update tb_company set CompanyName=?,LinkMan=?,Tel=?,Address=?,CreateDate=?,Descript=?",company.getCompanyName(),company.getLinkMan(),company.getTel(),company.getAddress(),new Date(System.currentTimeMillis()),company.getDescript() );

	}

	@Override
	@Transactional
	public Kehu select(Integer companyID) {
		Kehu company=Dao.queryOne("select *from tb_company where CompanyID=?", Kehu.class, companyID);
		System.out.println(company);
		return company;
	}

}
