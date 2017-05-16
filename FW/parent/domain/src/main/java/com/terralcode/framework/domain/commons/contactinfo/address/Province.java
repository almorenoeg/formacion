/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.framework.domain.commons.contactinfo.address;

import com.terralcode.framework.domain.DomainEntity;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author jmsuarez
 */
@Entity
public class Province extends DomainEntity{
    private static final long serialVersionUID = 1L;
    protected String code = "";
    protected String name = "";
    protected Country country;
    
    public Province() {
        super();
    }
    public Province(String code, String name) {
        this();
        this.code = code;
        this.name = name;
    }
    
    @NotEmpty
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @NotEmpty
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
    
    
}

/*
<option value="">-- Seleccione una Provincia --</option>
	<option value="15">A CORU&#209;A</option>
	<option value="3">ALACANT</option>
	<option value="2">ALBACETE</option>
	<option value="4">ALMERIA</option>
	<option value="33">ASTURIAS</option>
	<option value="5">AVILA</option>
	<option value="6">BADAJOZ</option>
	<option value="8">BARCELONA</option>
	<option value="9">BURGOS</option>
	<option value="10">CACERES</option>
	<option value="11">CADIZ</option>
	<option value="39">CANTABRIA</option>
	<option value="12">CASTELLO</option>
	<option value="51">CEUTA</option>
	<option value="13">CIUDAD REAL</option>
	<option value="14">CORDOBA</option>
	<option value="16">CUENCA</option>
	<option value="17">GIRONA</option>
	<option value="18">GRANADA</option>
	<option value="19">GUADALAJARA</option>
	<option value="21">HUELVA</option>
	<option value="22">HUESCA</option>
	<option value="7">ILLES BALEARS</option>
	<option value="23">JAEN</option>
	<option value="26">LA RIOJA</option>
	<option value="35">LAS PALMAS</option>
	<option value="24">LEON</option>
	<option value="25">LLEIDA</option>
	<option value="27">LUGO</option>
	<option value="28">MADRID</option>
	<option value="29">MALAGA</option>
	<option value="52">MELILLA</option>
	<option value="30">MURCIA</option>
	<option value="32">OURENSE</option>
	<option value="34">PALENCIA</option>
	<option value="36">PONTEVEDRA</option>
	<option value="38">S.C. TENERIFE</option>
	<option value="37">SALAMANCA</option>
	<option value="40">SEGOVIA</option>
	<option value="41">SEVILLA</option>
	<option value="42">SORIA</option>
	<option value="43">TARRAGONA</option>
	<option value="44">TERUEL</option>
	<option value="45">TOLEDO</option>
	<option value="46">VALENCIA</option>
	<option value="47">VALLADOLID</option>
	<option value="49">ZAMORA</option>
	<option value="50">ZARAGOZA</option>
*/