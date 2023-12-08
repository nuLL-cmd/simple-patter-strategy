package br.com.automatodev.strategy.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.automatodev.strategy.dto.ReturnProcess;
import br.com.automatodev.strategy.enums.EnumName;
import br.com.automatodev.strategy.pattern.FastShippingStrategy;
import br.com.automatodev.strategy.pattern.strategy.IntegrationPayment;
import br.com.automatodev.strategy.pattern.strategy.IntegrationSent;
import br.com.automatodev.strategy.pattern.strategy.IntegrationSeparation;
import br.com.automatodev.strategy.repository.IntegrationRepository;
import br.com.automatodev.strategy.service.FastShippingService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FastShippingServiceImpl implements FastShippingService{

    @Autowired
    private IntegrationRepository integrationRepository;

    private final Map<EnumName, FastShippingStrategy> fastStrategyMap = Map.of(

        EnumName.INTEGRATION_PAYMENT, new IntegrationPayment(),
        EnumName.INTEGRATION_SEPARATION, new IntegrationSeparation(),
        EnumName.INTEGRATION_SENT, new IntegrationSent()
    );

    
    /* ------------------------------------------------------------------------------------------------------*/

    @Override
    public List<ReturnProcess> processIntegration(Long logId, EnumName nameIntegration) {

        List<ReturnProcess> results = new ArrayList<>();
      
        log.info("Processing integration");

        integrationRepository.fetchIntegration(nameIntegration).forEach(integration -> {

            results.add(fastStrategyMap.get(nameIntegration).processShipping(logId, integration));
        });

        return results;

    }

    
    /* ------------------------------------------------------------------------------------------------------*/
    
}
