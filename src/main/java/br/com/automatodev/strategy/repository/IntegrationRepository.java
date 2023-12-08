package br.com.automatodev.strategy.repository;

import java.util.List;

import br.com.automatodev.strategy.dto.Integration;

public interface IntegrationRepository {

    /* ------------------------------------------------------------------------------------------------------*/

    List<Integration> findByStatus(int status);

    /* ------------------------------------------------------------------------------------------------------*/
}
