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
 *         &lt;element ref="{http://xmlns.oracle.com/apps/otm}SenderTransmissionNo" minOccurs="0"/>
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
    "senderTransmissionNo"
})
@XmlRootElement(name = "TransmissionHeader")
public class TransmissionHeader {

    @XmlElement(name = "SenderTransmissionNo")
    protected String senderTransmissionNo;

    /**
     * Obtém o valor da propriedade senderTransmissionNo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSenderTransmissionNo() {
        return senderTransmissionNo;
    }

    /**
     * Define o valor da propriedade senderTransmissionNo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSenderTransmissionNo(String value) {
        this.senderTransmissionNo = value;
    }

}
