package br.com.zup.refund.converters;

import org.modelmapper.PropertyMap;

import br.com.zup.refund.model.ConfigurationInformation;
import br.com.zup.refund.model.to.ConfigurationInformationTO;

public class ConfigurationConverter extends PropertyMap <ConfigurationInformation, ConfigurationInformationTO>{

    @Override
    protected void configure() {
        
    }
}
