package br.com.zup.refund.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.refund.model.ConfigurationInformation;
import br.com.zup.refund.repository.ConfigurationInformationRepository;
import br.com.zup.refund.service.ConfigurationInformationService;

@Service
public class ConfigurationInformationServiceImpl implements ConfigurationInformationService {

    private ConfigurationInformationRepository configurationInformationRepository;

    @Autowired
    public ConfigurationInformationServiceImpl(ConfigurationInformationRepository configurationInformationRepository){
        this.configurationInformationRepository = configurationInformationRepository;
    }

    public ConfigurationInformation getConfigurations(){
        return configurationInformationRepository.findAll().get(0);
    }

}
