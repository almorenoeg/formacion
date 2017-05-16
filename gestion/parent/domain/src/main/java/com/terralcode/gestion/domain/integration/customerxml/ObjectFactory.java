//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2015.06.06 a las 08:03:37 AM CEST 
//


package com.terralcode.gestion.domain.integration.customerxml;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.naoset.crm.domain.Clientes package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ClienteApellido1_QNAME = new QName("", "ClienteApellido1");
    private final static QName _ClienteApellido2_QNAME = new QName("", "ClienteApellido2");
    private final static QName _ClienteNombre_QNAME = new QName("", "ClienteNombre");
    private final static QName _ClienteNombreComercial_QNAME = new QName("", "ClienteNombreComercial");
    private final static QName _ClienteRazonSocial_QNAME = new QName("", "ClienteRazonSocial");
    private final static QName _ClienteDireccion_QNAME = new QName("", "ClienteDireccion");
    private final static QName _ClienteCodigoPostal_QNAME = new QName("", "ClienteCodigoPostal");
    private final static QName _ClienteCiudad_QNAME = new QName("", "ClienteCiudad");
    private final static QName _ClienteProvincia_QNAME = new QName("", "ClienteProvincia");
    private final static QName _ClienteTelefono1_QNAME = new QName("", "ClienteTelefono1");
    private final static QName _ClienteTelefono2_QNAME = new QName("", "ClienteTelefono2");
    private final static QName _ClienteFax1_QNAME = new QName("", "ClienteFax1");
    private final static QName _ClienteFax2_QNAME = new QName("", "ClienteFax2");
    private final static QName _ClienteEmail_QNAME = new QName("", "ClienteEmail");
    private final static QName _ClienteNotas_QNAME = new QName("", "ClienteNotas");
    private final static QName _FincaNombre_QNAME = new QName("", "FincaNombre");
    private final static QName _FincaDireccion_QNAME = new QName("", "FincaDireccion");
    private final static QName _FincaCiudad_QNAME = new QName("", "FincaCiudad");
    private final static QName _FincaProvincia_QNAME = new QName("", "FincaProvincia");
    private final static QName _FincaTelefono_QNAME = new QName("", "FincaTelefono");
    private final static QName _FincaPorDefecto_QNAME = new QName("", "FincaPorDefecto");
    private final static QName _FincaObservaciones_QNAME = new QName("", "FincaObservaciones");
    private final static QName _VentaContenido_QNAME = new QName("", "VentaContenido");
    private final static QName _VisitaFecha_QNAME = new QName("", "VisitaFecha");
    private final static QName _VisitaTiempo_QNAME = new QName("", "VisitaTiempo");
    private final static QName _VisitaObserv_QNAME = new QName("", "VisitaObserv");
    private final static QName _VisitaRevisarSN_QNAME = new QName("", "VisitaRevisarSN");
    private final static QName _VisitaImport_QNAME = new QName("", "VisitaImport");
    private final static QName _VisitaKilometros_QNAME = new QName("", "VisitaKilometros");
    private final static QName _VisitaContacto_QNAME = new QName("", "VisitaContacto");
    private final static QName _QuejaFecha_QNAME = new QName("", "QuejaFecha");
    private final static QName _QuejaGravedad_QNAME = new QName("", "QuejaGravedad");
    private final static QName _QuejaObserv_QNAME = new QName("", "QuejaObserv");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.naoset.crm.domain.Clientes
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Clientes }
     * 
     */
    public Clientes createClientes() {
        return new Clientes();
    }

    /**
     * Create an instance of {@link Cliente }
     * 
     */
    public Cliente createCliente() {
        return new Cliente();
    }

    /**
     * Create an instance of {@link Fincas }
     * 
     */
    public Fincas createFincas() {
        return new Fincas();
    }

    /**
     * Create an instance of {@link Finca }
     * 
     */
    public Finca createFinca() {
        return new Finca();
    }

    /**
     * Create an instance of {@link UltimasVentas }
     * 
     */
    public UltimasVentas createUltimasVentas() {
        return new UltimasVentas();
    }

    /**
     * Create an instance of {@link Venta }
     * 
     */
    public Venta createVenta() {
        return new Venta();
    }

    /**
     * Create an instance of {@link Visitas }
     * 
     */
    public Visitas createVisitas() {
        return new Visitas();
    }

    /**
     * Create an instance of {@link Visita }
     * 
     */
    public Visita createVisita() {
        return new Visita();
    }

    /**
     * Create an instance of {@link Quejas }
     * 
     */
    public Quejas createQuejas() {
        return new Quejas();
    }

    /**
     * Create an instance of {@link Queja }
     * 
     */
    public Queja createQueja() {
        return new Queja();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ClienteApellido1")
    public JAXBElement<String> createClienteApellido1(String value) {
        return new JAXBElement<String>(_ClienteApellido1_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ClienteApellido2")
    public JAXBElement<String> createClienteApellido2(String value) {
        return new JAXBElement<String>(_ClienteApellido2_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ClienteNombre")
    public JAXBElement<String> createClienteNombre(String value) {
        return new JAXBElement<String>(_ClienteNombre_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ClienteNombreComercial")
    public JAXBElement<String> createClienteNombreComercial(String value) {
        return new JAXBElement<String>(_ClienteNombreComercial_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ClienteRazonSocial")
    public JAXBElement<String> createClienteRazonSocial(String value) {
        return new JAXBElement<String>(_ClienteRazonSocial_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ClienteDireccion")
    public JAXBElement<String> createClienteDireccion(String value) {
        return new JAXBElement<String>(_ClienteDireccion_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ClienteCodigoPostal")
    public JAXBElement<String> createClienteCodigoPostal(String value) {
        return new JAXBElement<String>(_ClienteCodigoPostal_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ClienteCiudad")
    public JAXBElement<String> createClienteCiudad(String value) {
        return new JAXBElement<String>(_ClienteCiudad_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ClienteProvincia")
    public JAXBElement<String> createClienteProvincia(String value) {
        return new JAXBElement<String>(_ClienteProvincia_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ClienteTelefono1")
    public JAXBElement<String> createClienteTelefono1(String value) {
        return new JAXBElement<String>(_ClienteTelefono1_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ClienteTelefono2")
    public JAXBElement<String> createClienteTelefono2(String value) {
        return new JAXBElement<String>(_ClienteTelefono2_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ClienteFax1")
    public JAXBElement<String> createClienteFax1(String value) {
        return new JAXBElement<String>(_ClienteFax1_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ClienteFax2")
    public JAXBElement<String> createClienteFax2(String value) {
        return new JAXBElement<String>(_ClienteFax2_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ClienteEmail")
    public JAXBElement<String> createClienteEmail(String value) {
        return new JAXBElement<String>(_ClienteEmail_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ClienteNotas")
    public JAXBElement<String> createClienteNotas(String value) {
        return new JAXBElement<String>(_ClienteNotas_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "FincaNombre")
    public JAXBElement<String> createFincaNombre(String value) {
        return new JAXBElement<String>(_FincaNombre_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "FincaDireccion")
    public JAXBElement<String> createFincaDireccion(String value) {
        return new JAXBElement<String>(_FincaDireccion_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "FincaCiudad")
    public JAXBElement<String> createFincaCiudad(String value) {
        return new JAXBElement<String>(_FincaCiudad_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "FincaProvincia")
    public JAXBElement<String> createFincaProvincia(String value) {
        return new JAXBElement<String>(_FincaProvincia_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "FincaTelefono")
    public JAXBElement<String> createFincaTelefono(String value) {
        return new JAXBElement<String>(_FincaTelefono_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "FincaPorDefecto")
    public JAXBElement<Integer> createFincaPorDefecto(Integer value) {
        return new JAXBElement<Integer>(_FincaPorDefecto_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "FincaObservaciones")
    public JAXBElement<String> createFincaObservaciones(String value) {
        return new JAXBElement<String>(_FincaObservaciones_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "VentaContenido")
    public JAXBElement<String> createVentaContenido(String value) {
        return new JAXBElement<String>(_VentaContenido_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "VisitaFecha")
    public JAXBElement<XMLGregorianCalendar> createVisitaFecha(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_VisitaFecha_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "VisitaTiempo")
    public JAXBElement<XMLGregorianCalendar> createVisitaTiempo(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_VisitaTiempo_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "VisitaObserv")
    public JAXBElement<String> createVisitaObserv(String value) {
        return new JAXBElement<String>(_VisitaObserv_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "VisitaRevisarSN")
    public JAXBElement<Integer> createVisitaRevisarSN(Integer value) {
        return new JAXBElement<Integer>(_VisitaRevisarSN_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "VisitaImport")
    public JAXBElement<Integer> createVisitaImport(Integer value) {
        return new JAXBElement<Integer>(_VisitaImport_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "VisitaKilometros")
    public JAXBElement<BigDecimal> createVisitaKilometros(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_VisitaKilometros_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "VisitaContacto")
    public JAXBElement<String> createVisitaContacto(String value) {
        return new JAXBElement<String>(_VisitaContacto_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "QuejaFecha")
    public JAXBElement<XMLGregorianCalendar> createQuejaFecha(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_QuejaFecha_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "QuejaGravedad")
    public JAXBElement<Integer> createQuejaGravedad(Integer value) {
        return new JAXBElement<Integer>(_QuejaGravedad_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "QuejaObserv")
    public JAXBElement<String> createQuejaObserv(String value) {
        return new JAXBElement<String>(_QuejaObserv_QNAME, String.class, null, value);
    }

}
