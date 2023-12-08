package br.com.automatodev.strategy.pattern.strategy;

import org.springframework.http.HttpStatus;

import br.com.automatodev.strategy.dto.Integration;
import br.com.automatodev.strategy.dto.ReturnProcess;
import br.com.automatodev.strategy.pattern.FastShippingStrategy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IntegrationPayment implements FastShippingStrategy{

    /* ------------------------------------------------------------------------------------------------------*/

    @Override
    public ReturnProcess processShipping(Long logId, Integration integration) {
      
        log.info("Processing payment integration.");

        return ReturnProcess.builder()
        .idIntegration(integration.getId())
        .integrationName(integration.getName())
        .message("Success")
        .status(HttpStatus.OK)
        .build();
    }

    /* ------------------------------------------------------------------------------------------------------*/
    
}
