//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantaci�n de la referencia de enlace (JAXB) XML v2.2.5-2 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perder�n si se vuelve a compilar el esquema de origen. 
// Generado el: PM.06.12 a las 12:47:18 PM CEST 
//


package com.terralcode.gestion.domain.integration.customerxml_oze;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}QuejaGravedad"/>
 *         &lt;element ref="{}QuejaObservaciones"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Fecha" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="TipoQuejaId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "quejaGravedad",
    "quejaObservaciones"
})
@XmlRootElement(name = "Queja")
public class Queja {

    @XmlElement(name = "QuejaGravedad")
    protected int quejaGravedad;
    @XmlElement(name = "QuejaObservaciones", required = true)
    protected String quejaObservaciones;
    @XmlAttribute(name = "Id")
    protected String id;
    @XmlAttribute(name = "Fecha")
    protected String fecha;
    @XmlAttribute(name = "TipoQuejaId")
    protected String tipoQuejaId;

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
     * Obtiene el valor de la propiedad quejaObservaciones.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuejaObservaciones() {
        return quejaObservaciones;
    }

    /**
     * Define el valor de la propiedad quejaObservaciones.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuejaObservaciones(String value) {
        this.quejaObservaciones = value;
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
     * Obtiene el valor de la propiedad fecha.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Define el valor de la propiedad fecha.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFecha(String value) {
        this.fecha = value;
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
