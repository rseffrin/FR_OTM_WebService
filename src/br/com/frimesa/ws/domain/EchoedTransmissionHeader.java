//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementa��o de Refer�ncia (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modifica��es neste arquivo ser�o perdidas ap�s a recompila��o do esquema de origem. 
// Gerado em: 2019.05.28 �s 06:10:30 PM BRT 
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
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://xmlns.oracle.com/apps/otm}TransmissionHeader"/>
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
    "transmissionHeader"
})
@XmlRootElement(name = "EchoedTransmissionHeader")
public class EchoedTransmissionHeader {

    @XmlElement(name = "TransmissionHeader", required = true)
    protected TransmissionHeader transmissionHeader;

    /**
     * Obt�m o valor da propriedade transmissionHeader.
     * 
     * @return
     *     possible object is
     *     {@link TransmissionHeader }
     *     
     */
    public TransmissionHeader getTransmissionHeader() {
        return transmissionHeader;
    }

    /**
     * Define o valor da propriedade transmissionHeader.
     * 
     * @param value
     *     allowed object is
     *     {@link TransmissionHeader }
     *     
     */
    public void setTransmissionHeader(TransmissionHeader value) {
        this.transmissionHeader = value;
    }

}
