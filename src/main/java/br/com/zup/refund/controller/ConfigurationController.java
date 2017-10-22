package br.com.zup.refund.controller;

import br.com.zup.refund.model.to.ConfigurationInformationTO;
import br.com.zup.refund.service.ConfigurationInformationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigurationController extends MainController{

    private ConfigurationInformationService configurationInformationService;

    public ConfigurationController(ConfigurationInformationService configurationInformationService){
        this.configurationInformationService = configurationInformationService;
    }

    @GetMapping("/configurations")
    public ResponseEntity<?> getConfigurations(){
        ConfigurationInformationTO configurations = new ConfigurationInformationTO().map(configurationInformationService.getConfigurations());
        return responseOk(configurations);
    }
}
