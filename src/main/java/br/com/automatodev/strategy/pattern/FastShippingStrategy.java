package br.com.automatodev.strategy.pattern;

import br.com.automatodev.strategy.dto.Integration;
import br.com.automatodev.strategy.dto.ReturnProcess;

public interface FastShippingStrategy {

    /* ------------------------------------------------------------------------------------------------------*/

    ReturnProcess processShipping(Long logId, Integration integration);

    /* ------------------------------------------------------------------------------------------------------*/
    
}
