package com.oracle.vo;

import java.sql.Date;

public class SendMessage {
     int sendID;
     Integer empID;
     String messageTitle;
     String messageContent;
     Date greatDate;
     Integer priority;
     Integer messageState=1;
	public int getSendID() {
		return sendID;
	}
	public void setSendID(int sendID) {
		this.sendID = sendID;
	}
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public String getMessageTitle() {
		return messageTitle;
	}
	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public Date getGreatDate() {
		return greatDate;
	}
	public void setGreatDate(Date greatDate) {
		this.greatDate = greatDate;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public int getMessageState() {
		return messageState;
	}
	public void setMessageState(int messageState) {
		this.messageState = messageState;
	}
	@Override
	public String toString() {
		return "SendMessage [sendID=" + sendID + ", empID=" + empID + ", messageTitle=" + messageTitle
				+ ", messageContent=" + messageContent + ", greatDate=" + greatDate + ", priority=" + priority
				+ ", messageState=" + messageState + "]";
	}
     
}
