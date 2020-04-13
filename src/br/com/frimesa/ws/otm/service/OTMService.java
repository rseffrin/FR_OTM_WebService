package br.com.frimesa.ws.otm.service;




import br.com.frimesa.ws.dao.DBConnection;
import br.com.frimesa.ws.dao.otm.FrOTMDAO;
import br.com.frimesa.ws.domain.TransmissionAck;
import br.com.frimesa.ws.util.Util;


public class OTMService {
	
	
	private FrOTMDAO otmDAO;
	
    public TransmissionAck inserir(String xml,String tipo){
    	Util.transmissionXML = xml;
    	otmDAO = DBConnection.createOTMDAO();
        return otmDAO.inserirXML(xml,tipo);
    }

}
