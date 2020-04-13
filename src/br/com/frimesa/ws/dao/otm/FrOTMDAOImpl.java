package br.com.frimesa.ws.dao.otm;


import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;


import br.com.frimesa.ws.dao.GenericDAOImpl;
import br.com.frimesa.ws.domain.TransmissionAck;
import br.com.frimesa.ws.exceptions.DAOException;
import br.com.frimesa.ws.exceptions.ErrorCode;
import br.com.frimesa.ws.util.Util;


public class FrOTMDAOImpl extends GenericDAOImpl implements FrOTMDAO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7524091699822161676L;

	@Override
	public TransmissionAck inserirXML(String xml,String tipo){
		// TODO Auto-generated method stub
		CallableStatement sqlStatement = null;
		String SQLRETTEXT = "{call fr_otm_interface_xml_pkg.inserirXML(?,?,?,?,?)}";    
		
		
		Integer             errorCode = null;
		Integer             idInterfaceId = null;
		String              errorString = null;
		try{
			sqlStatement =  conn.prepareCall(SQLRETTEXT);
			sqlStatement.registerOutParameter(1, Types.VARCHAR);
			sqlStatement.registerOutParameter(2, Types.INTEGER);
			sqlStatement.setString(3, xml);
			sqlStatement.setString(4, tipo);
			sqlStatement.registerOutParameter(5, Types.INTEGER);
			sqlStatement.executeUpdate();
			
			errorString 	= sqlStatement.getString(1);
			errorCode 	= sqlStatement.getInt(2);
			idInterfaceId = sqlStatement.getInt(5);
			if (errorCode!=null) {
	        	if (errorCode.equals(2)) {
	        		conn.rollback();
	        		throw new DAOException("Erro ao inseir xml classe "+FrOTMDAOImpl.class.getSimpleName()+". Procedure fr_otm_integration_pkg.inserirXML. Error: "+errorString , ErrorCode.SERVER_ERROR.getCode());
	        	}
        	}
			conn.commit();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao inserir o xml OTM: "+e.getMessage());
			
			throw new DAOException("Erro ao inserir o xml OTM: "+e.getMessage(), ErrorCode.SERVER_ERROR.getCode());
		}finally{
			try {
				if (!sqlStatement.isClosed())
					sqlStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try{
				if(!conn.isClosed())
				conn.close();
			}catch(Exception e){
			}
			
		}
		return Util.montaRetorno(Util.SUCESSO,"Processado com Sucesso. Id da interface: "+idInterfaceId);
	}
	
	

}
