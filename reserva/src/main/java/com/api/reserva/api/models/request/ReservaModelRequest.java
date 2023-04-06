package com.api.reserva.api.models.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReservaModelRequest {

    private String titulo;

    private String descricao;

    private LocalDateTime dataInicialDaReserva;

    private LocalDateTime dataFinalDaReserva;
}
