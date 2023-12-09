package br.com.automatodev.strategy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.automatodev.strategy.dto.ReturnProcess;
import br.com.automatodev.strategy.enums.EnumName;
import br.com.automatodev.strategy.service.FastShippingService;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("api/process")
public class IntegrationController {

    @Autowired
    private FastShippingService fastShippingService;

    @GetMapping(value = "integrations", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<ReturnProcess>> processIntegrationsByName(@RequestParam EnumName name) {
        
        Long logId = new Random().nextLong();
        List<ReturnProcess> results = this.fastShippingService.processIntegration(logId, name );

        if(results.isEmpty()) return ResponseEntity.noContent().build();

        return ResponseEntity.ok(results);
        
    }
    
    
}

