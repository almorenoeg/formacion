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
 *         &lt;element ref="{}ClienteApellido1"/>
 *         &lt;element ref="{}ClienteApellido2"/>
 *         &lt;element ref="{}ClienteNombre"/>
 *         &lt;element ref="{}ClienteNombreComercial"/>
 *         &lt;element ref="{}ClienteRazonSocial"/>
 *         &lt;element ref="{}ClienteDireccion"/>
 *         &lt;element ref="{}ClienteCodigoPostal"/>
 *         &lt;element ref="{}ClienteCiudad"/>
 *         &lt;element ref="{}ClienteProvincia"/>
 *         &lt;element ref="{}ClienteTelefono1"/>
 *         &lt;element ref="{}ClienteTelefono2"/>
 *         &lt;element ref="{}ClienteFax1"/>
 *         &lt;element ref="{}ClienteFax2"/>
 *         &lt;element ref="{}ClienteEmail"/>
 *         &lt;element ref="{}ClienteNotas"/>
 *         &lt;element ref="{}Fincas"/>
 *         &lt;element ref="{}UltimasVentas"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="CIF" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Codigo" type="{http://www.w3.org/2001/XMLSchema}string" />
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
    "clienteApellido1",
    "clienteApellido2",
    "clienteNombre",
    "clienteNombreComercial",
    "clienteRazonSocial",
    "clienteDireccion",
    "clienteCodigoPostal",
    "clienteCiudad",
    "clienteProvincia",
    "clienteTelefono1",
    "clienteTelefono2",
    "clienteFax1",
    "clienteFax2",
    "clienteEmail",
    "clienteNotas",
    "clienteEstado",
    "clienteImagenSN",
    "clienteExclusSN",
    "clienteCrecerSN",
    "clienteNivelAsesora",
    "clienteNivelVenta",
    "fincas",
    "ultimasVentas"
})
@XmlRootElement(name = "Cliente")
public class Cliente {

    @XmlElement(name = "ClienteApellido1", required = true)
    protected String clienteApellido1;
    @XmlElement(name = "ClienteApellido2", required = true)
    protected String clienteApellido2;
    @XmlElement(name = "ClienteNombre", required = true)
    protected String clienteNombre;
    @XmlElement(name = "ClienteNombreComercial", required = true)
    protected String clienteNombreComercial;
    @XmlElement(name = "ClienteRazonSocial", required = true)
    protected String clienteRazonSocial;
    @XmlElement(name = "ClienteDireccion", required = true)
    protected String clienteDireccion;
    @XmlElement(name = "ClienteCodigoPostal", required = true)
    protected String clienteCodigoPostal;
    @XmlElement(name = "ClienteCiudad", required = true)
    protected String clienteCiudad;
    @XmlElement(name = "ClienteProvincia", required = true)
    protected String clienteProvincia;
    @XmlElement(name = "ClienteTelefono1", required = true)
    protected String clienteTelefono1;
    @XmlElement(name = "ClienteTelefono2", required = true)
    protected String clienteTelefono2;
    @XmlElement(name = "ClienteFax1", required = true)
    protected String clienteFax1;
    @XmlElement(name = "ClienteFax2", required = true)
    protected String clienteFax2;
    @XmlElement(name = "ClienteEmail", required = true)
    protected String clienteEmail;
    @XmlElement(name = "ClienteNotas", required = true)
    protected String clienteNotas;
    @XmlElement(name = "ClienteEstado", required = true)
    protected String clienteEstado;
    @XmlElement(name = "ClienteImagenSN", required = true)
    protected String clienteImagenSN;
    @XmlElement(name = "ClienteExclusSN", required = true)
    protected String clienteExclusSN;
    @XmlElement(name = "ClienteCrecerSN", required = true)
    protected String clienteCrecerSN;
    @XmlElement(name = "ClienteNivelAsesora", required = true)
    protected String clienteNivelAsesora;
    @XmlElement(name = "ClienteNivelVenta", required = true)
    protected String clienteNivelVenta;
    @XmlElement(name = "Fincas", required = true)
    protected Fincas fincas;
    @XmlElement(name = "UltimasVentas", required = true)
    protected UltimasVentas ultimasVentas;
    @XmlAttribute(name = "Id")
    protected String id;
    @XmlAttribute(name = "CIF")
    protected String cif;
    @XmlAttribute(name = "Codigo")
    protected String codigo;
    @XmlAttribute(name = "UltimaModificacion")
    protected String ultimaModificacion;

