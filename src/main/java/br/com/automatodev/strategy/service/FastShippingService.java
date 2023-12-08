package br.com.automatodev.strategy.service;

import java.util.List;

import br.com.automatodev.strategy.dto.ReturnProcess;
import br.com.automatodev.strategy.enums.EnumName;

public interface FastShippingService {

    /* ------------------------------------------------------------------------------------------------------*/
    
    List<ReturnProcess> processIntegration(Long logId, EnumName nameIntegration);

    /* ------------------------------------------------------------------------------------------------------*/

}
