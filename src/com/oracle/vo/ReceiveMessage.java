package com.oracle.vo;

import java.sql.Date;

public class ReceiveMessage {
     int receiveID;
     Integer sendID;
     Integer empID;
     Integer messageState;
     Date openDate;
	public int getReceiveID() {
		return receiveID;
	}
	public void setReceiveID(int receiveID) {
		this.receiveID = receiveID;
	}
	public Integer getSendID() {
		return sendID;
	}
	public void setSendID(Integer sendID) {
		this.sendID = sendID;
	}
	public Integer getEmpID() {
		return empID;
	}
	public void setEmpID(Integer empID) {
		this.empID = empID;
	}
	public Integer getMessageState() {
		return messageState;
	}
	public void setMessageState(Integer messageState) {
		this.messageState = messageState;
	}
	public Date getOpenDate() {
		return openDate;
	}
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	@Override
	public String toString() {
		return "ReceiveMessage [receiveID=" + receiveID + ", sendID=" + sendID + ", empID=" + empID + ", messageState="
				+ messageState + ", openDate=" + openDate + "]";
	}
     
}