    /**
     * Obtiene el valor de la propiedad clienteApellido1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClienteApellido1() {
        return clienteApellido1;
    }

    /**
     * Define el valor de la propiedad clienteApellido1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClienteApellido1(String value) {
        this.clienteApellido1 = value;
    }

    /**
     * Obtiene el valor de la propiedad clienteApellido2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClienteApellido2() {
        return clienteApellido2;
    }

    /**
     * Define el valor de la propiedad clienteApellido2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClienteApellido2(String value) {
        this.clienteApellido2 = value;
    }

    /**
     * Obtiene el valor de la propiedad clienteNombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClienteNombre() {
        return clienteNombre;
    }

    /**
     * Define el valor de la propiedad clienteNombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClienteNombre(String value) {
        this.clienteNombre = value;
    }

    /**
     * Obtiene el valor de la propiedad clienteNombreComercial.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClienteNombreComercial() {
        return clienteNombreComercial;
    }

    /**
     * Define el valor de la propiedad clienteNombreComercial.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClienteNombreComercial(String value) {
        this.clienteNombreComercial = value;
    }

    /**
     * Obtiene el valor de la propiedad clienteRazonSocial.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClienteRazonSocial() {
        return clienteRazonSocial;
    }

    /**
     * Define el valor de la propiedad clienteRazonSocial.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClienteRazonSocial(String value) {
        this.clienteRazonSocial = value;
    }

    /**
     * Obtiene el valor de la propiedad clienteDireccion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClienteDireccion() {
        return clienteDireccion;
    }

    /**
     * Define el valor de la propiedad clienteDireccion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClienteDireccion(String value) {
        this.clienteDireccion = value;
    }

    /**
     * Obtiene el valor de la propiedad clienteCodigoPostal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClienteCodigoPostal() {
        return clienteCodigoPostal;
    }

    /**
     * Define el valor de la propiedad clienteCodigoPostal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClienteCodigoPostal(String value) {
        this.clienteCodigoPostal = value;
    }

    /**
     * Obtiene el valor de la propiedad clienteCiudad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClienteCiudad() {
        return clienteCiudad;
    }

    /**
     * Define el valor de la propiedad clienteCiudad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClienteCiudad(String value) {
        this.clienteCiudad = value;
    }

    /**
     * Obtiene el valor de la propiedad clienteProvincia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClienteProvincia() {
        return clienteProvincia;
    }

    /**
     * Define el valor de la propiedad clienteProvincia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClienteProvincia(String value) {
        this.clienteProvincia = value;
    }

    /**
     * Obtiene el valor de la propiedad clienteTelefono1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClienteTelefono1() {
        return clienteTelefono1;
    }

    /**
     * Define el valor de la propiedad clienteTelefono1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClienteTelefono1(String value) {
        this.clienteTelefono1 = value;
    }

    /**
     * Obtiene el valor de la propiedad clienteTelefono2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClienteTelefono2() {
        return clienteTelefono2;
    }

    /**
     * Define el valor de la propiedad clienteTelefono2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClienteTelefono2(String value) {
        this.clienteTelefono2 = value;
    }

    /**
     * Obtiene el valor de la propiedad clienteFax1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClienteFax1() {
        return clienteFax1;
    }

    /**
     * Define el valor de la propiedad clienteFax1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClienteFax1(String value) {
        this.clienteFax1 = value;
    }

    /**
     * Obtiene el valor de la propiedad clienteFax2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClienteFax2() {
        return clienteFax2;
    }

    /**
     * Define el valor de la propiedad clienteFax2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClienteFax2(String value) {
        this.clienteFax2 = value;
    }

    /**
     * Obtiene el valor de la propiedad clienteEmail.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClienteEmail() {
        return clienteEmail;
    }

    /**
     * Define el valor de la propiedad clienteEmail.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClienteEmail(String value) {
        this.clienteEmail = value;
    }

    /**
     * Obtiene el valor de la propiedad clienteNotas.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClienteNotas() {
        return clienteNotas;
    }

    /**
     * Define el valor de la propiedad clienteNotas.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClienteNotas(String value) {
        this.clienteNotas = value;
    }

    public String getClienteEstado() {
        return clienteEstado;
    }

    public void setClienteEstado(String clienteEstado) {
        this.clienteEstado = clienteEstado;
    }

    public String getClienteImagenSN() {
        return clienteImagenSN;
    }

    public void setClienteImagenSN(String clienteImagenSN) {
        this.clienteImagenSN = clienteImagenSN;
    }

    public String getClienteExclusSN() {
        return clienteExclusSN;
    }

    public void setClienteExclusSN(String clienteExclusSN) {
        this.clienteExclusSN = clienteExclusSN;
    }

    public String getClienteCrecerSN() {
        return clienteCrecerSN;
    }

    public void setClienteCrecerSN(String clienteCrecerSN) {
        this.clienteCrecerSN = clienteCrecerSN;
    }

    public String getClienteNivelAsesora() {
        return clienteNivelAsesora;
    }

    public void setClienteNivelAsesora(String clienteNivelAsesora) {
        this.clienteNivelAsesora = clienteNivelAsesora;
    }

    public String getClienteNivelVenta() {
        return clienteNivelVenta;
    }

    public void setClienteNivelVenta(String clienteNivelVenta) {
        this.clienteNivelVenta = clienteNivelVenta;
    }

    
    
    /**
     * Obtiene el valor de la propiedad fincas.
     * 
     * @return
     *     possible object is
     *     {@link Fincas }
     *     
     */
    public Fincas getFincas() {
        return fincas;
    }

    /**
     * Define el valor de la propiedad fincas.
     * 
     * @param value
     *     allowed object is
     *     {@link Fincas }
     *     
     */
    public void setFincas(Fincas value) {
        this.fincas = value;
    }

    /**
     * Obtiene el valor de la propiedad ultimasVentas.
     * 
     * @return
     *     possible object is
     *     {@link UltimasVentas }
     *     
     */
    public UltimasVentas getUltimasVentas() {
        return ultimasVentas;
    }

    /**
     * Define el valor de la propiedad ultimasVentas.
     * 
     * @param value
     *     allowed object is
     *     {@link UltimasVentas }
     *     
     */
    public void setUltimasVentas(UltimasVentas value) {
        this.ultimasVentas = value;
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
     * Obtiene el valor de la propiedad cif.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCIF() {
        return cif;
    }

    /**
     * Define el valor de la propiedad cif.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCIF(String value) {
        this.cif = value;
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
