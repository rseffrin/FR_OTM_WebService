//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2019.05.28 às 06:10:30 PM BRT 
//


package br.com.frimesa.ws.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://xmlns.oracle.com/apps/otm}EchoedTransmissionHeader"/>
 *         &lt;element ref="{http://xmlns.oracle.com/apps/otm}TransmissionAckStatus" minOccurs="0"/>
 *         &lt;element ref="{http://xmlns.oracle.com/apps/otm}TransmissionAckReason" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "echoedTransmissionHeader",
    "transmissionAckStatus",
    "transmissionAckReason"
})
@XmlRootElement(name = "TransmissionAck")
public class TransmissionAck {

    @XmlElement(name = "EchoedTransmissionHeader", required = true)
    protected EchoedTransmissionHeader echoedTransmissionHeader;
    @XmlElement(name = "TransmissionAckStatus")
    protected String transmissionAckStatus;
    @XmlElement(name = "TransmissionAckReason")
    protected String transmissionAckReason;

    /**
     * Obtém o valor da propriedade echoedTransmissionHeader.
     * 
     * @return
     *     possible object is
     *     {@link EchoedTransmissionHeader }
     *     
     */
    public EchoedTransmissionHeader getEchoedTransmissionHeader() {
        return echoedTransmissionHeader;
    }

    /**
     * Define o valor da propriedade echoedTransmissionHeader.
     * 
     * @param value
     *     allowed object is
     *     {@link EchoedTransmissionHeader }
     *     
     */
    public void setEchoedTransmissionHeader(EchoedTransmissionHeader value) {
        this.echoedTransmissionHeader = value;
    }

    /**
     * Obtém o valor da propriedade transmissionAckStatus.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransmissionAckStatus() {
        return transmissionAckStatus;
    }

    /**
     * Define o valor da propriedade transmissionAckStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransmissionAckStatus(String value) {
        this.transmissionAckStatus = value;
    }

    /**
     * Obtém o valor da propriedade transmissionAckReason.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransmissionAckReason() {
        return transmissionAckReason;
    }

    /**
     * Define o valor da propriedade transmissionAckReason.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransmissionAckReason(String value) {
        this.transmissionAckReason = value;
    }

}
