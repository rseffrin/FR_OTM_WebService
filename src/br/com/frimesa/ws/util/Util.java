package br.com.frimesa.ws.util;

import java.io.StringReader;
import java.io.StringWriter;

import javax.ws.rs.core.MediaType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import br.com.frimesa.ws.domain.EchoedTransmissionHeader;
import br.com.frimesa.ws.domain.TransmissionAck;
import br.com.frimesa.ws.domain.TransmissionHeader;

public class Util {
	
	public static final String APPLICATION_JSON = MediaType.APPLICATION_JSON + ";charset=utf-8";
	
	public static final String SUCESSO = "PROCESSED";
	
	public static final String ERROR = "ERROR";
    
	public static final String VOUCHER_ALLOCATION = "VOUCHER_ALLOCATION";
	
	public static final String PLANNED_SHIPMENT = "PLANNED_SHIPMENT";
	
	public static final String CUSTO_TRANSFERENCIA = "CUSTO_TRANSFERENCIA";
	
	public static String transmissionXML;
	
	public static boolean LOG = false;
	
	public static void debug(String message){
		if (Util.LOG) {
			System.out.println(message);
		}
	}
	
	public static String getSenderTransmissionNo(Document doc) {
		//String transmission = doc.getElementsByTagName("otm:SenderTransmissionNo").item(0).getFirstChild().getNodeValue();
		String transmission = null;
		if (doc.getElementsByTagName("SenderTransmissionNo").item(0)!=null)
			transmission = doc.getElementsByTagName("SenderTransmissionNo").item(0).getFirstChild().getNodeValue();
		return transmission;
    }
	
	
	public static String convertDocumentToString(Document doc) {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer;
        try {
            transformer = tf.newTransformer();
            // below code to remove XML declaration
            // transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(doc), new StreamResult(writer));
            String output = writer.getBuffer().toString();
            return output;
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        
        return null;
    }

    public static Document convertStringToDocument(String xmlStr) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
        DocumentBuilder builder;  
        try  
        {  
            builder = factory.newDocumentBuilder();  
            Document doc = builder.parse( new InputSource( new StringReader( xmlStr ) ) ); 
            return doc;
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
        return null;
    }
    
    public static TransmissionAck montaRetorno(String status,String erro) {
        Document doc = Util.convertStringToDocument(transmissionXML);		
		String transmission = Util.getSenderTransmissionNo(doc);	    
		TransmissionAck t = new TransmissionAck();
		t.setTransmissionAckStatus(status);
		t.setTransmissionAckReason(erro);
		EchoedTransmissionHeader echodTranHeader = new EchoedTransmissionHeader(); 
		TransmissionHeader tranHeader = new TransmissionHeader();
	//	tranHeader.setVersion("6.4.3");
	//	tranHeader.setTransactionCount("1");
	//	tranHeader.setSenderHostName("http://whitetree.frimesa.local:7778");
	//	tranHeader.setUserName("FR.RSEFFRIN-EN");
		tranHeader.setSenderTransmissionNo(transmission);
	//	tranHeader.setReferenceTransmissionNo("0");
		echodTranHeader.setTransmissionHeader(tranHeader);
		t.setEchoedTransmissionHeader(echodTranHeader);
		return t;
	}

}
