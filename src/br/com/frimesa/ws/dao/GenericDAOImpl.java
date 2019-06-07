package br.com.frimesa.ws.dao;

import java.sql.Connection;

import br.com.frimesa.ws.exceptions.DAOException;
import br.com.frimesa.ws.exceptions.ErrorCode;



public class GenericDAOImpl implements IGenericDAO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Connection conn;
	protected long max=400;

	@Override
	public void setConnection(Connection conn) {
		this.conn=conn;
	}
	public void setMax(long max){
		this.max=max;
	}
	
	@Override
	public void close(){
		if(conn!=null){
			try{
				conn.close();
			}catch(Exception e){
				conn=null;
			}
		}
	}
	
	public void commit(){
		try{
			conn.commit();
		}catch(Exception e){
			throw new DAOException("Não foi possível realizar commit: "+e.getMessage(), ErrorCode.SERVER_ERROR.getCode());
		}
	}
	public void rollback(){
		try{
			conn.rollback();
		}catch(Exception e){
			throw new DAOException("Não foi possível realizar commit: "+e.getMessage(), ErrorCode.SERVER_ERROR.getCode());
		}
	}
	


}
