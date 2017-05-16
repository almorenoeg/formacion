//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2017.05.15 a las 11:01:54 PM CEST 
//


package com.terralcode.gestion.domain.Clientes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{}QuejaFecha"/&gt;
 *         &lt;element ref="{}QuejaGravedad"/&gt;
 *         &lt;element ref="{}QuejaObserv"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Id" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="TipoQuejaId" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "quejaFecha",
    "quejaGravedad",
    "quejaObserv"
})
@XmlRootElement(name = "Queja")
public class Queja {

    @XmlElement(name = "QuejaFecha", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar quejaFecha;
    @XmlElement(name = "QuejaGravedad")
    protected int quejaGravedad;
    @XmlElement(name = "QuejaObserv", required = true)
    protected String quejaObserv;
    @XmlAttribute(name = "Id")
    protected String id;
    @XmlAttribute(name = "TipoQuejaId")
    protected String tipoQuejaId;

    /**
     * Obtiene el valor de la propiedad quejaFecha.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getQuejaFecha() {
        return quejaFecha;
    }

    /**
     * Define el valor de la propiedad quejaFecha.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setQuejaFecha(XMLGregorianCalendar value) {
        this.quejaFecha = value;
    }

    /**
     * Obtiene el valor de la propiedad quejaGravedad.
     * 
     */
    public int getQuejaGravedad() {
        return quejaGravedad;
    }

    /**
     * Define el valor de la propiedad quejaGravedad.
     * 
     */
    public void setQuejaGravedad(int value) {
        this.quejaGravedad = value;
    }

    /**
     * Obtiene el valor de la propiedad quejaObserv.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuejaObserv() {
        return quejaObserv;
    }

    /**
     * Define el valor de la propiedad quejaObserv.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuejaObserv(String value) {
        this.quejaObserv = value;
    }

    /**
     * Obtiene el valor de la propiedad id.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoQuejaId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoQuejaId() {
        return tipoQuejaId;
    }

    /**
     * Define el valor de la propiedad tipoQuejaId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoQuejaId(String value) {
        this.tipoQuejaId = value;
    }

}
