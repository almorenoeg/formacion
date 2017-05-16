/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terralcode.gestion.domain.config;

import com.naoset.framework.domain.config.ConfigProvider;

/**
 *
 * @author jmsuarez
 */
public class ConfigProviderCRM extends ConfigProvider {

    @Override
    public String getProductName() {
        return "CRM";
    }
    
}
