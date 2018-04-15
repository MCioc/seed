package com.oracle.dao;

import java.lang.reflect.Array;
import java.sql.Date;
import java.util.List;

import com.oracle.jdbc.util.Dao;
import com.oracle.jdbc.util.Transactional;
import com.oracle.vo.SendMessage;

public class MessageDaoImpl implements MessageDao {

	@Override
	@Transactional
	public void send(SendMessage message,Integer[] empIDs) {
		//生成发送信息的主键
		SendMessage m=Dao.queryOne("select max(sendID)+1 sendID from to_sendmessage",SendMessage.class);
		System.out.println(m.getSendID());
		
		//向发送信息表中加记录
	    Dao.executeSql("INSERT INTO `to_sendmessage` (`sendID`, `EmpID`, `MessageTitle`, `MessageContent`, `CreateDate`, `priority`, `MessageState`) VALUES (?, ?, ?, ?, now(), ?, 1)",m.getSendID(),message.getEmpID(),message.getMessageTitle(),message.getMessageContent(),message.getPriority());
	    //向接受信息表中加记录
	    for(Integer i:empIDs){
	     Dao.executeSql("INSERT INTO `to_receivemessage` (`ReceiveID`, `sendID`, `EmpID`, `MessageState`) VALUES (null, ?, ?, 1)", m.getSendID(),i);
	    }
    }

	@Override
	@Transactional
	public List<Object[]> getReceiveMessage(Integer empID) {
		List<Object[]> list=Dao.query("select receiveID,e.empName empName,messageTitle,r.messageState messageState,r.openDate,case WHEN r.MessageState=1 THEN '未读' WHEN r.MessageState=2 THEN '已读' end state from to_receivemessage r left join to_sendmessage s on r.sendID=s.sendID left join tb_emp e on e.empID=s.empID where r.empID=? and r.messagestate!=3", empID);
		return list;
	}

	@Override
	public List<Object[]> getSendMessage(Integer empID) {
		List<Object[]> list=Dao.query("select sendID,messageTitle,createDate,'' empName from to_sendmessage where empID=? and messageState!=2 order by createDate desc", empID);
		 
		for(Object[] obj:list){
			List<Object[]> names=Dao.query("select empName from tb_emp where empID in (select empID from to_receivemessage where sendID=?)", obj[0]);
		    StringBuffer sb=new StringBuffer(); 
			for(int i=0;i<names.size();i++){
				if(i==names.size()-1){
					sb.append(names.get(i)[0]);
				}else{
					sb.append(names.get(i)[0]).append(",");
				}	
		    }
			obj[3]=sb.toString();
			System.out.println(sb.toString());
		}		
		return list;
	}
}
