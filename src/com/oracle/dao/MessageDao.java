package com.oracle.dao;

import java.util.List;

import com.oracle.vo.SendMessage;

public interface MessageDao {
      public void send(SendMessage message,Integer[] empIDs);
      public List<Object[]> getReceiveMessage(Integer empID);
      public List<Object[]> getSendMessage(Integer empID);
}
