package br.com.frimesa.ws.util;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class StringToDocumentToString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*final String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"+
                "<Emp id=\"1\"><name>Pankaj</name><age>25</age>\n"+
                "<role>Developer</role><gen>Male</gen></Emp>";*/
		final String xmlStr = "<otm:Transmission xmlns:otm=\"http://xmlns.oracle.com/apps/otm\"><otm:TransmissionHeader><otm:SenderTransmissionNo>1700445</otm:SenderTransmissionNo></otm:TransmissionHeader></otm:Transmission>";
		
		Document doc = convertStringToDocument(xmlStr);
		
		String str = convertDocumentToString(doc);
		System.out.println(str);
		
		System.out.println( getSenderTransmissionNo( doc));
	}
	
	public static String getSenderTransmissionNo(Document doc) {
		String transmission = doc.getElementsByTagName("otm:SenderTransmissionNo").item(0).getFirstChild().getNodeValue();
		return transmission;
    }
	
	
	 private static String convertDocumentToString(Document doc) {
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

	    private static Document convertStringToDocument(String xmlStr) {
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

}
