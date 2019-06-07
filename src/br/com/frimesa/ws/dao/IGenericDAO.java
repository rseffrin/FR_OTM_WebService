package br.com.frimesa.ws.dao;

import java.io.Serializable;
import java.sql.Connection;

public interface IGenericDAO extends Serializable{
	
	
	public void setConnection(Connection conn);
	public void setMax(long max);
	
	public void close();
	public void commit();
	public void rollback();

}
