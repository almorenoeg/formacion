package com.terralcode.gestion.business.deploy;

import com.naoset.framework.business.service.user.UserService;
import com.terralcode.framework.domain.profile.User;
import com.terralcode.framework.domain.Direccion;
import com.terralcode.framework.domain.alumno.Alumno;
import com.terralcode.framework.domain.alumno.EstadosAlumnos;
import com.terralcode.framework.domain.catalogos.EstadoOcupacional;
import com.terralcode.framework.domain.catalogos.Sexo;
import com.terralcode.framework.domain.grupoformativo.EstadoGrupo;
import com.terralcode.framework.domain.role.RoleUser;
import com.terralcode.framework.domain.role.TipoRole;
import com.terralcode.gestion.business.alumnos.AlumnosService;
import com.terralcode.gestion.business.alumnos.DireccionService;
import com.terralcode.gestion.business.catalogos.ColectivoService;
import com.terralcode.gestion.business.catalogos.EstadoGrupoService;
import com.terralcode.gestion.business.catalogos.EstadoOcupacionalService;
import com.terralcode.gestion.business.catalogos.EstadosAlumnosService;
import com.terralcode.gestion.business.catalogos.RoleUserService;
import com.terralcode.gestion.business.catalogos.SexoService;
import java.util.GregorianCalendar;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author Ezequiel
 */
@Startup
@Singleton
public class DBPopulator {

    
//    @Inject
//    TradeService tradeService;
//    @Inject
//    SpeciesService speciesService;
//    @Inject
//    CustomerStatusService customerStatusService;
//    @Inject
//    CustomerTypeService customerTypeService;
//    @Inject
//    CustomerCRMService customerCRMService;
//    @Inject
//    AppointmentService appointmentService;
//    @Inject
//    AppointmentStatusService appointmentStatusService;
//    @Inject
//    AppointmentReasonService appointmentReasonService;
//    @Inject
//    TimeLapseService timeLapseService;
//    @Inject
//    ComplaintTypeService complaintTypeService;
//    @Inject
//    AppointmentTypeService appointmentTypeService;
//    @Inject
//    ComplaintsService complaintService;
//    @Inject
//    SalesService salesService;
//    @Inject
//    AppointmentPurposeService purposeService;
    @Inject
    UserService userService;
    @Inject
    EstadosAlumnosService estadosAlumnosServices;
    @Inject
    EstadoOcupacionalService estadoOcupacionalService;
    @Inject
    ColectivoService colectivoService;
    @Inject
    RoleUserService roleUserService;
    
    @Inject
    AlumnosService alumnosService;        
        
    @Inject
    SexoService sexoService;
    
    @Inject
    DireccionService direccionService;
    
    User user;
    RoleUser role;
    
    @Inject
    EstadoGrupoService estadoGrupoService;

    @PostConstruct
    public void init() {
        if (userService.count() == 0) {
            
//            populateNaosetUsers();
//            populateCatalogs();
//            populateNaosetTrades();
//            populateNaosetCustomers();
//            populateNaosetAppointments();
//            populateNaosetSales();
            
            populateTestUsers();
            populateCatalogs();
  
            populateAlumnos();
//            populateNugestTrades();
            
        }
    }

