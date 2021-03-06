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
 *         &lt;element ref="{}FincaNombre"/>
 *         &lt;element ref="{}FincaDireccion"/>
 *         &lt;element ref="{}FincaCiudad"/>
 *         &lt;element ref="{}FincaProvincia"/>
 *         &lt;element ref="{}FincaTelefono"/>
 *         &lt;element ref="{}FincaPorDefecto"/>
 *         &lt;element ref="{}FincaObservaciones"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Codigo" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="CodigoExplotacion" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "fincaNombre",
    "fincaDireccion",
    "fincaCiudad",
    "fincaProvincia",
    "fincaTelefono",
    "fincaPorDefecto",
    "fincaObservaciones"
})
@XmlRootElement(name = "Finca")
public class Finca {

    @XmlElement(name = "FincaNombre", required = true)
    protected String fincaNombre;
    @XmlElement(name = "FincaDireccion", required = true)
    protected String fincaDireccion;
    @XmlElement(name = "FincaCiudad", required = true)
    protected String fincaCiudad;
    @XmlElement(name = "FincaProvincia", required = true)
    protected String fincaProvincia;
    @XmlElement(name = "FincaTelefono", required = true)
    protected String fincaTelefono;
    @XmlElement(name = "FincaPorDefecto")
    protected int fincaPorDefecto;
    @XmlElement(name = "FincaObservaciones", required = true)
    protected String fincaObservaciones;
    @XmlAttribute(name = "Id")
    protected String id;
    @XmlAttribute(name = "Codigo")
    protected String codigo;
    @XmlAttribute(name = "CodigoExplotacion")
    protected String codigoExplotacion;

    /**
     * Obtiene el valor de la propiedad fincaNombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFincaNombre() {
        return fincaNombre;
    }

    /**
     * Define el valor de la propiedad fincaNombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFincaNombre(String value) {
        this.fincaNombre = value;
    }

    /**
     * Obtiene el valor de la propiedad fincaDireccion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFincaDireccion() {
        return fincaDireccion;
    }

    /**
     * Define el valor de la propiedad fincaDireccion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFincaDireccion(String value) {
        this.fincaDireccion = value;
    }

    /**
     * Obtiene el valor de la propiedad fincaCiudad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFincaCiudad() {
        return fincaCiudad;
    }

    /**
     * Define el valor de la propiedad fincaCiudad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFincaCiudad(String value) {
        this.fincaCiudad = value;
    }

    /**
     * Obtiene el valor de la propiedad fincaProvincia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFincaProvincia() {
        return fincaProvincia;
    }

    /**
     * Define el valor de la propiedad fincaProvincia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFincaProvincia(String value) {
        this.fincaProvincia = value;
    }

    /**
     * Obtiene el valor de la propiedad fincaTelefono.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFincaTelefono() {
        return fincaTelefono;
    }

    /**
     * Define el valor de la propiedad fincaTelefono.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFincaTelefono(String value) {
        this.fincaTelefono = value;
    }

    /**
     * Obtiene el valor de la propiedad fincaPorDefecto.
     * 
     */
    public int getFincaPorDefecto() {
        return fincaPorDefecto;
    }

    /**
     * Define el valor de la propiedad fincaPorDefecto.
     * 
     */
    public void setFincaPorDefecto(int value) {
        this.fincaPorDefecto = value;
    }

    /**
     * Obtiene el valor de la propiedad fincaObservaciones.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFincaObservaciones() {
        return fincaObservaciones;
    }

    /**
     * Define el valor de la propiedad fincaObservaciones.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFincaObservaciones(String value) {
        this.fincaObservaciones = value;
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
     * Obtiene el valor de la propiedad codigo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Define el valor de la propiedad codigo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigo(String value) {
        this.codigo = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoExplotacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoExplotacion() {
        return codigoExplotacion;
    }

    /**
     * Define el valor de la propiedad codigoExplotacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoExplotacion(String value) {
        this.codigoExplotacion = value;
    }

}
