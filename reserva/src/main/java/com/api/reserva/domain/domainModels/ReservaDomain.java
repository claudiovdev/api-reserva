package com.api.reserva.domain.domainModels;

import com.api.reserva.infrastructure.enums.StatusReserva;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
public class ReservaDomain {

    private String id;
    private String titulo;
    private String descricao;
    private String status;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataInicialDaReserva;
    private LocalDateTime dataFinalDaReserva;
    private LocalDateTime dataAtualização;
}
