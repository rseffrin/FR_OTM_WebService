package br.com.frimesa.ws.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import br.com.frimesa.ws.dao.otm.FrOTMDAO;
import br.com.frimesa.ws.exceptions.DAOException;
import br.com.frimesa.ws.exceptions.ErrorCode;
import br.com.frimesa.ws.util.Util;



public class DBConnection {
	
	private static DAOFactory daoFactory=new DAOFactory();
	private static long numDbConnection=0;
	private static String DB;
	
//	static{
//		try{
//			//javax.naming.Context ctx = new javax.naming.InitialContext();
//			//DB=(String)ctx.lookup("java:comp/env/DATABASE_PADRAO");
//			//System.out.println("###### Database Padrão: "+DB);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//	}
	

	
	public static Connection getConnection()throws Exception{
		return getConnection("DATABASE_PADRAO");
	}

	public static Connection getConnection(String database)throws Exception{
		Util.debug("DBConnection.getConnection(+)");
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		
		javax.naming.Context ctx = new javax.naming.InitialContext();
		DB=(String)ctx.lookup("java:comp/env/DATABASE_PADRAO");
		//System.out.println("###### Database Padrão: "+DB);

		DataSource ds = (DataSource)envCtx.lookup(DB);
		Connection conn=ds.getConnection();
		conn.setAutoCommit(false);
		if(!conn.isValid(10)){
			try{
				conn.close();
			}catch(Exception e){
				
			}
			throw new DAOException("Conexão com o banco não é mais válida.", ErrorCode.SERVER_ERROR.getCode());
		}
		numDbConnection++;
		
	//	setaOrg(conn);
		
		Util.debug("DBConnection.getConnection(-) numDbConnection="+numDbConnection+" Conn="+conn);
		return conn;
	}
	
	public static Connection getConnectionWithDetail(long userId)throws Exception{
		Util.debug("DBConnection.getConnection(+)");
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup(DB);
		Connection conn=ds.getConnection();
		conn.setAutoCommit(false);
		if(!conn.isValid(10)){
			try{
				conn.close();
			}catch(Exception e){
			}
			throw new DAOException("Conexão com o banco não é mais válida.", ErrorCode.SERVER_ERROR.getCode());
		}
		numDbConnection++;
		// user id enviado pelo aplicativo // id da responsabilidade 54633 EAM self service // 426 application id 
		setaOrgDetalhe(conn, userId, 54633, 426);
		Util.debug("DBConnection.getConnection(-) numDbConnection="+numDbConnection+" Conn="+conn);
		return conn;
	}

	public static FrOTMDAO createOTMDAO(){
		try{
			return (FrOTMDAO) daoFactory.createDAO(FrOTMDAO.class,getConnection());
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	public static void setaOrgDetalhe(Connection conn, long userId, long respId, long applicationId) throws Exception {
		try{
			PreparedStatement ps=conn.prepareStatement("{call fnd_global.apps_initialize("+userId+","+respId+","+applicationId+",0) }");
			ps.execute();
			ps.close();

			ps=conn.prepareStatement("{call fnd_client_info.setup_client_info(1, "+respId+", "+userId+", 0) }");
			ps.execute();
			ps.close();

			ps=conn.prepareStatement("{call mo_global.init('AR') }");
			ps.execute();
			ps.close();
			
			ps=conn.prepareStatement("{call mo_global.init('ONT') }");
			ps.execute();
			ps.close();

			ps=conn.prepareStatement("{call ARP_GLOBAL.init_global }");
			ps.execute();
			ps.close();
			
			ps=conn.prepareStatement("{call DBMS_SESSION.SET_IDENTIFIER('WEBSERVICES') }");
			ps.execute();
			ps.close();

			Statement stmnt = conn.createStatement();

			stmnt.execute("alter session set NLS_NUMERIC_CHARACTERS = '.,' ");
			stmnt.execute("alter session set NLS_DATE_LANGUAGE='PORTUGUESE'");
			stmnt.execute("ALTER SESSION SET NLS_DATE_FORMAT = 'DD-MON-YYYY HH24:MI:SS'");
			stmnt.close();

		}catch (Exception e){
			throw e;
		}
	}
	
	private static void setaOrg(Connection conn) throws Exception {
		try{	 
			PreparedStatement ps=conn.prepareStatement("{call fnd_global.apps_initialize(-1,51750,20111,0) }");
			ps.execute();
			ps.close();

			ps=conn.prepareStatement("{call fnd_client_info.setup_client_info(1, 51750, -1, 0) }");
			ps.execute();
			ps.close();

			ps=conn.prepareStatement("{call mo_global.init('AR') }");
			ps.execute();
			ps.close();
			
			ps=conn.prepareStatement("{call mo_global.init('ONT') }");
			ps.execute();
			ps.close();

			ps=conn.prepareStatement("{call ARP_GLOBAL.init_global }");
			ps.execute();
			ps.close();
			
			ps=conn.prepareStatement("{call DBMS_SESSION.SET_IDENTIFIER('WEBSERVICES') }");
			ps.execute();
			ps.close();

			Statement stmnt = conn.createStatement();

			stmnt.execute("alter session set NLS_NUMERIC_CHARACTERS = '.,' ");
			stmnt.execute("alter session set NLS_DATE_LANGUAGE='PORTUGUESE'");
			stmnt.execute("ALTER SESSION SET NLS_DATE_FORMAT = 'DD-MON-YYYY HH24:MI:SS'");
			stmnt.close();

			//System.out.println("Setando Organização");

		}catch (Exception e){
			throw e;
		}
	}



	
	

}
