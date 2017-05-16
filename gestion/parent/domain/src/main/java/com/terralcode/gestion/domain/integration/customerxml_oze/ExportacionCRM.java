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
 *         &lt;element ref="{}TablasMaestras"/>
 *         &lt;element ref="{}Clientes"/>
 *         &lt;element ref="{}Visitas"/>
 *         &lt;element ref="{}ExportacionObservaciones"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Hora" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Fecha" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Codigo" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Version" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Descripcion" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "tablasMaestras",
    "clientes",
    "visitas",
    "exportacionObservaciones"
})
@XmlRootElement(name = "ExportacionCRM")
public class ExportacionCRM {

    @XmlElement(name = "TablasMaestras", required = true)
    protected TablasMaestras tablasMaestras;
    @XmlElement(name = "Clientes", required = true)
    protected Clientes clientes;
    @XmlElement(name = "Visitas", required = true)
    protected Visitas visitas;
    @XmlElement(name = "ExportacionObservaciones", required = true)
    protected String exportacionObservaciones;
    @XmlAttribute(name = "Id")
    protected String id;
    @XmlAttribute(name = "Hora")
    protected String hora;
    @XmlAttribute(name = "Fecha")
    protected String fecha;
    @XmlAttribute(name = "Codigo")
    protected String codigo;
    @XmlAttribute(name = "Version")
    protected String version;
    @XmlAttribute(name = "Descripcion")
    protected String descripcion;

    /**
     * Obtiene el valor de la propiedad tablasMaestras.
     * 
     * @return
     *     possible object is
     *     {@link TablasMaestras }
     *     
     */
    public TablasMaestras getTablasMaestras() {
        return tablasMaestras;
    }

    /**
     * Define el valor de la propiedad tablasMaestras.
     * 
     * @param value
     *     allowed object is
     *     {@link TablasMaestras }
     *     
     */
    public void setTablasMaestras(TablasMaestras value) {
        this.tablasMaestras = value;
    }

    /**
     * Obtiene el valor de la propiedad clientes.
     * 
     * @return
     *     possible object is
     *     {@link Clientes }
     *     
     */
    public Clientes getClientes() {
        return clientes;
    }

    /**
     * Define el valor de la propiedad clientes.
     * 
     * @param value
     *     allowed object is
     *     {@link Clientes }
     *     
     */
    public void setClientes(Clientes value) {
        this.clientes = value;
    }

    /**
     * Obtiene el valor de la propiedad visitas.
     * 
     * @return
     *     possible object is
     *     {@link Visitas }
     *     
     */
    public Visitas getVisitas() {
        return visitas;
    }

    /**
     * Define el valor de la propiedad visitas.
     * 
     * @param value
     *     allowed object is
     *     {@link Visitas }
     *     
     */
    public void setVisitas(Visitas value) {
        this.visitas = value;
    }

    /**
     * Obtiene el valor de la propiedad exportacionObservaciones.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExportacionObservaciones() {
        return exportacionObservaciones;
    }

    /**
     * Define el valor de la propiedad exportacionObservaciones.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExportacionObservaciones(String value) {
        this.exportacionObservaciones = value;
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
     * Obtiene el valor de la propiedad hora.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHora() {
        return hora;
    }

    /**
     * Define el valor de la propiedad hora.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHora(String value) {
        this.hora = value;
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
     * Obtiene el valor de la propiedad version.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Define el valor de la propiedad version.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Obtiene el valor de la propiedad descripcion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Define el valor de la propiedad descripcion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
    }

}
