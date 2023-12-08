package br.com.automatodev.strategy.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import br.com.automatodev.strategy.enums.EnumName;
import br.com.automatodev.strategy.enums.EnumStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Integration implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private UUID id;
    
    private EnumName name;

    private LocalDateTime updateAt;

    private EnumStatus status;
}
