package br.com.frimesa.ws.dao;

import java.sql.Connection;
import br.com.frimesa.ws.exceptions.DAOException;
import br.com.frimesa.ws.exceptions.ErrorCode;



public class DAOFactory {
	
	public IGenericDAO createDAO(@SuppressWarnings("rawtypes") Class clazz,Connection conn){
		
		String clz=clazz.getPackage().getName()+"."+clazz.getSimpleName()+"Impl";
		try{
			return getFromMap(clz,conn);
		}catch(Exception e){
			e.printStackTrace();
			throw new DAOException("Não foi possível criar o DAO. "+e.getMessage(),ErrorCode.SERVER_ERROR.getCode());
		}
	}
	
	private IGenericDAO getFromMap(String cl,Connection conn)throws Exception{
		IGenericDAO obj=null;//clazz.get(cl);
		if(obj==null){
			obj=(IGenericDAO)Class.forName(cl).newInstance();
			//clazz.put(cl, obj);
			obj.setConnection(conn);
		}
		return obj; 
	}

}
