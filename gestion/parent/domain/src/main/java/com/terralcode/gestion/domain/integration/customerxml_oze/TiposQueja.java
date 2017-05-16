//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantaci�n de la referencia de enlace (JAXB) XML v2.2.5-2 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perder�n si se vuelve a compilar el esquema de origen. 
// Generado el: PM.06.12 a las 12:47:18 PM CEST 
//


package com.terralcode.gestion.domain.integration.customerxml_oze;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="TipoQueja" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="Id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="Descripcion" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="UltimaModificacion" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "tipoQueja"
})
@XmlRootElement(name = "TiposQueja")
public class TiposQueja {

    @XmlElement(name = "TipoQueja")
    protected List<TiposQueja.TipoQueja> tipoQueja;

    /**
     * Gets the value of the tipoQueja property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tipoQueja property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTipoQueja().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TiposQueja.TipoQueja }
     * 
     * 
     */
    public List<TiposQueja.TipoQueja> getTipoQueja() {
        if (tipoQueja == null) {
            tipoQueja = new ArrayList<TiposQueja.TipoQueja>();
        }
        return this.tipoQueja;
    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="Id" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="Descripcion" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="UltimaModificacion" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class TipoQueja {

        @XmlAttribute(name = "Id")
        protected String id;
        @XmlAttribute(name = "Descripcion")
        protected String descripcion;
        @XmlAttribute(name = "UltimaModificacion")
        protected String ultimaModificacion;

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

}
