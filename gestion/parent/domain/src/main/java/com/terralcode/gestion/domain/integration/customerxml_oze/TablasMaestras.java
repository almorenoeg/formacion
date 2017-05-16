//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantaci�n de la referencia de enlace (JAXB) XML v2.2.5-2 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perder�n si se vuelve a compilar el esquema de origen. 
// Generado el: PM.06.12 a las 12:47:18 PM CEST 
//


package com.terralcode.gestion.domain.integration.customerxml_oze;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element ref="{}MotivosVisita"/>
 *         &lt;element ref="{}TiposQueja"/>
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
    "motivosVisita",
    "tiposQueja"
})
@XmlRootElement(name = "TablasMaestras")
public class TablasMaestras {

    @XmlElement(name = "MotivosVisita", required = true)
    protected MotivosVisita motivosVisita;
    @XmlElement(name = "TiposQueja", required = true)
    protected TiposQueja tiposQueja;

    /**
     * Obtiene el valor de la propiedad motivosVisita.
     * 
     * @return
     *     possible object is
     *     {@link MotivosVisita }
     *     
     */
    public MotivosVisita getMotivosVisita() {
        return motivosVisita;
    }

    /**
     * Define el valor de la propiedad motivosVisita.
     * 
     * @param value
     *     allowed object is
     *     {@link MotivosVisita }
     *     
     */
    public void setMotivosVisita(MotivosVisita value) {
        this.motivosVisita = value;
    }

    /**
     * Obtiene el valor de la propiedad tiposQueja.
     * 
     * @return
     *     possible object is
     *     {@link TiposQueja }
     *     
     */
    public TiposQueja getTiposQueja() {
        return tiposQueja;
    }

    /**
     * Define el valor de la propiedad tiposQueja.
     * 
     * @param value
     *     allowed object is
     *     {@link TiposQueja }
     *     
     */
    public void setTiposQueja(TiposQueja value) {
        this.tiposQueja = value;
    }

}
