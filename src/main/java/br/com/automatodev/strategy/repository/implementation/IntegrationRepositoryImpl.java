package br.com.automatodev.strategy.repository.implementation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.com.automatodev.strategy.dto.Integration;
import br.com.automatodev.strategy.enums.EnumName;
import br.com.automatodev.strategy.enums.EnumStatus;
import br.com.automatodev.strategy.repository.IntegrationRepository;

@Repository("integrationRepository")
public class IntegrationRepositoryImpl implements IntegrationRepository{

    /* ------------------------------------------------------------------------------------------------------*/

    @Override
    public List<Integration> fetchIntegration(EnumName nameIntegration) {

        return List.of(

        Integration.builder()
        .id(UUID.randomUUID())
        .updateAt(LocalDateTime.now())
        .name(nameIntegration)
        .status(EnumStatus.WAIT)
        .build(),
         Integration.builder()
        .id(UUID.randomUUID())
        .updateAt(LocalDateTime.now())
        .name(nameIntegration)
        .status(EnumStatus.WAIT)
        .build(),
         Integration.builder()
        .id(UUID.randomUUID())
        .updateAt(LocalDateTime.now())
        .name(nameIntegration)
        .status(EnumStatus.WAIT)
        .build()

        );

    }

    /* ------------------------------------------------------------------------------------------------------*/

    
}
