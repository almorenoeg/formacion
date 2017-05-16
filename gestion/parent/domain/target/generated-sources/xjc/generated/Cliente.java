//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2017.05.15 a las 11:01:52 PM CEST 
//


package generated;

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
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{}ClienteApellido1"/&gt;
 *         &lt;element ref="{}ClienteApellido2"/&gt;
 *         &lt;element ref="{}ClienteNombre"/&gt;
 *         &lt;element ref="{}ClienteNombreComercial"/&gt;
 *         &lt;element ref="{}ClienteRazonSocial"/&gt;
 *         &lt;element ref="{}ClienteDireccion"/&gt;
 *         &lt;element ref="{}ClienteCodigoPostal"/&gt;
 *         &lt;element ref="{}ClienteCiudad"/&gt;
 *         &lt;element ref="{}ClienteProvincia"/&gt;
 *         &lt;element ref="{}ClienteTelefono1"/&gt;
 *         &lt;element ref="{}ClienteTelefono2"/&gt;
 *         &lt;element ref="{}ClienteFax1"/&gt;
 *         &lt;element ref="{}ClienteFax2"/&gt;
 *         &lt;element ref="{}ClienteEmail"/&gt;
 *         &lt;element ref="{}ClienteNotas"/&gt;
 *         &lt;element ref="{}Fincas"/&gt;
 *         &lt;element ref="{}UltimasVentas"/&gt;
 *         &lt;element ref="{}Visitas"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Id" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="CIF" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="Codigo" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="UltimaModificacion" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
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
    "fincas",
    "ultimasVentas",
    "visitas"
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
    @XmlElement(name = "Fincas", required = true)
    protected Fincas fincas;
    @XmlElement(name = "UltimasVentas", required = true)
    protected UltimasVentas ultimasVentas;
    @XmlElement(name = "Visitas", required = true)
    protected Visitas visitas;
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