    private void populateTestUsers() {
        //Administrador para pruebas.
        user = new User();
        user.setEmail("v");
        user.setPassword("v");
        user.setFirstName("test");
        user.setLastName("ADMIN");
        user.setPhone("+34952000000");
        user.setRoleUser(TipoRole.ADMIN.getCode());
        user = userService.create(user);

        user = new User();
        user.setEmail("captador");
        user.setPassword("c");
        user.setFirstName("test");
        user.setLastName("CAPTADOR");
        user.setPhone("+34952000000");
        user.setRoleUser(TipoRole.CAPTADOR.getCode());
        user = userService.create(user);

        user = new User();
        user.setEmail("gestoraccion");
        user.setPassword("ga");
        user.setFirstName("Test");
        user.setLastName("GESTOR ACCION");
        user.setPhone("+34952000000");
        user.setRoleUser(TipoRole.GESTOR_ACCION.getCode());
        user = userService.create(user);

        user = new User();
        user.setEmail("gestorplataforma");
        user.setPassword("gp");
        user.setFirstName("Test");
        user.setLastName("GESTOR PLATAFORMA");
        user.setPhone("+34952000000");
        user.setRoleUser(TipoRole.GESTOR_PLATAFORMA.getCode());
        user = userService.create(user);

        user = new User();
        user.setEmail("validador");
        user.setPassword("v");
        user.setFirstName("Test");
        user.setLastName("VALIDADOR");
        user.setPhone("+34952000000");
        user.setRoleUser(TipoRole.VALIDADOR.getCode());
        user = userService.create(user);
    }

    
    private void populateCatalogs() {
        
        EstadoOcupacional f = estadoOcupacionalService.create(new EstadoOcupacional("1", "Administración pública") );
        estadoOcupacionalService.create(new EstadoOcupacional("2", "Cuidadores no profesionales de las personas en situación de dependencia") );
        estadoOcupacionalService.create(new EstadoOcupacional("3", "Empleado hogar") );
        estadoOcupacionalService.create(new EstadoOcupacional("4", "Fijos discontinuos en períodos de no ocupación") );
        estadoOcupacionalService.create(new EstadoOcupacional("5", "Mutualistas de Colegios Profesionales no incluidos como autónomos") );
        estadoOcupacionalService.create(new EstadoOcupacional("6", "Participante considerado desempleado tras comprobación en la Tesorería General de la Seguridad Social") );
        estadoOcupacionalService.create(new EstadoOcupacional("7", "Participante considerado ocupado tras comprobación en la Tesorería General de la Seguridad Social") );
        estadoOcupacionalService.create(new EstadoOcupacional("8", "Régimen especial agrario por cuenta ajena") );
        
        Sexo resu = sexoService.create(new Sexo(Sexo.HOMBRE, "Hombre"));
        resu = sexoService.create(new Sexo(Sexo.MUJER, "Mujer"));
        resu = sexoService.create(new Sexo(Sexo.INDETERMINADO, "Indeterminado"));
        
        EstadosAlumnos w = estadosAlumnosServices.create(new EstadosAlumnos(EstadosAlumnos.INTERESADO, "Interesados"));
        estadosAlumnosServices.create(new EstadosAlumnos(EstadosAlumnos.VALIDADO, "Validado"));
        estadosAlumnosServices.create(new EstadosAlumnos(EstadosAlumnos.INICIAL, "Inicial"));
        estadosAlumnosServices.create(new EstadosAlumnos(EstadosAlumnos.RESERVA, "Reserva"));
        estadosAlumnosServices.create(new EstadosAlumnos(EstadosAlumnos.BAJA, "Baja"));
        estadosAlumnosServices.create(new EstadosAlumnos(EstadosAlumnos.FINALIZADO, "Finalizado"));
        estadosAlumnosServices.create(new EstadosAlumnos(EstadosAlumnos.ABANDONO, "Abandono"));
        
        direccionService.create(dameDireccion(1));
        direccionService.create(dameDireccion(2));
        direccionService.create(dameDireccion(3));
        
        
        estadoGrupoService.create(new EstadoGrupo("ABI", "ABIERTO"));
        estadoGrupoService.create(new EstadoGrupo("CER", "CERRADO"));

        
    }
    
