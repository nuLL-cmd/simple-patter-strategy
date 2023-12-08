package br.com.automatodev.strategy.dto;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.http.HttpStatus;

import br.com.automatodev.strategy.enums.EnumName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReturnProcess implements Serializable{

    private static final long serialVersionUID = 1L;

    private UUID idIntegration;

    private EnumName integrationName;

    private String message;

    private HttpStatus status;

}