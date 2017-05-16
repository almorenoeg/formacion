package com.terralcode.gestion.domain.integration.customerxml;

import com.terralcode.gestion.domain.customer.CustomerCRM;
import com.terralcode.gestion.domain.sales.Sales;
import com.terralcode.framework.domain.commons.contactinfo.address.PlainAddress;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ezequiel
 */
public class ClienteToCustomerConverter {

    public static CustomerCRM convert(Cliente cliente)
    {
        CustomerCRM customerCRM = new CustomerCRM();

        customerCRM.setCode(cliente.codigo);
        customerCRM.setCompanyTaxCode(cliente.cif);
        customerCRM.setName(cliente.clienteNombreComercial);
        assignLastModification(cliente, customerCRM);
        assignAddress(cliente, customerCRM);
        assignAdditionalAddress(cliente, customerCRM);

        Calendar cal = Calendar.getInstance(new Locale("es", "ES"));
        for (Venta venta : cliente.ultimasVentas.getVenta()) {
            if (venta.fecha != null) {
                Sales sale = new Sales();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                try {
                    cal.setTime(formatter.parse(venta.fecha));

                    sale.setDateSale((Calendar) cal.clone());
                    sale.setDescription(venta.ventaContenido);
                    sale.setAmount(Double.parseDouble(venta.numero));
                    sale.setPrice(0D);
                    //sale.setPrice(Double.parseDouble(venta.total));
                } catch (Exception e) {
                    sale = new Sales();
                }
                sale.setCustomer(customerCRM);
                customerCRM.getSales().add(sale);
            }

        }

        return customerCRM;
    }

    private static void assignAdditionalAddress(Cliente cliente, CustomerCRM customerCRM)
    {
        for (Finca f : cliente.fincas.getFinca()) {
            if (f.codigo != null) {
                PlainAddress otherAddress = new PlainAddress();
                otherAddress.setDefaultValue(Boolean.TRUE);
                otherAddress.setAddressLine1("[" + f.fincaNombre + "] " + f.fincaDireccion);
                //otherAddress.setPostalCode(f.fincaCodigoPostal);
                otherAddress.setCity(f.fincaCiudad);
                otherAddress.setProvince(f.fincaProvincia);
                //otherAddress.setCountry(f.fincaPais);
                customerCRM.getAddressList().add(otherAddress);
            }
        }
    }

    private static void assignAddress(Cliente cliente, CustomerCRM customerCRM)
    {
        PlainAddress address = new PlainAddress();
        address.setDefaultValue(Boolean.TRUE);
        address.setAddressLine1("[SEDE] " + Optional.ofNullable(cliente.clienteDireccion).orElse(""));
        address.setPostalCode(cliente.clienteCodigoPostal);
        address.setCity(cliente.clienteCiudad);
        address.setProvince(cliente.clienteProvincia);
        //address.setCountry(cliente.clientePais);

        customerCRM.getAddressList().add(address);
    }

    private static void assignLastModification(Cliente cliente, CustomerCRM customerCRM)
    {
        if (cliente.ultimaModificacion != null) {
            try {
                Calendar lastModification = Calendar.getInstance();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date parse = dateFormat.parse(cliente.ultimaModificacion);
                lastModification.setTime(parse);
                customerCRM.setLastModification(lastModification);
            } catch (ParseException ex) {
                Logger.getLogger(ClienteToCustomerConverter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
