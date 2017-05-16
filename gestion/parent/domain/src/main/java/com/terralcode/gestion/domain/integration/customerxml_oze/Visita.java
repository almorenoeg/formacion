//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantaci�n de la referencia de enlace (JAXB) XML v2.2.5-2 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perder�n si se vuelve a compilar el esquema de origen. 
// Generado el: PM.06.12 a las 12:47:18 PM CEST 
//


package com.terralcode.gestion.domain.integration.customerxml_oze;

import java.math.BigDecimal;
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
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}VisitaFecha"/>
 *         &lt;element ref="{}VisitaTiempo"/>
 *         &lt;element ref="{}VisitaObservaciones"/>
 *         &lt;element ref="{}VisitaRevisarSN"/>
 *         &lt;element ref="{}VisitaImport"/>
 *         &lt;element ref="{}VisitaKilometros"/>
 *         &lt;element ref="{}VisitaContacto"/>
 *         &lt;element ref="{}Quejas"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ClienteId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="PersonalId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="MotivoVisitaId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="UltimaModificacion" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "visitaFecha",
    "visitaTiempo",
    "visitaObservaciones",
    "visitaRevisarSN",
    "visitaImport",
    "visitaKilometros",
    "visitaContacto",
    "quejas"
})
@XmlRootElement(name = "Visita")
public class Visita {

    @XmlElement(name = "VisitaFecha", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar visitaFecha;
    @XmlElement(name = "VisitaTiempo", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar visitaTiempo;
    @XmlElement(name = "VisitaObservaciones", required = true)
    protected String visitaObservaciones;
    @XmlElement(name = "VisitaRevisarSN")
    protected int visitaRevisarSN;
    @XmlElement(name = "VisitaImport")
    protected int visitaImport;
    @XmlElement(name = "VisitaKilometros", required = true)
    protected BigDecimal visitaKilometros;
    @XmlElement(name = "VisitaContacto", required = true)
    protected String visitaContacto;
    @XmlElement(name = "Quejas", required = true)
    protected Quejas quejas;
    @XmlAttribute(name = "Id")
    protected String id;
    @XmlAttribute(name = "ClienteId")
    protected String clienteId;
    @XmlAttribute(name = "PersonalId")
    protected String personalId;
    @XmlAttribute(name = "MotivoVisitaId")
    protected String motivoVisitaId;
    @XmlAttribute(name = "UltimaModificacion")
    protected String ultimaModificacion;

    /**
     * Obtiene el valor de la propiedad visitaFecha.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getVisitaFecha() {
        return visitaFecha;
    }

    /**
     * Define el valor de la propiedad visitaFecha.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setVisitaFecha(XMLGregorianCalendar value) {
        this.visitaFecha = value;
    }

    /**
     * Obtiene el valor de la propiedad visitaTiempo.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getVisitaTiempo() {
        return visitaTiempo;
    }

    /**
     * Define el valor de la propiedad visitaTiempo.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setVisitaTiempo(XMLGregorianCalendar value) {
        this.visitaTiempo = value;
    }

    /**
     * Obtiene el valor de la propiedad visitaObservaciones.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVisitaObservaciones() {
        return visitaObservaciones;
    }

    /**
     * Define el valor de la propiedad visitaObservaciones.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVisitaObservaciones(String value) {
        this.visitaObservaciones = value;
    }

    /**
     * Obtiene el valor de la propiedad visitaRevisarSN.
     * 
     */
    public int getVisitaRevisarSN() {
        return visitaRevisarSN;
    }

    /**
     * Define el valor de la propiedad visitaRevisarSN.
     * 
     */
    public void setVisitaRevisarSN(int value) {
        this.visitaRevisarSN = value;
    }

    /**
     * Obtiene el valor de la propiedad visitaImport.
     * 
     */
    public int getVisitaImport() {
        return visitaImport;
    }

    /**
     * Define el valor de la propiedad visitaImport.
     * 
     */
    public void setVisitaImport(int value) {
        this.visitaImport = value;
    }

    /**
     * Obtiene el valor de la propiedad visitaKilometros.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVisitaKilometros() {
        return visitaKilometros;
    }

    /**
     * Define el valor de la propiedad visitaKilometros.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVisitaKilometros(BigDecimal value) {
        this.visitaKilometros = value;
    }

    /**
     * Obtiene el valor de la propiedad visitaContacto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVisitaContacto() {
        return visitaContacto;
    }

    /**
     * Define el valor de la propiedad visitaContacto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVisitaContacto(String value) {
        this.visitaContacto = value;
    }

    /**
     * Obtiene el valor de la propiedad quejas.
     * 
     * @return
     *     possible object is
     *     {@link Quejas }
     *     
     */
    public Quejas getQuejas() {
        return quejas;
    }

    /**
     * Define el valor de la propiedad quejas.
     * 
     * @param value
     *     allowed object is
     *     {@link Quejas }
     *     
     */
    public void setQuejas(Quejas value) {
        this.quejas = value;
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
     * Obtiene el valor de la propiedad clienteId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClienteId() {
        return clienteId;
    }

    /**
     * Define el valor de la propiedad clienteId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClienteId(String value) {
        this.clienteId = value;
    }

    /**
     * Obtiene el valor de la propiedad personalId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonalId() {
        return personalId;
    }

    /**
     * Define el valor de la propiedad personalId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonalId(String value) {
        this.personalId = value;
    }

    /**
     * Obtiene el valor de la propiedad motivoVisitaId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMotivoVisitaId() {
        return motivoVisitaId;
    }

    /**
     * Define el valor de la propiedad motivoVisitaId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMotivoVisitaId(String value) {
        this.motivoVisitaId = value;
    }

    /**
     * Obtiene el valor de la propiedad ultimaModificacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUltimaModificacion() {
        return ultimaModificacion;
    }

    /**
     * Define el valor de la propiedad ultimaModificacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUltimaModificacion(String value) {
        this.ultimaModificacion = value;
    }

}
