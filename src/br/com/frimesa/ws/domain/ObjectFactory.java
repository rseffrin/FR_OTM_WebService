//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2019.05.28 às 06:10:30 PM BRT 
//


package br.com.frimesa.ws.domain;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.com.frimesa.ws.domain package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _TransmissionAckStatus_QNAME = new QName("http://xmlns.oracle.com/apps/otm", "TransmissionAckStatus");
    private final static QName _SenderTransmissionNo_QNAME = new QName("http://xmlns.oracle.com/apps/otm", "SenderTransmissionNo");
    private final static QName _TransmissionAckReason_QNAME = new QName("http://xmlns.oracle.com/apps/otm", "TransmissionAckReason");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.com.frimesa.ws.domain
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EchoedTransmissionHeader }
     * 
     */
    public EchoedTransmissionHeader createEchoedTransmissionHeader() {
        return new EchoedTransmissionHeader();
    }

    /**
     * Create an instance of {@link TransmissionHeader }
     * 
     */
    public TransmissionHeader createTransmissionHeader() {
        return new TransmissionHeader();
    }

    /**
     * Create an instance of {@link TransmissionAck }
     * 
     */
    public TransmissionAck createTransmissionAck() {
        return new TransmissionAck();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/otm", name = "TransmissionAckStatus")
    public JAXBElement<String> createTransmissionAckStatus(String value) {
        return new JAXBElement<String>(_TransmissionAckStatus_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/otm", name = "SenderTransmissionNo")
    public JAXBElement<String> createSenderTransmissionNo(String value) {
        return new JAXBElement<String>(_SenderTransmissionNo_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/apps/otm", name = "TransmissionAckReason")
    public JAXBElement<String> createTransmissionAckReason(String value) {
        return new JAXBElement<String>(_TransmissionAckReason_QNAME, String.class, null, value);
    }

}