    private void populateRoles() {
        roleUserService.create(new RoleUser());
    }
    
    
    private void populateAlumnos() {
        Alumno alumno01 = new Alumno();
        alumno01.setNombre("Prueba01");
        alumno01.setApellido1("Ape01");
        alumno01.setApellido2("Ape02");
        alumno01.setDni("12345678Z");
        alumno01.setEstado(EstadosAlumnos.INICIAL);
        alumno01.setDerivadoINEM(false);        
        alumno01.setDireccion(dameDireccion(1));
        alumno01.setDiscapacidad(false);
        alumno01.setEmail("prueba01@testemail.es");
        alumno01.setFechaNacimiento(new GregorianCalendar(2000, 1, 15));
        alumno01.setMovil("66987412");
        alumno01.setSexo(sexoService.findByCode(Sexo.HOMBRE));
        alumno01.setNumeroSSGG("1598745682");
        alumnosService.create(alumno01);
        
        Alumno alumno02 = new Alumno();
        alumno02.setNombre("Prueba02");
        alumno02.setApellido1("Ape01_02");
        alumno02.setApellido2("Ape02_02");
        alumno02.setDni("12345678Z");
        alumno02.setEstado(EstadosAlumnos.INTERESADO);
        alumno02.setDerivadoINEM(false);        
        alumno02.setDireccion(dameDireccion(3));
        alumno02.setDiscapacidad(false);
        alumno02.setEmail("prueba02@testemail.es");
        alumno02.setFechaNacimiento(new GregorianCalendar(2003, 12, 4));
        alumno02.setMovil("85214639");
        alumno02.setSexo(sexoService.findByCode(Sexo.MUJER));
        alumno02.setNumeroSSGG("6547852125");
        alumnosService.create(alumno02);
        
        Alumno alumno03 = new Alumno();
        alumno03.setNombre("Prueba01");
        alumno03.setApellido1("Ape01_03");
        alumno03.setApellido2("Ape02_03");
        alumno03.setDni("12345678Z");
        alumno03.setEstado(EstadosAlumnos.INTERESADO);
        alumno03.setDerivadoINEM(true);        
        alumno03.setDireccion(dameDireccion(2));
        alumno03.setDiscapacidad(true);
        alumno03.setEmail("prueba03@testemail.es");
        alumno03.setFechaNacimiento(new GregorianCalendar(1999, 6, 7));
        alumno03.setMovil("36985214");
        alumno03.setSexo(sexoService.findByCode(Sexo.HOMBRE));
        alumno03.setNumeroSSGG("956487522");
        alumnosService.create(alumno01);
    }
    
    
    private Direccion dameDireccion(int numero) {
        
        Direccion direccion = new Direccion();
        
        switch (numero) {
            case 1:
                direccion.setCiudad("Malaga");
                direccion.setCodigoPostal("29007");
                direccion.setDireccion("C/ Nueva 32 5º A");
                direccion.setProvincia("Malaga");
                
                break;
            case 2:
                direccion.setCiudad("Madrid");
                direccion.setCodigoPostal("28007");
                direccion.setDireccion("Avd. del trapiche");
                direccion.setProvincia("Madrid");
                break;
            case 3:
                direccion.setCiudad("Aguilas");
                direccion.setCodigoPostal("30880");
                direccion.setDireccion("Urb. Miñambre 45");
                direccion.setProvincia("Murcia");
                break;
            case 4:
                direccion.setCiudad("Madrid");
                direccion.setCodigoPostal("28080");
                direccion.setDireccion("Plaza Mitjana Nº 46 Esc. Izq 7º DER");
                direccion.setProvincia("Madrid");
                break;
            case 5:
                direccion.setCiudad("Alcorcon");
                direccion.setCodigoPostal("28920");
                direccion.setDireccion("C/ Vieja 2");
                direccion.setProvincia("Madrid");
                break;
            case 6:
                direccion.setCiudad("Malaga");
                direccion.setCodigoPostal("29007");
                direccion.setDireccion("C/ Nueva 32 5º A");
                direccion.setProvincia("Malaga");
                break;
            case 7:
                direccion.setCiudad("Malaga");
                direccion.setCodigoPostal("29007");
                direccion.setDireccion("C/ Nueva 32 5º A");
                direccion.setProvincia("Malaga");
                break;
            default:
                direccion.setCiudad("Malaga");
                direccion.setCodigoPostal("29007");
                direccion.setDireccion("C/ Nueva 32 5º A");
                direccion.setProvincia("Malaga");
                break;
        }
        
        
        return direccion;
    }

//    private void populateNaosetTrades() {
//        tradeService.create(new Trade("Alvaro", userService.findByEmail("alvaro_moreno@hotmail.com")));
//        tradeService.create(new Trade("Jose Manuel", userService.findByEmail("jmsuarez@naoset.com")));
//        tradeService.create(new Trade("Ezequiel", userService.findByEmail("ezequiel.antunez.camacho@gmail.com")));
//        tradeService.create(new Trade("Fernando", userService.findByEmail("fferrer@naoset.com")));
//    }
//    
//    private void populateNugestTrades() {
//        tradeService.create(new Trade("María", userService.findByEmail("mtocon@nugest.es")));
//        tradeService.create(new Trade("Gonzalo", userService.findByEmail("gfructuoso@nugest.es")));
//        tradeService.create(new Trade("Fernando", userService.findByEmail("fmontero@nugest.es")));
//    }
    
//    private void populateNaosetCustomers() {
//
//        CustomerCRM customer;
//        ContactInfo ci;
//        PlainAddress pa;
//
//        //Almacenes Lusan S.L.
//        customer = new CustomerCRM();
//        customer.setCode("LUSAN");
//        customer.setName("Almacenes Lusan SL");
//        customer.setApproved(Boolean.TRUE);
//        customer.setCustomerStatus(customerStatusService.findByCode("CO"));
//        customer.setCompanyTaxCode("123456789N");
//        //customer.getSpecies().add(speciesService.findByCode("OTRO"));
//
//        ci = new ContactInfo();
//        ci.setContactPerson("Mario Lusan");
//        ci.setContactType(ContactType.Telephone);
//        ci.setInfo("951111101");
////        ci.setContactType(ContactType.Email);
////        ci.setInfo("mario@almaceneslusan.com");
//        ci.setComments("Es el gerente de la empresa");
//        customer.getContactInfoList().add(ci);
//
//        ci = new ContactInfo();
//        ci.setContactPerson("Ignacio Rodriguez");
//        ci.setContactType(ContactType.Telephone);
//        ci.setInfo("951111102");
////        ci.setContactType(ContactType.Email);
////        ci.setInfo("ignacio@almaceneslusan.com");
//        ci.setComments("Comercial con experiencia. Buen amigo de Joaquín");
//        customer.getContactInfoList().add(ci);
//
//        pa = new PlainAddress();
//        pa.setCountry("España");
//        pa.setProvince("Málaga");
//        pa.setCity("Cuevas de San Marcos");
//        pa.setAddressLine1("[SEDE] Prol. Granada, 85 , 29210");
//        pa.setDefaultValue(Boolean.TRUE);
//        customer.getAddressList().add(pa);
//
//        pa = new PlainAddress();
//        pa.setCountry("España");
//        pa.setProvince("Málaga");
//        pa.setCity("Churriana");
//        pa.setAddressLine1("[FINCA] Cno. Huerta, 55");
//        pa.setDefaultValue(Boolean.FALSE);
//        customer.getAddressList().add(pa);
//
//        customerCRMService.create(customer);
//
//        //Sarriana de piensos, SA...
//        customer = new CustomerCRM();
//        customer.setCode("SARR");
//        customer.setName("Sarriana de piensos, SA");
//        customer.setApproved(Boolean.TRUE);
//        customer.setCustomerStatus(customerStatusService.findByCode("CC"));
//        customer.setCompanyTaxCode("987654321R");
//        customer.getSpecies().add(speciesService.findByCode("OTRO"));
//
//        ci = new ContactInfo();
//        ci.setContactPerson("José Miguel Rizos");
//        ci.setContactType(ContactType.Telephone);
//        ci.setInfo("951222101");
////        ci.setContactType(ContactType.Email);
////        ci.setInfo("jmrizos@sarriapin.com");
//        ci.setComments("Jefe de compras");
//        customer.getContactInfoList().add(ci);
//
//        ci = new ContactInfo();
//        ci.setContactPerson("Laura poveda");
//        ci.setContactType(ContactType.Telephone);
//        ci.setInfo("951222102");
////        ci.setContactType(ContactType.Email);
////        ci.setInfo("laura@sarriapin.com");
//        ci.setComments("Ingeniera agrónoma");
//        customer.getContactInfoList().add(ci);
//
//        pa = new PlainAddress();
//        pa.setCountry("España");
//        pa.setProvince("Lugo");
//        pa.setCity("Sarria");
//        pa.setAddressLine1("[SEDE] Pq San Vicente de Betote - Lg. Balmao s/n 3");
//        pa.setDefaultValue(Boolean.TRUE);
//        customer.getAddressList().add(pa);
//
//        pa = new PlainAddress();
//        pa.setCountry("España");
//        pa.setProvince("Pontevedra");
//        pa.setCity("Valga");
//        pa.setAddressLine1("[MOLINO] Lg Setecoros - Bronllo");
//        pa.setDefaultValue(Boolean.FALSE);
//        customer.getAddressList().add(pa);
//
//        customerCRMService.create(customer);
//
//        //Los Mañicos...
//        customer = new CustomerCRM();
//        customer.setCode("LOSMAN");
//        customer.setName("Los Mañicos - Herederos de Primitivo Aznar");
//        customer.setApproved(Boolean.TRUE);
//        customer.setCustomerStatus(customerStatusService.findByCode("CP"));
//        customer.setCompanyTaxCode("B93155000");
//        customer.getSpecies().add(speciesService.findByCode("PORIB"));
//
//        ci = new ContactInfo();
//        ci.setContactPerson("Carlos Jesús Cerón");
//        ci.setContactType(ContactType.Telephone);
//        ci.setInfo("951333101");
////        ci.setContactType(ContactType.Email);
////        ci.setInfo("cceron@losmanicos.com");
//        ci.setComments("Jefe");
//        customer.getContactInfoList().add(ci);
//
//        pa = new PlainAddress();
//        pa.setCountry("España");
//        pa.setProvince("Zaragoza");
//        pa.setCity("La Muela");
//        pa.setAddressLine1("[SEDE] Carretera Madrid-Zaragoza, km 298");
//        pa.setDefaultValue(Boolean.FALSE);
//        customer.getAddressList().add(pa);
//
//        pa = new PlainAddress();
//        pa.setCountry("España");
//        pa.setProvince("Badajoz");
//        pa.setCity("Badajoz");
//        pa.setAddressLine1("[MOLINO] C/ Baldomero, 5");
//        pa.setDefaultValue(Boolean.TRUE);
//        customer.getAddressList().add(pa);
//
//        customerCRMService.create(customer);
//
////        for (Integer i = 0; i < 30; i++) {
////            //Los Mañicos...
////            customer = new CustomerCRM();
////            customer.setCode("CUSTOMER" + i.toString());
////            customer.setName("Customer" + i.toString());
////            customer.setApproved(Boolean.TRUE);
////            customer.setCustomerStatus(new CustomerStatus("CP", "Cliente Potencial"));
////            customer.setCompanyTaxCode("B93155000");
////            customerCRMService.create(customer);
////        }
//    }
//
//    private void populateNaosetAppointments() {
//        Appointment app;
//        List<CustomerCRM> customers;
//        List<Trade> trades;
//        Calendar cal;
//        Random random = new Random();
//
//        customers = customerCRMService.findAll();
//        trades = tradeService.findAll();
//        cal = Calendar.getInstance();
//
//        //Cita para LUSAN
//        app = new Appointment();
//        cal = Calendar.getInstance();
//        app.setProgramDateStart(cal);
//        app.setTimeLapse(timeLapseService.findByCode("h1"));
//        cal = Calendar.getInstance();
//        cal.add(Calendar.HOUR_OF_DAY, 1 + random.nextInt(2));
//        app.setProgramDateEnd(cal);
//        app.setAppointmentType(appointmentTypeService.findByCode("COM"));
//        app.setAppointmentReason(appointmentReasonService.findByCode("COI"));
//        app.setStatus(appointmentStatusService.findByCode("PRG"));
//        app.setNotifyChanges(false);
//        app.setCustomer(customers.get(0));
//        app.setAddress(customers.get(0).getAddressList().get(0));
//        app.setContactInfo(customers.get(0).getContactInfoList().get(0));
//        app.getTrades().add(trades.get(0));
//        appointmentService.create(app);
//
//        //Cita con Sarria
//        CustomerCRM apple = customerCRMService.findByCode("SARR");
//        app = new Appointment();
//        cal = Calendar.getInstance();
//        cal.add(Calendar.DAY_OF_MONTH, 1);
//        app.setProgramDateStart(cal);
//        app.setTimeLapse(timeLapseService.findByCode("h1"));
//        cal = Calendar.getInstance();
//        cal.add(Calendar.DAY_OF_MONTH, 1);
//        cal.add(Calendar.HOUR_OF_DAY, 1 + random.nextInt(2));
//        app.setProgramDateEnd(cal);
//        app.setAppointmentType(appointmentTypeService.findByCode("VIS"));
//        app.setAppointmentReason(appointmentReasonService.findByCode("COI"));
//        app.setStatus(appointmentStatusService.findByCode("PRG"));
//        app.setNotifyChanges(false);
//        app.setCustomer(apple);
//        app.setAddress(apple.getAddressList().get(0));
//        app.setContactInfo(apple.getContactInfoList().get(0));
//        app.getTrades().add(trades.get(2));
//        app.getTrades().add(trades.get(3));
//        appointmentService.create(app);
//
//        //Los mañicos
//        CustomerCRM jamonamour = customerCRMService.findByCode("LOSMAN");
//        app = new Appointment();
//        cal = Calendar.getInstance();
//        cal.add(Calendar.DAY_OF_MONTH, 2);
//        app.setProgramDateStart(cal);
//        app.setTimeLapse(timeLapseService.findByCode("h1"));
//        cal = Calendar.getInstance();
//        cal.add(Calendar.DAY_OF_MONTH, 2);
//        cal.add(Calendar.HOUR_OF_DAY, 1 + random.nextInt(2));
//        app.setProgramDateEnd(cal);
//        app.setAppointmentType(appointmentTypeService.findByCode("VIS"));
//        app.setAppointmentReason(appointmentReasonService.findByCode("COI"));
//        app.setStatus(appointmentStatusService.findByCode("PRG"));
//        app.setNotifyChanges(false);
//        app.setCustomer(jamonamour);
//        app.setAddress(jamonamour.getAddressList().get(0));
//        app.setContactInfo(jamonamour.getContactInfoList().get(0));
//        app.getTrades().add(trades.get(1));
//
//        Complaint complaint1 = new Complaint(
//                complaintTypeService.findByCode("TRANS"),
//                "El último pedido llegó dos días después de lo acordado.");
//        Complaint complaint2 = new Complaint(
//                complaintTypeService.findByCode("OTRO"),
//                "Paquete deteriorado");
//        complaint2.setName("Las últimas cajas han llegado con muestras de humedad");
//
//        app.getComplaints().add(complaint1);
//        app.getComplaints().get(0).setAppointment(app);
//        app.getComplaints().add(complaint2);
//        app.getComplaints().get(1).setAppointment(app);
//        appointmentService.create(app);
//    }
//
//    private void populateNaosetSales() {
//        Sales sale;
//        List<CustomerCRM> customers = customerCRMService.findAll();
//
//        for (int i = 0; i < customers.size(); i++) {
//            sale = new Sales();
//
//            sale.setCustomer(customers.get(i));
//
//            switch (i) {
//                case 0:
//                    sale.setDateSale(new GregorianCalendar(2013, 3, 31));
//                    sale.setAmount(new Double(6));
//                    sale.setDescription("Sacos maiz");
//                    sale.setPrice(new Double(12));
//                    break;
//                case 1:
//                    sale.setDateSale(new GregorianCalendar(2013, 5, 20));
//                    sale.setAmount(new Double(78));
//                    sale.setDescription("Sacos trigo");
//                    sale.setPrice(new Double(3));
//                    break;
//                case 2:
//                    sale.setDateSale(new GregorianCalendar(2014, 1, 15));
//                    sale.setAmount(new Double(30));
//                    sale.setDescription("Sacos avena");
//                    sale.setPrice(new Double(53));
//                    break;
//            }
//
//            salesService.create(sale);
//        }
//
//    }

}
