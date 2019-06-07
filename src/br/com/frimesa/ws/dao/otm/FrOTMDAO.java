package br.com.frimesa.ws.dao.otm;

import java.io.Serializable;

import br.com.frimesa.ws.dao.IGenericDAO;
import br.com.frimesa.ws.domain.TransmissionAck;

public interface FrOTMDAO extends IGenericDAO, Serializable{
	public TransmissionAck inserirXML(String xml);
}
