package br.com.automatodev.strategy.repository.implementation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import br.com.automatodev.strategy.dto.Integration;
import br.com.automatodev.strategy.enums.EnumName;
import br.com.automatodev.strategy.enums.EnumStatus;
import br.com.automatodev.strategy.repository.IntegrationRepository;

public class IntegrationRepositoryImpl implements IntegrationRepository{

    /* ------------------------------------------------------------------------------------------------------*/

    @Override
    public List<Integration> findByStatus(int status) {

        return List.of(

        Integration.builder()
        .id(UUID.randomUUID())
        .updateAt(LocalDateTime.now())
        .name(EnumName.INTEGRATION_PAYMENT)
        .status(EnumStatus.WAIT)
        .build(),
         Integration.builder()
        .id(UUID.randomUUID())
        .updateAt(LocalDateTime.now())
        .name(EnumName.INTEGRATION_SENT)
        .status(EnumStatus.WAIT)
        .build(),
         Integration.builder()
        .id(UUID.randomUUID())
        .updateAt(LocalDateTime.now())
        .name(EnumName.INTEGRATION_SEPARATION)
        .status(EnumStatus.WAIT)
        .build()

        );

    }

    /* ------------------------------------------------------------------------------------------------------*/
    
}
