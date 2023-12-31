package br.com.automatodev.strategy.repository;

import java.util.List;

import br.com.automatodev.strategy.dto.Integration;
import br.com.automatodev.strategy.enums.EnumName;

public interface IntegrationRepository {

    /* ------------------------------------------------------------------------------------------------------*/

    List<Integration> fetchIntegration(EnumName nameIntegration);

    /* ------------------------------------------------------------------------------------------------------*/
}
